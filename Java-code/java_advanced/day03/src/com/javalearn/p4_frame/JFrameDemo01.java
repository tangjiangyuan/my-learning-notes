package com.javalearn.p4_frame;

import javax.swing.*;

public class JFrameDemo01 {
    public static void main(String[] args) {
        // 创建窗体对象
        JFrame frame = new JFrame();

        // 设置窗体大小
        frame.setSize(500, 700); // 单位是像素px

        // 修改窗体的关闭模式(默认情况下，点击窗体的关闭按钮并不会停止运行)
        // 在 WindowConstants.EXIT_ON_CLOSE 模式下，当窗体结束后，JAVA程序也会终止
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 设置窗体的标题
        frame.setTitle("第一个窗体。。。");

        // 取消默认布局
        frame.setLayout(null);

        // 设置窗体可见 (一定要放最后！！！)
        frame.setVisible(true);
    }
}
