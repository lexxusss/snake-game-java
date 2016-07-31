package ixn.snakegame.objects;

import ixn.snakegame.SnakeGame;

public class Snake {
    public Direction direction = Direction.RIGHT;
    public int length = 2;

    public int[] snakeX = new int[SnakeGame.WIDTH * SnakeGame.HEIGHT];
    public int[] snakeY = new int[SnakeGame.WIDTH * SnakeGame.HEIGHT];

    public Snake(int x0, int y0, int x1, int y1) {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }

    public void move() {
        // move snack
        for (int i = this.length; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        // /move snack

        if (direction == Direction.RIGHT) snakeX[0]++;
        if (direction == Direction.DOWN) snakeY[0]++;
        if (direction == Direction.LEFT) snakeX[0]--;
        if (direction == Direction.UP) snakeY[0]--;

        // cut snake if it eats itself
        for (int i = this.length - 1; i > 0 ; i--) {
            if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                length = i - 2;
            }
        }

        if (this.length < 2) length = 2;
        // /cut snake if it eats itself

        // mirror sides
        if (snakeX[0] >= SnakeGame.WIDTH) snakeX[0] = 0;
        if (snakeX[0] < 0) snakeX[0] = SnakeGame.WIDTH - 1;

        if (snakeY[0] >= SnakeGame.HEIGHT - 1) snakeY[0] = 0;
        if (snakeY[0] < 0) snakeY[0] = SnakeGame.HEIGHT - 2;
        // /mirror sides
    }
}
