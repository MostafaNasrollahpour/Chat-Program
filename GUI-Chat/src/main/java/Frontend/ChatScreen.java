package Frontend;

import javax.swing.*;
import java.awt.*;

public class ChatScreen {
    JFrame frame;
    JScrollPane scrollPane;
    JPanel mainPanel;

    public ChatScreen() {
        initFrame();
        initScreenPanel();
        initTypePanel();

        frame.setVisible(true);
    }

    private void initFrame() {
        frame = new JFrame("Chat-Screen");
        frame.setSize(500, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(240, 240, 240)); // Light gray background
    }

    private void initScreenPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical stacking
        mainPanel.setBackground(new Color(0, 0, 0, 0)); // Transparent background

        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(new Color(20, 20, 200));

        frame.add(scrollPane, BorderLayout.CENTER); // Add to CENTER to allow expansion
    }

    private void initTypePanel() {
        JPanel typePanel = new JPanel();
        typePanel.setPreferredSize(new Dimension(500, 100));
        typePanel.setBackground(new Color(200, 220, 255)); // Light blue background
        typePanel.setLayout(new BorderLayout());

        JTextField messageField = new JTextField();
        messageField.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size
        messageField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        JButton sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set font size
        sendButton.setBackground(new Color(100, 150, 255)); // Blue background
        sendButton.setForeground(Color.WHITE); // White text
        sendButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

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
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        messagePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50)); // Fixed height for each message
        messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding

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