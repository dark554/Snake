package main.view;

import javax.swing.*;
import java.awt.*;

public class GameInfo extends JPanel {
    private JLabel scoreLabel;
   // private JLabel timeLabel;
    public GameInfo(){
        super();
        setPreferredSize(new Dimension(200,900));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        scoreLabel = new JLabel("Score: 0");
        add(scoreLabel);
        //timeLabel = new JLabel ("Time: 0");
        //add(timeLabel);
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }
}
