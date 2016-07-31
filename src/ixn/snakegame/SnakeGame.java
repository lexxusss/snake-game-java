package ixn.snakegame;

import javax.swing.*;
import java.awt.*;


public class SnakeGame extends JPanel {
    public static final int SCALE = 32;
    public static final int WIDTH = 20;

    public static final int HEIGHT = 20;
    public static final int FULL_WIDTH = WIDTH * SCALE + 1;
    public static final int FULL_HEIGHT = HEIGHT * SCALE - 9;

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
    }

    public Color color(int red, int green, int blue) {
        return new Color(red, green, blue);
    }
}
