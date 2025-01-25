package Frontend;


import Frontend.Components.Button;
import Frontend.Components.Frame;
import Frontend.Components.Panel;
import Frontend.Components.TextArea;
import Frontend.Components.TextField;
import Frontend.Components.Scroll;


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
                sendMessage(message);
                messageField.setText("");
            }
        });

        typePanel.add(messageField, BorderLayout.CENTER);
        typePanel.add(sendButton, BorderLayout.EAST);

        frame.add(typePanel, BorderLayout.SOUTH);
    }

    private void sendMessage(String message) {
        Panel messagePanel = new Panel(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        TextArea messageArea = new TextArea(message);

        Scroll textScrollPane = new Scroll(messageArea);

        messagePanel.setPreferredSize(new Dimension(400, 100));
        messagePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        // Add the JScrollPane to the message panel
        messagePanel.add(textScrollPane, BorderLayout.CENTER);
        messagePanel.setBackground(new Color(9, 70, 158));

        // Add the message panel to the main panel
        mainPanel.add(messagePanel);

        mainPanel.refresh();

        // Scroll to the bottom to show the latest message
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMaximum());
    }

    public static void main(String[] args) {
        new ChatScreen();
    }
}