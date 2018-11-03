package main.controller;

import main.model.Apple;
import main.model.ObjectsContainer;
import main.model.Snake;
import main.view.GameWindow;

public class Timer extends Thread{

    private ObjectsContainer objects;
    private GameWindow window;

    public Timer(ObjectsContainer objects, GameWindow window) {
        this.objects = objects;
        this.window = window;
    }

    @Override
    public void run() {
        int appleTimer = 0;
        while(true) {
            window.update(objects);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            objects.increseScore(1);
            window.getGameInfo().getScoreLabel().setText("Score: " + objects.getScore());
            objects.getSnake().setDirection(objects.getSnake().getNextDirection());
            if(objects.isCollision()) {
                break;
            }

            objects.getSnake().move();
            if(objects.isCollisionWithSneak()){
                break;
            }
            for (Apple a : objects.getApples()){
                if(objects.isCollisionWithApple(a)){
                    objects.getApples().remove(a);
                    objects.getSnake().addBodyPart();
                    objects.increseScore(150);
                    window.getGameInfo().getScoreLabel().setText("Score: " + objects.getScore());
                    break;
                }
            }
            if(appleTimer==16){
                objects.appleGenerator();
                appleTimer=-1;
            }

            appleTimer++;
        }

    }
}
