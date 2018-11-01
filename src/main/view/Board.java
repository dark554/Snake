package main.view;

import main.model.ObjectsContainer;

import javax.swing.*;
import java.awt.*;

//board on which snake moves
public class Board extends JPanel {

        private JLabel[][] fields;

        public  Board(){
            super();

            BoardField bf = new BoardField();
            setBorder(BorderFactory.createLineBorder(Color.black));
        }

        public void update(ObjectsContainer model) {

        }
}
