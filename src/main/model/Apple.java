package main.model;

import main.model.utils.Point;

//class representing position of apple
public class Apple {

    private Point position;

        public Apple(Point position){
            this.position=position;
        }
        public Apple(){
            position = new Point(0,0);
        }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }


}
