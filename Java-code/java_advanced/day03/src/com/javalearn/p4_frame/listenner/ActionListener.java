package com.javalearn.p4_frame.listenner;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionListener {
    /*
        动作事件：ActionListener
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton btn = new JButton("按钮");
        btn.setBounds(0,0,100,100);
        frame.getContentPane().add(btn);

        /*btn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("我被点了。。。");
            }
        });*/

        btn.addActionListener((ActionEvent e) -> {
            System.out.println("我被点了。。。");
        });

        frame.setVisible(true);
    }
}
