package main.controller;

import main.model.ObjectsContainer;
import main.view.GameWindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
* public interface KeyListener {
*   public void keyTyped(KeyEvent e);
*   public void keyPressed(KeyEvent e);
*   public void keyReleased(KeyEvent e);
* }
*
* */

//class updating model on event(e.g key pressed) and calling window.getPanel().draw(objects)
public class GameController implements KeyListener {
    private GameWindow window;
    private ObjectsContainer objects;

    public GameController() {
        window = new GameWindow();
        window.addKeyListener(this);
        Timer t = new Timer(objects.getSnake());
        t.start();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //objects.getSnake().setDirection(DirectionEnum.UP);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
