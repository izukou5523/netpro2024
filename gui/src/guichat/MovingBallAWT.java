package guichat;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MovingBallAWT {
    public static void main(String[] args) {
        FFrame f = new FFrame();
        f.setSize(500, 500);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    static class FFrame extends Frame implements Runnable {
        Thread th;
        Ball[] balls;
        private boolean enable = true;
        private int counter = 0;
        private final int WIDTH = 500;
        private final int HEIGHT = 500;

        FFrame() {
            th = new Thread(this);
            th.start();
        }

        public void run() {
            balls = new Ball[5];  // ボールの配列を作成

            // 各ボールを初期化
            balls[0] = new Ball();
            balls[0].setPosition(200, 150);
            balls[0].setR(10);
            balls[0].setColor(Color.RED);

            balls[1] = new Ball();
            balls[1].setPosition(50, 250);
            balls[1].setR(20);
            balls[1].setColor(Color.GREEN);

            balls[2] = new Ball();
            balls[2].setPosition(100, 100);
            balls[2].setR(15);
            balls[2].setColor(Color.BLUE);

            balls[3] = new Ball();
            balls[3].setPosition(300, 200);
            balls[3].setR(25);
            balls[3].setColor(Color.YELLOW);

            balls[4] = new Ball();
            balls[4].setPosition(150, 300);
            balls[4].setR(12);
            balls[4].setColor(Color.ORANGE);

            while (enable) {
                try {
                    Thread.sleep(100);
                    counter++;
                    if (counter >= 200) enable = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 全てのボールを移動
                for (Ball ball : balls) {
                    ball.move(WIDTH, HEIGHT);
                }

                repaint(); // paint()メソッドが呼び出される
            }
        }

        public void paint(Graphics g) {
            // 全てのボールを描画
            for (Ball ball : balls) {
                ball.draw(g);
            }
        }

        // Ballというインナークラスを作る
        class Ball {
            int x;
            int y;
            int r; // 半径
            Color c = Color.RED;

            int xDir = 1;  // 1:+方向  -1: -方向
            int yDir = 1;
            Random random = new Random();

            void setColor(Color c) {
                this.c = c;
            }

            void move(int width, int height) {
                // 水平方向の移動と反射
                if ((xDir == 1) && (x >= width - 2 * r)) {
                    xDir = -1;
                    changeColor();
                }
                if ((xDir == -1) && (x <= 0)) {
                    xDir = 1;
                    changeColor();
                }

                if (xDir == 1) {
                    x += 10;
                } else {
                    x -= 10;
                }

                // 垂直方向の移動と反射
                if ((yDir == 1) && (y >= height - 2 * r)) {
                    yDir = -1;
                    changeColor();
                }
                if ((yDir == -1) && (y <= 0)) {
                    yDir = 1;
                    changeColor();
                }

                if (yDir == 1) {
                    y += 10;
                } else {
                    y -= 10;
                }
            }

            void setPosition(int x, int y) {
                this.x = x;
                this.y = y;
            }

            void setR(int r) {
                this.r = r;
            }

            void draw(Graphics g) {
                g.setColor(c);
                g.fillOval(x, y, 2 * r, 2 * r); // rは半径なので2倍にする
            }

            void changeColor() {
                this.c = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            }
        } // インナークラスBallの終わり
    }
}
