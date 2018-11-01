package main.controller;

import main.enums.DirectionEnum;
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
    private Timer t;

    public GameController() {
        window = new GameWindow();
        window.addKeyListener(this);
        objects = new ObjectsContainer();
        t = new Timer(objects, window);
        t.start();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            if (objects.getSnake().getDirection() != DirectionEnum.DOWN) {
                objects.getSnake().setNextDirection(DirectionEnum.UP);
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            if(objects.getSnake().getDirection() != DirectionEnum.UP) {
                objects.getSnake().setNextDirection(DirectionEnum.DOWN);
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            if(objects.getSnake().getDirection() != DirectionEnum.RIGHT){
                objects.getSnake().setNextDirection(DirectionEnum.LEFT);
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            if(objects.getSnake().getDirection() != DirectionEnum.LEFT) {
                objects.getSnake().setNextDirection(DirectionEnum.RIGHT);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
