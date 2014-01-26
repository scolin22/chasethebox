package chasethebox;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class StartingClass extends Applet implements Runnable, KeyListener {

    private Box box;
    private Image image, character;
    private Graphics second;
    private URL base;

    @Override
    public void init() {

        setSize(800, 480);
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("Chase the Box");
        try {
            base = getDocumentBase();
        } catch (Exception e) {
            // TODO: handle exception
        }

        // Image Setups
        character = getImage(base, "data/box.png");

    }

    @Override
    public void start() {
        box = new Box();

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        while (true) {
            box.update();
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            second = image.getGraphics();
        }

        second.setColor(getBackground());
        second.fillRect(0, 0, getWidth(), getHeight());
        second.setColor(getForeground());
        paint(second);

        g.drawImage(image, 0, 0, this);

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(character, box.getCenterX() - 5, box.getCenterY() - 5, this);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            System.out.println("+ UP");
            box.moveUp();
            break;

        case KeyEvent.VK_DOWN:
            System.out.println("+ DOWN");
            box.moveDown();
            break;

        case KeyEvent.VK_LEFT:
            System.out.println("+ LEFT");
            box.moveLeft();
            break;

        case KeyEvent.VK_RIGHT:
            System.out.println("+ RIGHT");
            box.moveRight();
            break;

        case KeyEvent.VK_SPACE:
            System.out.println("+ SPACE");
            break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            System.out.println("- UP");
            box.setMovingUp(false);
            box.stop();
            break;

        case KeyEvent.VK_DOWN:
            System.out.println("- DOWN");
            box.setMovingDown(false);
            box.stop();
            break;

        case KeyEvent.VK_LEFT:
            System.out.println("- LEFT");
            box.setMovingLeft(false);
            box.stop();
            break;

        case KeyEvent.VK_RIGHT:
            System.out.println("- RIGHT");
            box.setMovingRight(false);
            box.stop();
            break;

        case KeyEvent.VK_SPACE:
            System.out.println("- SPACE");
            break;

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
