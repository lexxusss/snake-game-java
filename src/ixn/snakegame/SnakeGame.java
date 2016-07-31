package ixn.snakegame;

import ixn.snakegame.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SnakeGame extends JPanel implements ActionListener {
    public static final int SCALE = 32;
    public static final int WIDTH = 20;

    public static final int HEIGHT = 20;
    public static final int FULL_WIDTH = WIDTH * SCALE + 1;
    public static final int FULL_HEIGHT = HEIGHT * SCALE - 9;
    public static final int SPEED = 5;

    Snake s = new Snake(10, 10, 9, 10);
    Timer t = new Timer(1000 / SPEED, this);

    public SnakeGame() {
        t.start();
    }

    public void paint(Graphics g) {
        g.setColor(color(5, 50, 10));
        g.fillRect(0, 0, FULL_WIDTH, FULL_HEIGHT);
        g.setColor(color(255, 216, 0));

        for (int xx = 0; xx < FULL_WIDTH; xx += SCALE) {
            g.drawLine(xx, 0, xx, FULL_WIDTH);
        }

        for (int yy = 0; yy < FULL_HEIGHT; yy += SCALE) {
            g.drawLine(0, yy, FULL_HEIGHT + 9, yy);
        }

        // draw snake
        g.setColor(color(200, 150, 0));
        int snakeXCell, snakeYCell, sellSize = SCALE - 1;
        for (int i = 0; i < s.length; i++) {
            snakeXCell = s.snakeX[i] * SCALE + 1;
            snakeYCell = s.snakeY[i] * SCALE + 1;
            g.fillRect(snakeXCell, snakeYCell, sellSize, sellSize);
        }
        // /draw snake
    }

    public Color color(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(FULL_WIDTH, FULL_HEIGHT);
        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        s.move();

        repaint();
    }
}
