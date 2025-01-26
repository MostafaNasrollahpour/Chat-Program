package Frontend.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

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

    @Override
    protected void paintComponent(Graphics g) {
        int cornerRadius = 10;
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded background
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        // Draw the text
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        int cornerRadius = 10;
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius));
        g2.dispose();
    }

}
