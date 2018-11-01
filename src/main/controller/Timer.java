package main.controller;

import main.model.Snake;

public class Timer extends Thread{

    Snake snake;

    public Timer(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void run() {
        while(true) {
            //sleep 1s
            snake.move();
        }
    }
}
