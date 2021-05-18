/**
 * @author: Tuohuang Li
 * @ID: 1205166
 * @EMAIL: tuohuangl@student.unimelb.edu.au
 * @2021
 */

import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JPanel;



public class WhiteBoardDrawPanel extends JPanel implements MouseListener, MouseMotionListener {

    private WhiteBoardFrame wb; //to get color

    //private Graphics g;//Allows an application to draw or paint onto Components
    private String cmd;//read command on buttons

    private String type = "Line";
    private int x1,y1,x2,y2;//mouse click positions and mouse release positions

    //Vector<Info> infos = new Vector<Info>();


    WhiteBoardDrawPanel(WhiteBoardFrame wb) {
        this.wb = wb;
        this.addMouseListener(this);
    }


    public void setType(String type) {
        this.type = type;
    }


    public void mousePressed(MouseEvent e) {
        //the start point
        x1 = e.getX();
        y1 = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        int width, height;
        width = Math.abs(x2-x1);
        height = Math.abs(y2-y1);

        Graphics2D g = (Graphics2D) this.getGraphics();
        g.setColor(wb.currentColor);

        if (type.equalsIgnoreCase("line")) {
            g.drawLine(x1, y1, x2, y2);

        } else if (type.equalsIgnoreCase("Circle")) {

            int r = (int) Math.sqrt(Math.pow(width,2) + Math.pow(height, 2));
            int x = x1-(r/2);
            int y = y1-(r/2);
            g.drawOval(x,y,r,r);

        } else if (type.equalsIgnoreCase("Oval")) {
            g.drawOval(x1, y1, width, height);

        } else if (type.equalsIgnoreCase("Curve")){
            g.drawArc(x1,y1,width,height,0, 120);

        }  else if (type.equalsIgnoreCase("Rectangle")) {
            g.drawRect(x1, y1, width, height);

        } else if (type.equalsIgnoreCase("Eraser")){

            g.setColor(this.getBackground());
            g.setStroke(new BasicStroke(30));
            g.draw(new Line2D.Float(x1, y1, x2, y2));

        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

        System.out.println("Mouse entered");
    }
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);     // paint parent's background
        setBackground(Color.WHITE);  // set background color for this JPanel

        // Your custom painting codes. For example,
        // Drawing primitive shapes
        g.setColor(wb.currentColor);    // set the drawing color
        Graphics2D g2 = (Graphics2D) g;

        int width, height;
        width = Math.abs(x2-x1);
        height = Math.abs(y2-y1);

        //drawXxxx: args related to mouth input
        if (type.equalsIgnoreCase("Line")){

            g.drawLine(x1, y1, x2, y2);

        } else if(type.equalsIgnoreCase("Curve")){
            g.drawArc(x1,y1,width,height,0, 120);

        }else if(type.equalsIgnoreCase("Oval")){

            g.drawOval(x1,y1,width,height);

        }else if(type.equalsIgnoreCase("Circle")){

            int r = (int) Math.sqrt(Math.pow(width,2) + Math.pow(height, 2));
            //drawCircle(g, x1, y1, r);
            int x = x1-(r/2);
            int y = y1-(r/2);
            g.drawOval(x,y,r,r);

        }else if(type.equalsIgnoreCase("Rectangle")){

            g.drawRect(x1, y1, width, height);

        } else if (type.equalsIgnoreCase("Eraser")){
            g.setColor(this.getBackground());
            g2.setStroke(new BasicStroke(30));
            g2.draw(new Line2D.Float(x1, y1, x2, y2));

        }else if (type.equalsIgnoreCase("Clear")){

            this.repaint();

        }

        // TODO: Printing texts
        //  TEST!
        g.setFont(new Font("Monospaced", Font.PLAIN, 10));
        g.drawString("Testing string ...", 15, 20);
    }

}
