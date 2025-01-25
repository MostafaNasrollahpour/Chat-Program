package Frontend.Components;

import javax.swing.*;
import java.awt.*;

public class TextArea extends JTextArea {

    public TextArea(String message){
        super(message);
        setFont(new Font("Arial", Font.PLAIN, 14)); // Set font size
        setLineWrap(true);
        setWrapStyleWord(true);
        setEditable(false);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

}
