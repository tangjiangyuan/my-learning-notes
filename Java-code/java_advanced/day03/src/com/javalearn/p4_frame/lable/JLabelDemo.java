package com.javalearn.p4_frame.lable;

import javax.swing.*;

public class JLabelDemo {
    /*
        使用 JLabel 展示文本和图片

        JLabel 构造方法：
            JLabel(String text) : 使用指定的文本创建一个 JLabel 对象
            JLabel(Icon image) : 创建一个具有指定图像的 JLabel 对象

     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // JLabel 展示文本
        JLabel jl1 = new JLabel("听君一席话");
        jl1.setBounds(50,50,100,100);
        frame.getContentPane().add(jl1);

        JLabel jl2 = new JLabel("如听君一席话");
        jl2.setBounds(150,50,100,100);
        frame.getContentPane().add(jl2);

        // JLabel 展示图片
        // ImageIcon icon = new ImageIcon("D:\\壁纸\\01.jpg");
        JLabel imgLabel_01jpg = new JLabel(new ImageIcon("D:\\壁纸\\01.jpg"));
        imgLabel_01jpg.setBounds(50,150,400,400);
        frame.getContentPane().add(imgLabel_01jpg);


        frame.setVisible(true);
    }
}
