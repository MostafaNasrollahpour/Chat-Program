package Frontend.Components;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton{

    public Button(String text, boolean pass){
        super(text);
        setFocusable(false);

        if(pass){
            setBackground(new Color(9, 70, 158));
            setForeground(Color.WHITE);
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        }else{
            setFont(new Font("Arial", Font.BOLD, 16));
            setBackground(new Color(100, 150, 255));
            setForeground(Color.WHITE);
            setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        }
    }

    public Button(String text){
        this(text, false);
    }

}
