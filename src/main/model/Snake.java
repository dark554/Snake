package main.model;

import main.enums.DirectionEnum;
import main.model.utils.Point;
import main.view.Board;

import java.util.ArrayList;
import java.util.List;

//class containing information about position of snake ( x,y of head, body, direction of movement)
public class Snake {
    private DirectionEnum direction;
    private DirectionEnum nextDirection;
    private Point snakeHead;
    private List<Point> snakeBody;

    public Snake(){
        initializeStartingPositon();
    }
    public void move() {
        moveBody();
        switch(direction){
            case UP :
                moveUp();
                break;
            case DOWN :
                moveDown();
                break;
            case LEFT :
                moveLeft();
                break;
            case RIGHT :
                moveRight();
                break;
        }

    }
    private void moveUp(){
        snakeHead.setY(snakeHead.getY()-1);

    }
    private void moveDown(){
        snakeHead.setY(snakeHead.getY()+1);
    }
    private void moveLeft(){
        snakeHead.setX(snakeHead.getX()-1);
    }
    private void moveRight(){
        snakeHead.setX(snakeHead.getX()+1);
    }
    private void moveBody(){
        for(int i = snakeBody.size()-1 ; i>0 ; i--){
            snakeBody.get(i).setFromPoint(snakeBody.get(i-1));
        }
        snakeBody.get(0).setFromPoint(snakeHead);
    }
    private void initializeStartingPositon(){
        snakeHead = new Point(Board.BOARD_SIZE/2,Board.BOARD_SIZE/2);
        snakeBody = new ArrayList<>();
        snakeBody.add(new Point(Board.BOARD_SIZE/2,Board.BOARD_SIZE/2-1));
        snakeBody.add(new Point(Board.BOARD_SIZE/2,Board.BOARD_SIZE/2-2));
        snakeBody.add(new Point(Board.BOARD_SIZE/2,Board.BOARD_SIZE/2-3));
        snakeBody.add(new Point(Board.BOARD_SIZE/2,Board.BOARD_SIZE/2-4));
        direction = DirectionEnum.DOWN;
        nextDirection = DirectionEnum.DOWN;
    }

    public void setDirection(DirectionEnum dir) {
        direction = dir;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setNextDirection(DirectionEnum nextDirection) {
        this.nextDirection = nextDirection;
    }

    public DirectionEnum getNextDirection() {
        return nextDirection;
    }

    public Point getSnakeHead() {
        return snakeHead;
    }

    public List<Point> getSnakeBody() {
        return snakeBody;
    }

}
