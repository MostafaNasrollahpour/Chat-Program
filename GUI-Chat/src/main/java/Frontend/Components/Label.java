package Frontend.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Label extends JLabel {

    private int cornerRadius = 20;

    public Label(String message){
        super(message);
        setFont(new Font("Arial", Font.PLAIN, 14));
        setOpaque(true);
        setBackground(new Color(0, 231, 226));
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }



    @Override
    protected void paintComponent(Graphics g) {
        // Create a Graphics2D object for better rendering
        Graphics2D g2d = (Graphics2D) g.create();

        // Enable anti-aliasing for smoother edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create a rounded rectangle shape
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(
                0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius
        );

        // Clip the graphics to the rounded rectangle shape
        g2d.setClip(roundedRectangle);

        // Fill the background with the label's background color
        if (getBackground() != null) {
            g2d.setColor(getBackground());
            g2d.fill(roundedRectangle);
        }

        // Draw the text
        super.paintComponent(g2d);

        // Dispose of the Graphics2D object
        g2d.dispose();
    }

}
