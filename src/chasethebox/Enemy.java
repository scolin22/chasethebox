package chasethebox;

import java.awt.Rectangle;

public class Enemy extends Box {
    private boolean chasing = true;

    public Enemy(int x, int y) {
        setCenterX(x);
        setCenterY(y);

        Rectangle rect = new Rectangle(getCenterX() - getBox_width() / 2,
                getCenterY() - getBox_height() / 2, getBox_width(),
                getBox_height());

        setR(rect);
    }

    public void update() {
        if (isChasing()) {
            chase();
        }
        super.update();
    }

    private void chase() {
        checkCollision(StartingClass.getBox().getR());

        int x = StartingClass.getBox().getCenterX();
        int y = StartingClass.getBox().getCenterY();

        int x_diff = x - getCenterX();
        int y_diff = y - getCenterY();

        double alpha = Math.sqrt((Math.pow(x_diff, 2) + Math.pow(y_diff, 2))
                / Math.pow(getMOVESPEED() / 2, 2));

        int speedX = (int) (x_diff / alpha);
        int speedY = (int) (y_diff / alpha);

        setSpeedX(speedX);
        setSpeedY(speedY);
    }

    private void checkCollision(Rectangle victim) {
        if (getR().intersects(victim)) {
            // end game
            while (true) {
                System.out.println("You lose");
            }
        }
    }

    public boolean isChasing() {
        return chasing;
    }

    public void setChasing(boolean chasing) {
        this.chasing = chasing;
    }

}
