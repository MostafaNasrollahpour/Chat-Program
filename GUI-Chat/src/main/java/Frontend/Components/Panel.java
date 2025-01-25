package Frontend.Components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Panel extends JPanel{

    public Panel(LayoutManager layoutManager){
        setPreferredSize(new Dimension(500, 100));
        setBackground(new Color(9, 70, 158));
        setLayout(layoutManager);
    }

    public Panel(){
        setBackground(new Color(0, 0, 0, 0));
    }

    public Panel(Border border){
        setLayout(new BorderLayout());
        setBorder(border);
        setBackground(new Color(9, 70, 158));
        setPreferredSize(new Dimension(400, 100));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
    }

    public void refresh(){
        revalidate();
        repaint();
    }

}
