package ixn.snakegame.objects;

public class Snake {
    public Direction direction = Direction.RIGHT;
    public int length = 10;

    public int[] snakeX = new int[100];
    public int[] snakeY = new int[100];

    public Snake(int x0, int y0, int x1, int y1) {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }

    public void move() {
        for (int i = this.length; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

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
    }
}
