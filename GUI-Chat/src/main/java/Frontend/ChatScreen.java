package Frontend;


import Backend.Client;
import Frontend.Components.Button;
import Frontend.Components.Frame;
import Frontend.Components.Label;
import Frontend.Components.Panel;
import Frontend.Components.TextArea;
import Frontend.Components.TextField;
import Frontend.Components.Scroll;


import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ChatScreen {
    private final Frame frame;
    private Scroll scrollPane;
    private Panel mainPanel;

    private final Client client;

    public ChatScreen(String userName, Frame f) {
        client = new Client(userName);

        frame = new Frame("Chat-Screen", f);

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
        TextField messageField = new TextField("write your message...");
        Button sendButton = new Button("Send");

        sendButton.addActionListener(e -> {
            String message = messageField.getText();
            if (!message.trim().isEmpty()) {
                sendMessageToPanel(message, "Me:");
                client.sendMessage(message);
                messageField.setText("");
            }
        });

        typePanel.add(messageField, BorderLayout.CENTER);
        typePanel.add(sendButton, BorderLayout.EAST);

        frame.add(typePanel, BorderLayout.SOUTH);
    }

    private void sendMessageToPanel(String message, String sender) {
        Panel messagePanel = new Panel(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        TextArea messageArea = new TextArea(message);

        Scroll textScrollPane = new Scroll(messageArea);

        if (Objects.equals(sender, "Me:"))
            messagePanel.add(new Label(sender), BorderLayout.WEST);
        else
            messagePanel.add(new Label(sender), BorderLayout.EAST);

        // Add the JScrollPane to the message panel
        messagePanel.add(textScrollPane, BorderLayout.CENTER);

        // Add the message panel to the main panel
        mainPanel.add(messagePanel);

        mainPanel.refresh();

        // Scroll to the bottom to show the latest message
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMaximum());
    }

    public void getMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    String message = client.getMessage();
                    String[] messageArray = message.split(":");
                    sendMessageToPanel(messageArray[1].trim(), messageArray[0].trim());
                }
            }
        }).start();
    }

}