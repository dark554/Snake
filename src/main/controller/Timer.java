package main.controller;

import main.model.Apple;
import main.model.GameData;
import main.model.ObjectsContainer;
import main.view.GameWindow;
import org.joda.time.DateTime;

public class Timer extends Thread{

    private GameData gameData;
    private GameWindow window;

    public Timer(GameData gameData, GameWindow window) {
        this.gameData = gameData;
        this.window = window;
    }

    @Override
    public void run() {
        int appleTimer = 0;

        while(true) {
            window.update(gameData);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameData.increseScore(1);
            gameData.getObjects().getSnake().setDirection(gameData.getObjects().getSnake().getNextDirection());
            if(gameData.getObjects().isCollision()) {
                break;
            }

            gameData.getObjects().getSnake().move();
            if(gameData.getObjects().isCollisionWithSnake()){
                break;
            }
            for (Apple a : gameData.getObjects().getApples()){
                if(gameData.getObjects().isCollisionWithApple(a)){
                    gameData.getObjects().getApples().remove(a);
                    gameData.getObjects().getSnake().addBodyPart();
                    gameData.increseScore(150);
                    break;
                }
            }
            if(appleTimer==2){
                gameData.getObjects().appleGenerator();
                appleTimer=-1;
            }

            appleTimer++;
        }

    }
}
