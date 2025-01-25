package Frontend.Components;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {

    public Label(String message){
        super(message);
        setFont(new Font("Arial", Font.PLAIN, 14));
        setOpaque(true);
        setBackground(new Color(255, 100, 100));
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

}
