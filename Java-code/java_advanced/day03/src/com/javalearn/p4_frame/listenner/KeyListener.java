package com.javalearn.p4_frame.listenner;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class KeyListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // (fn ctrl esc 上下左右) 监听不到
            }

            @Override
            public void keyPressed(KeyEvent e) { // 键盘按下时触发
                int keyCode = e.getKeyCode();
                if (keyCode == 37 || keyCode == 65) {
                    System.out.println("左移动业务");
                } else if (keyCode == 38 || keyCode == 87) {
                    System.out.println("上移动业务");
                } else if (keyCode == 39 || keyCode == 68) {
                    System.out.println("右移动业务");
                } else if (keyCode == 40 || keyCode == 83) {
                    System.out.println("下移动业务");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { // 键盘释放时出发

            }
        });
        frame.setVisible(true);
    }
}
