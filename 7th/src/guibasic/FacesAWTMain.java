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

    public static void main(String[] args){
        new FacesAWTMain();
    }

    FacesAWTMain(){
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

	// インナークラスを定義
    class FaceFrame extends Frame {

        FaceFrame() {}

        public void paint(Graphics g) {
            FaceObj[] faces = new FaceObj[9];
            for(int j = 0; j < 3; j++) {
                for (int i = 0; i < 3; i++) {
                    faces[i + 3 * j] = new FaceObj(200 * i + 50, 200 * j + 50, i, j);
                    faces[i + 3 * j].drawFace(g);
                }
            }
        }
    }

    private class FaceObj {
        private int xStart;
        private int yStart;
        private int emotionLevelX;
        private int emotionLevelY;

        FaceObj(int x, int y, int ex, int ey) {
            xStart = x;
            yStart = y;
            emotionLevelX = ex;
            emotionLevelY = ey;
        }

        public void drawFace(Graphics g) {
            drawRim(g);
            drawBrow(g);
            drawEyes(g);
            drawNose(g);
            drawMouth(g);
        }

        private void drawRim(Graphics g) {
            g.setColor(Color.ORANGE);
            g.fillRoundRect(xStart + 5, yStart + 5, 190, 190, 40, 40);
        }

        private void drawBrow(Graphics g) {
            g.setColor(Color.BLACK);
            if (emotionLevelX % 2 == 0) {
                g.drawLine(xStart + 60, yStart + 70, xStart + 90, yStart + 60);
                g.drawLine(xStart + 110, yStart + 60, xStart + 140, yStart + 70);
            } else {
                g.drawLine(xStart + 60, yStart + 60, xStart + 90, yStart + 70);
                g.drawLine(xStart + 110, yStart + 70, xStart + 140, yStart + 60);
            }
        }

        private void drawEyes(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillOval(xStart + 60, yStart + 75, 30, 30);
            g.fillOval(xStart + 115, yStart + 75, 30, 30);
        }

        private void drawNose(Graphics g) {
            g.setColor(Color.BLACK);
            g.drawLine(xStart + 100, yStart + 100, xStart + 100, yStart + 130);
        }

        private void drawMouth(Graphics g) {
            g.setColor(Color.RED);
            if (emotionLevelY % 2 == 0) {
                g.drawArc(xStart + 70, yStart + 140, 60, 20, 0, -180);
            } else {
                g.drawArc(xStart + 70, yStart + 140, 60, 20, 0, 180);
            }
        }
    }
}
