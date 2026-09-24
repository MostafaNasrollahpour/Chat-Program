package com.mostafanasrollahpour.chat.client.ui;

import com.mostafanasrollahpour.chat.client.ui.components.Button;
import com.mostafanasrollahpour.chat.client.ui.components.Frame;
import com.mostafanasrollahpour.chat.client.ui.components.Panel;

import java.awt.*;


public class Index {

    public Index(){
        Frame frame = new Frame("Hello");
        Panel panel = new Panel();

        panel.setBackground(new Color(100, 100, 255));

        Button logInButton = new Button("Login");
        Button signInButton = new Button("Register");

        logInButton.addActionListener(actionEvent -> {
            new Login(frame);
            frame.dispose();
        });

        signInButton.addActionListener(actionEvent -> {
            new Register(frame);
            frame.dispose();
        });

        panel.add(logInButton);
        panel.add(signInButton);

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}
