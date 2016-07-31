package ixn.snakegame.objects;

import ixn.snakegame.SnakeGame;

public class Apple {
    private SnakeGame main;
    public int posX, posY;

    public Apple(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public void setRandomPosition() {
        this.posX = Apple.getRandomXCoordinate();
        this.posY = Apple.getRandomYCoordinate();
    }

    public static int getRandomXCoordinate() {
        return (int) (Math.random() * SnakeGame.WIDTH);
    }

    public static int getRandomYCoordinate() {
        return (int) (Math.random() * SnakeGame.HEIGHT);
    }
}
