package com.javalearn.p4_frame.button;

import javax.swing.*;

public class JButtonDemo {
    /*
        窗体中添加按钮组件
        --------------------
        JButton 构造方法：

                1. public JButton() : 创建一个空白的按钮
                2. public JButton(String text) : 创建一个带文本的按钮
        -------------------
        注意：如果取消了窗体的默认布局，就需要手动指定组件的摆放位置了
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,700);
        frame.setTitle("按钮学习");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消窗体的默认布局
        frame.setLayout(null);

        // 1. 创建窗体对象
        JButton button = new JButton("点我啊~");
        button.setBounds(350,600,80,40);

        // 2. 将按钮添加到窗体的 [面板对象] 中
        frame.getContentPane().add(button);
        // 取消按钮的聚焦
        button.setFocusable(false);

        frame.setVisible(true);
    }
}
