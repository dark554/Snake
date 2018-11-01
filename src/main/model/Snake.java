package main.model;

import main.enums.DirectionEnum;

//class containing information about position of snake ( x,y of head, body, direction of movement)
public class Snake {
    DirectionEnum direction;
    //head, body

    public void move() {
        if(direction == DirectionEnum.UP) {
            //moveUp();
        }
    }

    public void setDirection(DirectionEnum dir) {
        direction = dir;
    }
}
