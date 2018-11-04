package main.view;

import main.model.GameData;
import main.model.ObjectsContainer;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private Board board;
    private GameInfo gameInfo;

    public GameWindow(){
        super("SnakeApp");
        this.setSize(1300,900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        board = new Board();
        add(board,BorderLayout.CENTER);
        gameInfo = new GameInfo();
        add(gameInfo,BorderLayout.EAST);
        this.setResizable(false);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void update(GameData gameData) {
        board.update(gameData.getObjects());
        getGameInfo().getScoreLabel().setText("Score: " + gameData.getScore());
        getGameInfo().getTimeLabel().setText("Time: " + gameData.getPeriod());
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }
}
