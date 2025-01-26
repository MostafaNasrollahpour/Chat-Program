package Frontend.Components;

import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField{

    private String placeholder;

    public TextField(String placeholder){
        this.placeholder = placeholder;
        setFont(new Font("Arial", Font.PLAIN, 16));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(9, 70, 158));
        setForeground(Color.WHITE);
        setCaretColor(Color.WHITE);
        setFont(new Font(null, Font.PLAIN, 30));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getText().isEmpty()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY); // Set placeholder color
            g2.setFont(getFont().deriveFont(Font.ITALIC)); // Set placeholder font style
            g2.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top * 3 );
            g2.dispose();
        }
    }

}
