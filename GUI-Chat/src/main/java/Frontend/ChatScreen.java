package Frontend;

import Frontend.Components.*;
import Frontend.Components.Button;
import Frontend.Components.Frame;
import Frontend.Components.Panel;
import Frontend.Components.TextField;

import javax.swing.*;
import java.awt.*;


public class ChatScreen {
    Frame frame;
    Scroll scrollPane;
    Panel mainPanel;

    public ChatScreen() {
        frame = new Frame();
        initScreenPanel();
        initTypePanel();

        frame.setVisible(true);
    }

    private void initScreenPanel() {
        mainPanel = new Panel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        scrollPane = new Scroll(mainPanel);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    private void initTypePanel() {

        Panel typePanel = new Panel(new BorderLayout());
        TextField messageField = new TextField();
        Button sendButton = new Button("Send");

        sendButton.addActionListener(e -> {
            String message = messageField.getText();
            if (!message.isEmpty()) {
                addMessageToScreen(message);
                messageField.setText("");
            }
        });

        typePanel.add(messageField, BorderLayout.CENTER);
        typePanel.add(sendButton, BorderLayout.EAST);

        frame.add(typePanel, BorderLayout.SOUTH);
    }

    private void addMessageToScreen(String message) {
        Panel messagePanel = new Panel(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font size
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(200, 220, 255)); // Light blue background
        messageLabel.setForeground(Color.BLACK); // Text color
        messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding

        messagePanel.add(messageLabel, BorderLayout.WEST);
        mainPanel.add(messagePanel);

        // Refresh the panel to show the new message
        mainPanel.revalidate();
        mainPanel.repaint();

        // Scroll to the bottom to show the latest message
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMaximum());
    }

    public static void main(String[] args) {
        new ChatScreen();
    }
}