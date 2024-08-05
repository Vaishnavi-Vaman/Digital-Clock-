package com.practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame {
    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("", Font.BOLD, 35);  //"" it refers name,35 refers size

    MyWindow() {
        super.setTitle("My Clock");
        super.setSize(400, 400);
        super.setLocation(300, 50);
        this.createGUI();
        this.startClock();
        super.setVisible(true);
    }

    public void createGUI() {
        heading = new JLabel("My Clock"); // text:"My Clock" but here if we mention text it comes error
        clockLabel = new JLabel("clock");
        heading.setFont(font);
        clockLabel.setFont(font);
        this.setLayout(new GridLayout(2, 1)); // row & col
        this.add(heading);
        this.add(clockLabel);
    }

    public void startClock() {
        //        Timer timer=new Timer(1000,new ActionListener()//delay=1000
//        {
//           
//            public void actionPerformed(ActionEvent e){
//              //  String dateTime=new Date().toString(); in 24hrs
//             // String dateTime=new Date().toLocaleString(); in 12hr with am and pm
//             Date d=new Date();
//             SimpleDateFormat sfd=new SimpleDateFormat("hh:mm:ss a");//pattern:hh:mm:ss
//             String dateTime=sfd.format(d);
//                clockLabel.setText(dateTime);
//            }
//        }); 
//        timer.start();
        //other type using thread
        Thread t = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Date d = new Date();
                        SimpleDateFormat sfd = new SimpleDateFormat("hh:mm:ss a"); // Corrected SimpleDateFormat instantiation
                        String dateTime = sfd.format(d);
                        clockLabel.setText(dateTime);
                        // Thread.sleep(1000);
                        Thread.currentThread().sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
