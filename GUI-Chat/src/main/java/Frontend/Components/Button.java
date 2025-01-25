package Frontend.Components;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton{

    public Button(String text){
        super(text);
        setFont(new Font("Arial", Font.BOLD, 16));
        setBackground(new Color(100, 150, 255));
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setFocusable(false);
    }

}
