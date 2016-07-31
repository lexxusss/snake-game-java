package ixn.snakegame.objects;

public class Snake {
    public int direction = 3; // 0 - right, 1 - up, 2 - left, 3 - down
    public int length = 2;

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

        if (direction == 0) snakeX[0]++;
        if (direction == 1) snakeY[0]++;
        if (direction == 2) snakeX[0]--;
        if (direction == 3) snakeY[0]--;
    }
}
