package com.javalearn.stonepuzzle;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MainFrame extends JFrame implements KeyListener {

    // 将图片存入二维数组中
    int[][] data = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    // 胜利数组
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    int row;    // 0号元素横坐标位置
    int column; // 0号元素纵坐标位置
    int count;  // 统计步数

    public MainFrame() {

        // 窗体对象.addKeyListener(KeyListener 实现类对象);
        // this : 当前类对象
        // 1) 窗体对象
        // 2) KeyListener 实现类对象
        this.addKeyListener(this);

        // 加载窗体
        initFrame();
        // 打乱二维数组
        initData();
        // 调用绘制游戏界面的方法
        paintView();
        // 设置窗体可见
        setVisible(true);
    }

    /**
     * 初始化数据(打乱二维数组)
     */
    public void initData() {
        Random r = new Random();
        // 遍历二维数组，拿到每一个元素
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                // 通过产生的随机索引替换当前元素
                int randomX = r.nextInt(4);
                int randomY = r.nextInt(4);
                int temp = data[i][j];
                data[i][j] = data[randomX][randomY];
                data[randomX][randomY] = temp;
            }
        }
        // 确定 0号元素坐标位置
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == 0) {
                    row = i;
                    column = j;
                }
            }
        }
        /*System.out.println(row);
        System.out.println(column);*/
    }

    /**
     * 此方法用于初始化窗体
     */
    public void initFrame() {
        // 设置窗体大小
        setSize(514, 595);
        // 设置窗体默认关闭方式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消窗体聚焦
        setLayout(null);
        // 设置窗体标题
        setTitle("石头迷阵单机版v1.0");
        // 使这个窗体置于顶层，不会因为点击其它地方而最小化
        setAlwaysOnTop(true);
        // 使窗体居中
        setLocationRelativeTo(null);
    }

    /**
     * 此方法用于绘制游戏界面
     */
    public void paintView() {

        // 3. 每次绘制界面之前，进行一次清空
        getContentPane().removeAll();

        // 5. 加载胜利图片
        if (victory()) {
            JLabel winLabel = new JLabel(new ImageIcon("D:\\Dev-work\\java_advanced\\day04\\src\\com\\javalearn\\image\\win.png"));
            winLabel.setBounds(124,230,266,88);
            getContentPane().add(winLabel);
        }

        // 6. 统计步数
        JLabel stepLabel = new JLabel("步数:" + count);
        stepLabel.setBounds(50, 20, 100, 20);
        getContentPane().add(stepLabel);

        // 7. 重新游戏按钮
        JButton btn = new JButton("重新开始");
        btn.setBounds(350, 20, 100, 20);
        btn.setFocusable(false);
        getContentPane().add(btn);
        btn.addActionListener(e -> {
            count = 0;
            initData();
            paintView();
        });

        // 1. 加载方块图片
        for (int i = 0; i < 4; i++) { // 行
            for (int j = 0; j < 4; j++) { // 列
                JLabel jl1 = new JLabel(new ImageIcon("D:\\Dev-work\\java_advanced\\day04\\src\\com\\javalearn\\image\\" + data[i][j] + ".png"));
                jl1.setBounds(50 + 100 * j, 90 + 100 * i, 100, 100);
                getContentPane().add(jl1); // 因为 MainFrame 继承了JFrame，但是没有重写JFrame的getContentPane()方法，因此可以省略super.
            }
        }

        // 2. 加载背景图片
        JLabel background = new JLabel(new ImageIcon("D:\\Dev-work\\java_advanced\\day04\\src\\com\\javalearn\\image\\background.png"));
        background.setBounds(26, 30, 450, 484);
        getContentPane().add(background);

        // 4. 使面板做一次刷新
        getContentPane().repaint();
    }

    /**
     * 此方法用来判断游戏是否胜利
     */
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        move(keyCode);
        paintView(); // 每移动一次，就绘制一次界面，并判断是否胜利
    }

    /**
     * 此方法用于处理移动业务
     * @param keyCode
     */
    private void move(int keyCode) {

        // 如果游戏结束，则不能移动了
        if (victory()) {
            return;
        }

        if (keyCode == 37 || keyCode == 65) { // A左移动业务执行

            // column == 3 不允许左移动
            if (column == 3) {
                return;
            }

            // 空白块和右侧数据交换
            // data[row][column]    data[row][column+1]
            int temp = data[row][column];
            data[row][column] = data[row][column+1];
            data[row][column+1] = temp;
            column++;
            count++;
        } else if (keyCode == 38 || keyCode == 87) { // W 上移动业务执行

            // row == 3 不允许上移动
            if (row == 3) {
                return;
            }

            // 空白块和下侧数据交换
            // data[row][column]    data[row+1][column]
            int temp = data[row][column];
            data[row][column] = data[row+1][column];
            data[row+1][column] = temp;
            row++;
            count++;
        } else if (keyCode == 39 || keyCode == 68) { // D 右移动业务执行

            // column == 0 不允许有移动
            if (column == 0) {
                return;
            }

            // 空白块和左侧数据交换
            // data[row][column]    data[row][column-1]
            int temp = data[row][column];
            data[row][column] = data[row][column-1];
            data[row][column-1] = temp;
            column--;
            count++;
        } else if (keyCode == 40 || keyCode == 83) { // S 下移动业务执行

            // row == 0 不允许下移动
            if (row == 0) {
                return;
            }

            // 空白块和上侧数据交换
            // data[row][column]    data[row-1][column]
            int temp = data[row][column];
            data[row][column] = data[row-1][column];
            data[row-1][column] = temp;
            row--;
            count++;
        } else if (keyCode == 90) { // z
            // 作弊器
            data = new int[][] {
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
        }
    }

    // --------------------------------------
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    // --------------------------------------
}
