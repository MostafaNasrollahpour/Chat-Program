package Frontend.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog extends JDialog{

    public Dialog(Frame frame, String errorMessage){
        super(frame, "Error", true);
        setSize(300, 200);
        setLayout(new BorderLayout());

        Label messageLabel = new Label(errorMessage, SwingConstants.CENTER);
        add(messageLabel, BorderLayout.CENTER);

        Button okButton = new Button("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(okButton, BorderLayout.SOUTH);


        setLocationRelativeTo(frame);

        setVisible(true);
    }
}