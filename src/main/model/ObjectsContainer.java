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
        boolean isAppleAdded = false;
        boolean isAppleOnSnake = false;
        while(!isAppleAdded) {
            x = rand.nextInt(BOARD_SIZE-1);
            y = rand.nextInt(BOARD_SIZE-1);
            for (Point p : snake.getSnakeBody()) {
                if (p.getX() == x && p.getY() == y) {
                    isAppleOnSnake = true;
                    break;
                }
            }
            if(!isAppleOnSnake){
                apples.add(new Apple(new Point(x, y)));
                isAppleAdded = true;
            }
            else if (snake.getSnakeHead().getX() != x && snake.getSnakeHead().getY() != y) {
                apples.add(new Apple(new Point(x, y)));
                isAppleAdded = true;
                break;
            }


        }

    }

    public boolean isCollisionWithApple(Apple a){
            if(a.getPosition().getY() == snake.getSnakeHead().getY() && a.getPosition().getX() == snake.getSnakeHead().getX()){
                return true;
            }
            return false;
    }

    public boolean isCollisionWithSneak(){
        for(Point p : snake.getSnakeBody()){
            if(p.getY() == snake.getSnakeHead().getY() && p.getX() == snake.getSnakeHead().getX()){
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
