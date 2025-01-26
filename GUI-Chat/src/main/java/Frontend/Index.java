package Frontend;

import Frontend.Components.Button;
import Frontend.Components.Frame;
import Frontend.Components.Panel;

import java.awt.*;


public class Index {

    public Index(){
        Frame frame = new Frame("Hello");
        Panel panel = new Panel();

        panel.setBackground(new Color(100, 100, 255));

        Button logInButton = new Button("Login");
        Button signInButton = new Button("Sign in");

        logInButton.addActionListener(actionEvent -> {
            new Login(frame);
            frame.dispose();
        });

        signInButton.addActionListener(actionEvent -> {
            new SignIn(frame);
            frame.dispose();
        });

        panel.add(logInButton);
        panel.add(signInButton);

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}
