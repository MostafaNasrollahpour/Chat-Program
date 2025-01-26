package Frontend.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassField extends JPasswordField {

    private String placeholder;
    private Button toggleButton;
    private boolean passwordVisible = false;

    public PassField(String placeholder) {
        this.placeholder = placeholder;

        setFont(new Font("Arial", Font.PLAIN, 16));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(9, 70, 158));
        setForeground(Color.WHITE);
        setCaretColor(Color.WHITE);
        setFont(new Font(null, Font.PLAIN, 30));

        toggleButton = new Button("Show", true);

        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                togglePasswordVisibility();
            }
        });


        setLayout(new BorderLayout());
        add(toggleButton, BorderLayout.EAST);
    }

    private void togglePasswordVisibility() {
        if (passwordVisible) {
            // Hide the password
            setEchoChar('•');
            toggleButton.setText("Show");
        } else {
            // Show the password
            setEchoChar((char) 0);
            toggleButton.setText("Hide");
        }
        passwordVisible = !passwordVisible;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getPassword().length == 0) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY); // Set placeholder color
            g2.setFont(getFont().deriveFont(Font.ITALIC)); // Set placeholder font style
            g2.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top * 3);
            g2.dispose();
        }
    }
}