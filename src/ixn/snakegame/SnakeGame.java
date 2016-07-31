package ixn.snakegame;

import ixn.snakegame.objects.Apple;
import ixn.snakegame.objects.Direction;
import ixn.snakegame.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class SnakeGame extends JPanel implements ActionListener {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;

    private static final int SCALE = 32;
    private static final int FULL_WIDTH = WIDTH * SCALE + 1;
    private static final int FULL_HEIGHT = HEIGHT * SCALE - 9;
    private static final int SPEED = 1;

    private Apple a = new Apple(Apple.getRandomXCoordinate(), Apple.getRandomYCoordinate());
    private Snake s = new Snake(10, 10, 9, 10);
    private Timer t = new Timer(1000 / SPEED, this);

    private SnakeGame() {
        t.start();

        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    public void paint(Graphics g) {
        int sellSize = SCALE - 1;

        // draw field
        g.setColor(color(5, 50, 10));
        g.fillRect(0, 0, FULL_WIDTH, FULL_HEIGHT);
        // /draw field

        // draw grid
        g.setColor(color(255, 216, 0));
        for (int xx = 0; xx < FULL_WIDTH; xx += SCALE) {
            g.drawLine(xx, 0, xx, FULL_WIDTH);
        }
        for (int yy = 0; yy < FULL_HEIGHT; yy += SCALE) {
            g.drawLine(0, yy, FULL_HEIGHT + 9, yy);
        }
        // /draw grid

        // draw snake
        g.setColor(color(200, 150, 0));
        int snakeXCell, snakeYCell;
        for (int i = 0; i < s.length; i++) {
            snakeXCell = s.snakeX[i] * SCALE + 1;
            snakeYCell = s.snakeY[i] * SCALE + 1;
            g.fillRect(snakeXCell, snakeYCell, sellSize, sellSize);
        }
        // /draw snake

        // draw apple
        g.setColor(color(255, 0, 0));
        int appleXCell = a.posX * SCALE + 1;
        int appleYCell = a.posY * SCALE + 1;
        g.fillRect(appleXCell, appleYCell, sellSize, sellSize);
        // /draw apple
    }

    private Color color(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(FULL_WIDTH, FULL_HEIGHT);
        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        s.move();

        this.eatApple();

        repaint();
    }

    private void eatApple() {
        // set apple outside the snack
        for (int i = 1; i < s.length; i++) {
            if (s.snakeX[i] == a.posX && s.snakeY[i] == a.posY) {
                a.setRandomPosition();
            }
        }
        // /set apple outside the snack

        // eat apple
        if (s.snakeX[0] == a.posX && s.snakeY[0] == a.posY) {
            a.setRandomPosition();
            s.length++;
        }
        // /eat apple
    }

    private class KeyBoard extends KeyAdapter {
        public void keyPressed(KeyEvent kEvt) {
            int key = kEvt.getKeyCode();

            if (key == KeyEvent.VK_RIGHT && s.direction != Direction.LEFT) s.direction = Direction.RIGHT;
            if (key == KeyEvent.VK_DOWN && s.direction != Direction.UP) s.direction = Direction.DOWN;
            if (key == KeyEvent.VK_LEFT && s.direction != Direction.RIGHT) s.direction = Direction.LEFT;
            if (key == KeyEvent.VK_UP && s.direction != Direction.DOWN) s.direction = Direction.UP;
        }
    }
}
