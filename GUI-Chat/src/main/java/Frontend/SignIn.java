package Frontend;

import Frontend.Components.Button;
import Frontend.Components.Frame;
import Frontend.Components.Label;
import Frontend.Components.Panel;
import Frontend.Components.PassField;
import Frontend.Components.TextField;

import javax.swing.*;
import java.awt.*;

public class SignIn {

    Frame frame;

    public SignIn(Frame f){
        this.frame = new Frame("Sign-in", f);

        Panel panel = new Panel();
        panel.setPreferredSize(new Dimension(400, 300));


        TextField userName = new TextField("Your User-Name");
        userName.setPreferredSize(new Dimension(this.frame.getWidth() - 80, 100));
        panel.add(userName);

        PassField password = new PassField("Your Password");
        password.setPreferredSize(new Dimension(this.frame.getWidth() - 80, 100));
        panel.add(password);

        Button button = new Button("Continue");
        panel.add(button);


        this.frame.add(panel, BorderLayout.NORTH);


        this.frame.setVisible(true);
    }
}
