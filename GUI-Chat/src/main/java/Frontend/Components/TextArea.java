package Frontend.Components;

import javax.swing.*;
import java.awt.*;

public class TextArea extends JTextArea {

    public TextArea(String message){
        super(message);
        setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size
        setLineWrap(true);
        setWrapStyleWord(true);
        setEditable(false);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        setBackground(new Color(9, 70, 158));
        setOpaque(true);
        setCaretColor(Color.WHITE);
        setForeground(Color.WHITE);
    }

}
