package Frontend.Components;

import javax.swing.*;
import java.awt.*;

public class Scroll extends JScrollPane {

    public Scroll(JPanel panel){
        super(panel);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        setBackground(new Color(20, 20, 200));
    }

}
