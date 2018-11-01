package main.view;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public GameWindow(){
        super("SnakeApp");
        this.setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        //GridLayout()
        Board board = new Board();
        add(board);
        this.setVisible(true);

    }
}
