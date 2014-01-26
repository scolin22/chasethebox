package chasethebox;

import java.awt.Color;
import java.awt.Graphics;

public class Box {

    private int centerX = 400;
    private int centerY = 240;

    private int speedX = 0;
    private int speedY = 0;
    private int box_width = 10;
    private int box_height = 10;

    final private int WIDTH = 800;
    final private int HEIGHT = 480;
    final private int MOVESPEED = 6;

    public void update() {
        if (centerX + speedX + box_width / 2 >= WIDTH) {
            centerX = WIDTH - box_width / 2;
        } else if (centerX + speedX - box_width / 2 < 0) {
            centerX = box_width / 2;
        } else {
            centerX += speedX;
        }

        if (centerY + speedY + box_height / 2 >= HEIGHT) {
            centerY = HEIGHT - box_height / 2;
        } else if (centerY + speedY - box_height / 2 < 0) {
            centerY = box_height / 2;
        } else {
            centerY += speedY;
        }
    }

    public void moveUp() {
        speedY = -MOVESPEED;
    }

    public void moveDown() {
        speedY = MOVESPEED;
    }

    public void moveLeft() {
        speedX = -MOVESPEED;
    }

    public void moveRight() {
        speedX = MOVESPEED;
    }

    public void stop() {
        speedX = 0;
        speedY = 0;
    }

    public void drawBox(Graphics g, Color c) {
        g.setColor(Color.CYAN);
        g.drawRect(centerX, centerY, box_width, box_height);
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getBox_width() {
        return box_width;
    }

    public void setBox_width(int box_width) {
        this.box_width = box_width;
    }

    public int getBox_height() {
        return box_height;
    }

    public void setBox_height(int box_height) {
        this.box_height = box_height;
    }
}