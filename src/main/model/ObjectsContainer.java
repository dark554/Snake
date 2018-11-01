package main.model;

import java.util.List;

//class holds information about position of object on the board

public class ObjectsContainer {
    private Snake snake;
    private List<Apple> apples;

    public ObjectsContainer(){
        snake = new Snake();
    }

    public boolean isCollision() {
        return false;

    }

    public Snake getSnake() {

        return snake;
    }
}
