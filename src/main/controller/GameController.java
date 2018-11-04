package main.controller;

import main.enums.DirectionEnum;
import main.model.GameData;
import main.view.GameWindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


//class updating model on event(e.g key pressed) and calling window.getPanel().draw(objects)
public class GameController implements KeyListener {
    private GameWindow window;
    private GameData gameData;
    private Timer t;

    public GameController() {
        initializeStartingSetup();
    }

    private void initializeStartingSetup(){
        window = new GameWindow();
        window.addKeyListener(this);
        gameData = new GameData();
        t = new Timer(gameData, window);
        t.start();
    }

    private void RestartGame(){
        gameData.setScore(0);
        gameData.setTime();
        gameData.getObjects().getSnake().initializeStartingPositon();
        gameData.getObjects().getApples().clear();
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
        if(e.getKeyChar()=='r'){
            RestartGame();
            t.setRestart();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
