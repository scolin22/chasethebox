package chasethebox;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Collectible {

    private int centerY = 240;
    private int centerX = 400;
    private int box_height = 10;
    private int box_width = 10;
    private int value = 10;

    private boolean visible = true;

    private Rectangle r;

    private ArrayList<Collectible> collectibles = new ArrayList<Collectible>();

    public Collectible(int centerX, int centerY) {
        this.centerY = centerY;
        this.centerX = centerX;

        r = new Rectangle(centerX - box_width / 2, centerY - box_height / 2,
                box_width, box_height);

        collectibles.add(this);
    }

    public void update() {
        if (visible) {
            checkCollision();
        }
    }

    private void checkCollision() {
        if (r.intersects(StartingClass.getBox().getR())) {
            StartingClass.setScore(StartingClass.getScore() + value);
            // Remove collectible
            while (true) {
                System.out.println("You win. Score " + value);
            }
        }
    }

    public void remove() {
        // TODO Remove the collectible from list
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getBox_height() {
        return box_height;
    }

    public void setBox_height(int box_height) {
        this.box_height = box_height;
    }

    public int getBox_width() {
        return box_width;
    }

    public void setBox_width(int box_width) {
        this.box_width = box_width;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
