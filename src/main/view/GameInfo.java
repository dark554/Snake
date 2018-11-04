package main.view;

import javax.swing.*;
import java.awt.*;

public class GameInfo extends JPanel {
    private JLabel scoreLabel;
    private JLabel timeLabel;
    private JLabel controlsLabel;
    public GameInfo(){
        super();
        setPreferredSize(new Dimension(400,900));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new GridLayout(3,1));
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(scoreLabel);
        timeLabel = new JLabel ("Time: 0");
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timeLabel);
        controlsLabel = new JLabel("<html> Controls: <br/>Keyboard arrows - snake movement <br/> Restart game: r</html>");
        controlsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(controlsLabel);
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public JLabel getTimeLabel(){
        return timeLabel;}
}
