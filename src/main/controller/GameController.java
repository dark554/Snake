package main.controller;

import main.enums.DirectionEnum;
import main.model.GameData;
import main.view.GameWindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//class updating model on event(e.g key pressed) and calling window.getPanel().draw(objects)
public class GameController implements KeyListener {
    private GameWindow window;
    private GameData gameData;
    private Timer t;

    public GameController() {
        window = new GameWindow();
        window.addKeyListener(this);
        gameData = new GameData();
        t = new Timer(gameData, window);
        t.start();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            if (gameData.getObjects().getSnake().getDirection() != DirectionEnum.DOWN) {
                gameData.getObjects().getSnake().setNextDirection(DirectionEnum.UP);
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            if(gameData.getObjects().getSnake().getDirection() != DirectionEnum.UP) {
                gameData.getObjects().getSnake().setNextDirection(DirectionEnum.DOWN);
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            if(gameData.getObjects().getSnake().getDirection() != DirectionEnum.RIGHT){
                gameData.getObjects().getSnake().setNextDirection(DirectionEnum.LEFT);
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            if(gameData.getObjects().getSnake().getDirection() != DirectionEnum.LEFT) {
                gameData.getObjects().getSnake().setNextDirection(DirectionEnum.RIGHT);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
