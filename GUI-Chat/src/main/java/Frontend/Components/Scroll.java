package Frontend.Components;

import javax.swing.*;
import java.awt.*;

public class Scroll extends JScrollPane {

    public Scroll(JPanel panel){
        super(panel);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        setBackground(new Color(20, 20, 200));
    }

    public Scroll(JTextArea textArea){
        super(textArea);
        setBorder(null); // Remove the border
        setOpaque(false); // Make the background transparent
        getViewport().setOpaque(false); // Make the viewport transparent
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

}
