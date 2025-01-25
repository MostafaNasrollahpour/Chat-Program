package Frontend.Components;

import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField{

    public TextField(){
        setFont(new Font("Arial", Font.PLAIN, 16));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(9, 70, 158));
        setForeground(Color.WHITE);
        setCaretColor(Color.WHITE);
        setFont(new Font(null, Font.PLAIN, 30));
    }

}
