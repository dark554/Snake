package main.controller;

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
        while(true) {
            window.update(objects);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            objects.getSnake().setDirection(objects.getSnake().getNextDirection());
            objects.getSnake().move();
        }
    }
}
