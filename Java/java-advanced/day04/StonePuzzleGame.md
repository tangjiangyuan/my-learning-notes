day04、石头迷阵小游戏

![image-20250803103025865](D:\软件工程\Java\java-advanced\day04\assets\image-20250803103025865.png)

一、绘制界面

![image-20250803103133867](D:\软件工程\Java\java-advanced\day04\assets\image-20250803103133867.png)

```
窗体大小:514,595
```

```
方块大小:50, 90, 100, 100
```

二、打乱石头方块

![image-20250803103147129](D:\软件工程\Java\java-advanced\day04\assets\image-20250803103147129.png)

三、移动业务

![image-20250803103154156](D:\软件工程\Java\java-advanced\day04\assets\image-20250803103154156.png)

![image-20250803103159334](D:\软件工程\Java\java-advanced\day04\assets\image-20250803103159334.png)

![image-20250803103206216](D:\软件工程\Java\java-advanced\day04\assets\image-20250803103206216.png)

```
z:90
```

=== Bug分析和解决

![image-20250803103217836](D:\软件工程\Java\java-advanced\day04\assets\image-20250803103217836.png)

四、游戏胜利判定

![image-20250803103236167](D:\软件工程\Java\java-advanced\day04\assets\image-20250803103236167.png)

![image-20250803103252322](D:\软件工程\Java\java-advanced\day04\assets\image-20250803103252322.png)

![image-20250803103256794](D:\软件工程\Java\java-advanced\day04\assets\image-20250803103256794.png)

五、统计步数

```java
stepLabel.setBounds(50, 20, 100, 20);
```

六、重新开始

![image-20250803103303329](D:\软件工程\Java\java-advanced\day04\assets\image-20250803103303329.png)

```java
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame implements KeyListener {

  int[][] data = {
      { 1, 2, 3, 4 },
      { 5, 6, 7, 8 },
      { 9, 10, 11, 12 },
      { 13, 14, 15, 0 }
  };

  int[][] win = {
      { 1, 2, 3, 4 },
      { 5, 6, 7, 8 },
      { 9, 10, 11, 12 },
      { 13, 14, 15, 0 }
  };

  int row; // 0号图片的行
  int column; // 0号图片的列
  int count; // 统计步数

  public MainFrame() {
    this.addKeyListener(this);
    // 初始化窗体
    initialFram();
    // 打乱数据
    initialData();
    // 绘制界面
    paintView();
    // 设置窗体可见
    setVisible(true);
  }

  // 初始化窗体
  public void initialFram() {
    // 设置窗体大小
    setSize(514, 595);
    // 设置窗体默认关闭模式
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    // 取消默认布局
    setLayout(null);
    // 设置标题
    setTitle("石头迷阵小游戏v1.0");
    // 使窗体始终置于顶层
    setAlwaysOnTop(true);
    // 使窗体始终居中
    setLocationRelativeTo(null);
  }

  // 绘制界面
  public void paintView() {

    // 3. 每次绘制界面之前，就清空一次
    getContentPane().removeAll();

    // 5. 判断是否胜利，如果胜利就加载胜利图片
    if (victory()) {
      JLabel winJl = new JLabel(
          new ImageIcon("D:\\Dev-work\\vscode_java\\review_java\\Java_advanced\\StonPuzzleGame\\image\\win.png"));
      winJl.setBounds(124, 230, 266, 88);
      getContentPane().add(winJl);
    }

    // 6. 加载步数
    JLabel stepLabel = new JLabel("步数:" + count);
    stepLabel.setBounds(50, 20, 100, 20);
    getContentPane().add(stepLabel);

    // 7. 重新开始按钮
    JButton reStarButton = new JButton("重新开始");
    reStarButton.setBounds(350, 20, 100, 20);
    reStarButton.setFocusable(false);
    getContentPane().add(reStarButton);
    reStarButton.addActionListener(e -> {
      count = 0;
      initialData();
      paintView();
    });

    // 1. 加载方块图片
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        JLabel img = new JLabel(new ImageIcon(
            "D:\\Dev-work\\vscode_java\\review_java\\Java_advanced\\StonPuzzleGame\\image\\" + data[i][j] + ".png"));
        img.setBounds(50 + j * 100, 90 + i * 100, 100, 100);
        getContentPane().add(img);
      }
    }
    // 2. 加载背景图片
    // D:\Dev-work\vscode_java\review_java\Java_advanced\StonPuzzleGame\image\0.png
    JLabel background = new JLabel(
        new ImageIcon("D:\\Dev-work\\vscode_java\\review_java\\Java_advanced\\StonPuzzleGame\\image\\background.png"));
    background.setBounds(26, 30, 450, 484);
    getContentPane().add(background);

    // 4. 刷新
    getContentPane().repaint();
  }

  // 打乱数据
  public void initialData() {
    Random random = new Random();
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        int randomX = random.nextInt(4);
        int randomY = random.nextInt(4);
        int temp = data[i][j];
        data[i][j] = data[randomX][randomY];
        data[randomX][randomY] = temp;
      }
    }
    // 获取零号方块位置
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        if (data[i][j] == 0) {
          row = i;
          column = j;
        }
      }
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    move(keyCode);
    paintView();
  }

  // 处理移动业务
  public void move(int keyCode) {

    if (victory()) {
      return;
    }

    if (keyCode == 37 || keyCode == 65) { // left

      if (column == 3) {
        return;
      }

      // data[row][column] data[row][column + 1]
      int temp = data[row][column];
      data[row][column] = data[row][column + 1];
      data[row][column + 1] = temp;
      column++;
      count++;
    } else if (keyCode == 38 || keyCode == 87) { // up

      if (row == 3) {
        return;
      }

      // data[row][column] data[row + 1][column]
      int temp = data[row][column];
      data[row][column] = data[row + 1][column];
      data[row + 1][column] = temp;
      row++;
      count++;
    } else if (keyCode == 39 || keyCode == 68) { // right

      if (column == 0) {
        return;
      }

      // data[row][column] data[row][column - 1]
      int temp = data[row][column];
      data[row][column] = data[row][column - 1];
      data[row][column - 1] = temp;
      column--;
      count++;
    } else if (keyCode == 40 || keyCode == 83) { // bottom

      if (row == 0) {
        return;
      }

      // data[row][column] data[row - 1][column]
      int temp = data[row][column];
      data[row][column] = data[row - 1][column];
      data[row - 1][column] = temp;
      row--;
      count++;
    } else if (keyCode == 90) { // z
      data = new int[][] {
          { 1, 2, 3, 4 },
          { 5, 6, 7, 8 },
          { 9, 10, 11, 12 },
          { 13, 14, 15, 0 }
      };
    }
  }

  // 判断是否胜利
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
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }
}
```

```java
public class Test {
  public static void main(String[] args) {
    new MainFrame();
  }
}
```

