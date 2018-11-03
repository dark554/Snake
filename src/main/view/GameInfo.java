package main.view;

import javax.swing.*;
import java.awt.*;

public class GameInfo extends JPanel {
    private JLabel scoreLabel;
    private JLabel timeLabel;
    public GameInfo(){
        super();
        setPreferredSize(new Dimension(200,900));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new GridLayout(2,1));
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(scoreLabel);
        timeLabel = new JLabel ("Time: 0");
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timeLabel);
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public JLabel getTimeLabel(){
        return timeLabel;}
}
