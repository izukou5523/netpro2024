//FacesAWTMain.java
//FacesAWTMain 目標 インナークラスのFaceObjクラスを作ってみよう。描画処理を移譲してください。
//3x3　の顔を描画してください。色などもぬってオリジナルな楽しい顔にしてください。

package guibasic;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTMain {

    public static void main(String[] args) {
        new FacesAWTMain();
    }

    FacesAWTMain() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    // インナークラスを定義
    class FaceFrame extends Frame {

        private int w;
        private int h;
        private int xStart;
        private int yStart;
        private int padding;
        private FaceObj fobj1;

        FaceFrame() {
            w = 200;
            h = 200;
            xStart = 50;
            yStart = 50;
            padding = 20;
            fobj1 = new FaceObj();
        }

        public void paint(Graphics g) {
			// この中には、g.drawLine というのは入ってこない
			// Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    int x = xStart + col * (w + padding);
                    int y = yStart + row * (h + padding);
                    FaceObj fobj = new FaceObj(x, y, w, h, row * 3 + col);
                    fobj.drawFace(g);
                }
            }
        }
    }

    // Faceクラスを作ってみよう。
    private class FaceObj {
        private int x;
        private int y;
        private int width;
        private int height;
		private int expressionType;

        FaceObj() {
            this.x = 0;
            this.y = 0;
            this.width = 0;
            this.height = 0;
        }

        FaceObj(int x, int y, int width, int height, int expressionType) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
			this.expressionType = expressionType;
        }

        void drawFace(Graphics g) {
            drawRim(g);
            drawBrow(g, 30);
            drawEye(g, 35);
            drawNose(g, 40);
            drawMouth(g, 100);
        }

        private void drawRim(Graphics g) {
            Color faceColor = new Color(255, 223, 196); 
            g.setColor(faceColor);
            g.fillRoundRect(x + 5, y + 5, width - 10, height - 10, 40, 40);
            g.setColor(Color.BLACK); 
            g.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 40, 40);
        }

        private void drawBrow(Graphics g, int bx) {
            int browY = y + height / 4;
			g.setColor(Color.BLACK);
            g.drawLine(x + width / 4, browY, x + width / 2 - bx / 2, browY);
            g.drawLine(x + width / 2 + bx / 2, browY, x + 3 * width / 4, browY);
        }

        private void drawEye(Graphics g, int r) {
			int eyeY = y + height / 3;
            g.setColor(Color.WHITE);
            g.fillOval(x + width / 4 - r / 2, eyeY, r, r);
            g.fillOval(x + 3 * width / 4 - r / 2, eyeY, r, r);
            g.setColor(Color.BLACK);
            g.drawOval(x + width / 4 - r / 2, eyeY, r, r);
            g.drawOval(x + 3 * width / 4 - r / 2, eyeY, r, r);
            g.fillOval(x + width / 4 - r / 4, eyeY + r / 4, r / 2, r / 2);
            g.fillOval(x + 3 * width / 4 - r / 4, eyeY + r / 4, r / 2, r / 2);
        }

        private void drawNose(Graphics g, int nx) {
            int noseY1 = y + height / 2;
            int noseY2 = noseY1 + nx;
			g.setColor(Color.BLACK);
            g.drawLine(x + width / 2, noseY1, x + width / 2, noseY2);
        }

        private void drawMouth(Graphics g, int mx) {
            int mouthY = y + 3 * height / 4;
			int mouthWidth = 180;
			g.setColor(Color.RED);
            switch (expressionType) {
                case 0: // 笑顔
                    g.drawArc(x + width / 2 - mouthWidth / 2, mouthY - 20, mouthWidth, 40, 0, -180);
                    break;
                case 1: // 怒った顔
                    g.drawArc(x + width / 2 - mouthWidth / 2, mouthY - 10, mouthWidth, 20, 0, 180);
                    break;
                case 2: // 驚いた顔
                    g.drawOval(x + width / 2 - mouthWidth / 4, mouthY - 10, mouthWidth / 2, 40);
                    break;
                case 3: // ウィンク
                    g.drawLine(x + width / 2 - mouthWidth / 2, mouthY, x + width / 2 + mouthWidth / 2, mouthY);
                    g.drawArc(x + width / 4 - 35 / 2, y + height / 3, 35, 35, 0, 180); // ウィンク
                    break;
                case 4: // 泣き顔
                    g.drawArc(x + width / 2 - mouthWidth / 2, mouthY - 10, mouthWidth, 20, 0, 180);
                    g.setColor(Color.BLUE);
                    g.fillOval(x + width / 4 - 10, y + height / 2, 10, 20); // 涙
                    g.fillOval(x + 3 * width / 4 - 10, y + height / 2, 10, 20); // 涙
                    break;
                case 5: // 照れた顔
                    g.drawArc(x + width / 2 - mouthWidth / 2, mouthY - 10, mouthWidth, 20, 0, 180);
                    g.setColor(Color.PINK);
                    g.fillOval(x + width / 4 - 20, mouthY - 10, 40, 20); // 頬の赤み
                    g.fillOval(x + 3 * width / 4 - 20, mouthY - 10, 40, 20); // 頬の赤み
                    break;
                case 6: // 驚き
                    g.drawOval(x + width / 2 - mouthWidth / 4, mouthY - 10, mouthWidth / 2, 40);
                    g.setColor(Color.BLACK);
                    g.drawLine(x + width / 2 - mouthWidth / 4, mouthY + 10, x + width / 2 + mouthWidth / 4, mouthY + 10);
                    break;
                case 7: // 思案顔
                    g.drawArc(x + width / 2 - mouthWidth / 2, mouthY - 10, mouthWidth, 20, 0, -180);
                    g.drawLine(x + width / 2, mouthY, x + width / 2, mouthY + 20);
                    break;
                case 8: // 幸せな顔
                    g.drawArc(x + width / 2 - mouthWidth / 2, mouthY - 20, mouthWidth, 40, 0, -180);
                    g.setColor(Color.PINK);
                    g.fillOval(x + width / 4 - 20, mouthY - 10, 40, 20); // 頬の赤み
                    g.fillOval(x + 3 * width / 4 - 20, mouthY - 10, 40, 20); // 頬の赤み
                    break;
            }
        }
    }
}
