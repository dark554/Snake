package main.view;

import main.model.ObjectsContainer;

import javax.swing.*;
import main.model.utils.Point;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.List;

//board on which snake moves
public class Board extends JPanel {

        private BoardField[][] fields;
        public static final int BOARD_SIZE = 30;
        public  Board(){
            super();
            //TODO setting size of fields

            setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));
            fields = new BoardField[BOARD_SIZE][BOARD_SIZE];
            for(int i = 0; i<BOARD_SIZE; i++){
                for(int j = 0; j<BOARD_SIZE; j++){
                    fields[i][j] = new BoardField();
                    add(fields[i][j]);
                }
            }
        }
    public void update(ObjectsContainer model){
            clearBoard();
            updateSnake(model.getSnake().getSnakeHead());
            updateSnakeBody(model.getSnake().getSnakeBody());
            revalidate();
            repaint();
    }
    private void updateSnake(Point snakeHead){
            fields[snakeHead.getY()][snakeHead.getX()].setBackground(Color.GREEN);
    }
    private void updateSnakeBody(List<Point> snakeBody){
            for(Point p : snakeBody){
                fields[p.getY()][p.getX()].setBackground(Color.ORANGE);
        }
    }
    private void clearBoard(){
        for(int i = 0; i<BOARD_SIZE; i++){
            for(int j = 0; j<BOARD_SIZE; j++){
                fields[i][j].setBackground(Color.WHITE);
            }
        }
    }
}
