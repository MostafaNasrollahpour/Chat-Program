package Frontend.Components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Panel extends JPanel{

    public Panel(LayoutManager layoutManager){
        setPreferredSize(new Dimension(500, 100));
        setBackground(new Color(200, 220, 255));
        setLayout(layoutManager);
    }

    public Panel(){
        setBackground(new Color(0, 0, 0, 0));
    }

    public Panel(Border border){
        setLayout(new BorderLayout());
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        setBorder(border);
    }

}
