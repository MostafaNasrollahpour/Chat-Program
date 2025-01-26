package Frontend.Components;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame(String title){
        super(title);
        this.setSize(500, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }

}
