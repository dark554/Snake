package main.model;

import main.enums.DirectionEnum;
import main.model.utils.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static main.view.Board.BOARD_SIZE;

//class holds information about position of object on the board

public class ObjectsContainer {
    private Snake snake;
    private List<Apple> apples;
    private Random rand;


    public ObjectsContainer(){
        snake = new Snake();
        apples = new ArrayList<>();
        rand = new Random();
    }

    public boolean isCollision() {
        if(snake.getDirection() == DirectionEnum.UP && snake.getSnakeHead().getY() == 0){
            return true;
        }

        else if(snake.getDirection() == DirectionEnum.LEFT && snake.getSnakeHead().getX() == 0){
            return true;
        }

        else if(snake.getDirection() == DirectionEnum.DOWN && snake.getSnakeHead().getY() == BOARD_SIZE-1){
            return true;
        }

        else if(snake.getDirection() == DirectionEnum.RIGHT && snake.getSnakeHead().getX() == BOARD_SIZE-1){
            return true;
        }

        return false;
    }

    public void appleGenerator(){
        int x,y;
        Point apple = new Point(0,0);
        boolean isAppleAdded = false;
        while(!isAppleAdded) {
            x = rand.nextInt(BOARD_SIZE - 1);
            y = rand.nextInt(BOARD_SIZE - 1);
            apple.setPoint(x,y);
            if (!isAppleOnSnake(apple) && !isAppleOnApple(apple)) {
                apples.add(new Apple(apple));
                isAppleAdded = true;
            }
        }
    }

    public boolean isCollisionWithApple(Apple a){
            if(a.getPosition().equals(snake.getSnakeHead())){
                return true;
            }
            return false;
    }

    private boolean isAppleOnApple(Point apple){
        for (Apple a : apples){
            if(a.getPosition().equals(apple)){
                return true;
            }
        }
        return false;
    }
    private boolean isAppleOnSnake(Point apple){
        for (Point p : snake.getSnakeBody()) {
            if (p.equals(apple)) {
                return true;
            }
        }
        if (snake.getSnakeHead().equals(apple)) {
            return true;
        }
        return false;
    }

    public boolean isCollisionWithSnake(){
        for(Point p : snake.getSnakeBody()){
            if(p.equals(snake.getSnakeHead())){
                return true;
            }
        }
        return false;
    }

    public Snake getSnake() {
        return snake;
    }
    public List<Apple> getApples() {
        return apples;
    }
}
