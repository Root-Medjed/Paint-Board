/**
 * @author: Tuohuang Li
 * @ID: 1205166
 * @EMAIL: tuohuangl@student.unimelb.edu.au
 * @2021
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Client GUI White Board
 */

//@SuppressWarnings("serial")
public class WhiteBoardFrame extends JFrame implements ActionListener, Runnable{

    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;//JButton basic function
    JButton chat, newCanvas, openFile, save, saveAs, close;//Jbutton Advanced function

    JPanel panel1, panel2;

    Color currentColor;// = Color.BLUE;
    WhiteBoardDrawPanel drawPanel = new WhiteBoardDrawPanel(this);//create the draw panel object
    //private Graphics gr;
    protected Image buffer;

    // Initializing UI window (constructor)
    public WhiteBoardFrame() {

        //Title
        setTitle("White Board");
        setSize(900, 670);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        //set layout
        //FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        //setLayout(layout);
        this.setResizable(false);//freeze size
        this.getContentPane().setBackground(Color.BLACK);

        //create canvas buttons
        btn1 = new JButton("Line");
        btn1.addActionListener(this);


        btn2 = new JButton("Curve");
        btn2.addActionListener(this);


        btn3 = new JButton("Oval");
        btn3.addActionListener(this);


        btn4 = new JButton("Circle");
        btn4.addActionListener(this);

        btn5 = new JButton("Rectangle");
        btn5.addActionListener(this);


        btn6 = new JButton("Colors");
        btn6.addActionListener(this);

        btn7 = new JButton("Eraser");
        btn7.addActionListener(this);

        //TODO: Other function buttons
        chat = new JButton("Chat");
        chat.addActionListener(this);

        newCanvas = new JButton("New Canvas");
        newCanvas.addActionListener(this);

        openFile = new JButton("Open");
        openFile.addActionListener(this);

        save = new JButton("Save");
        save.addActionListener(this);

        saveAs = new JButton("Save As");
        saveAs.addActionListener(this);

        close = new JButton("Close");
        close.addActionListener(this);


        //add 3 panels
        //flow layout for panel 1, store "shape buttons"
        panel1=new JPanel(new GridLayout(10, 1,30,1));
        panel1.setPreferredSize(new Dimension(80, 200));
        panel1.setBackground(currentColor);

        panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.setPreferredSize(new Dimension(600,30));

        //canvas panel
        drawPanel.setPreferredSize(new Dimension(600, 450));

        //add buttons to panel 1
        panel1.add(btn1);
        panel1.add(btn2);
        panel1.add(btn3);
        panel1.add(btn4);
        panel1.add(btn5);
        panel1.add(btn7);
        panel1.add(btn6);

        //add buttons to panel 2
        panel2.add(chat);
        panel2.add(newCanvas);
        panel2.add(openFile);
        panel2.add(save);
        panel2.add(saveAs);
        panel2.add(close);

        //TODO: color chooser with 16 COLORS
        //color chooser button btn
        //JButton btn = new JButton("Color chooser");
        //btn.addActionListener((ActionListener) this);   //register color button to action listener

         panel1.setBackground(currentColor);

        //add panels to main frame
        this.add(panel1, BorderLayout.WEST);
        this.add(panel2, BorderLayout.PAGE_END);
        this.add(drawPanel, BorderLayout.CENTER);


        //set visible
        setVisible(true);

        buffer = drawPanel.createImage(this.getSize().width, this.getSize().height);

    }

    public void actionPerformed(ActionEvent e) {

        //TODO: link buttons with actions command
        /**
         * getSource(): returns an object on which the event initially occurred
         */
        if (btn1 == e.getSource()){
            drawPanel.setType("Line");

        } else if (btn2 == e.getSource()){

            drawPanel.setType("Curve");

        } else if (btn3 == e.getSource()){
            drawPanel.setType("Oval");

        } else if (btn4 == e.getSource()){
            drawPanel.setType("Circle");

        } else if (btn5 == e.getSource()){

            drawPanel.setType("Rectangle");

        } else if (btn6 == e.getSource()){
            //JColorChooser colorChooser = new JColorChooser();
            currentColor = JColorChooser.showDialog(null,
                    "Choose a color",currentColor);
            panel1.setBackground(currentColor);

        } else if (btn7 == e.getSource()){
            drawPanel.setType("Eraser");
        }else if (newCanvas == e.getSource()){
            drawPanel.setType("Clear");
        }

    }

    public static void main(String[] args) {
        new WhiteBoardFrame();
    }

    @Override
    public void run() {

    }
}
