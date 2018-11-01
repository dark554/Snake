package main.view;

import javax.swing.*;
import java.awt.*;

public class GameInfo extends JPanel {
    public GameInfo(){
        super();
        setPreferredSize(new Dimension(200,900));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel label = new JLabel("Test");
        add(label);
    }
}
