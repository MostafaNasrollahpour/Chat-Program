package Frontend;

import Backend.Database.DataBase;
import Frontend.Components.Button;
import Frontend.Components.Frame;
import Frontend.Components.Panel;
import Frontend.Components.PassField;
import Frontend.Components.TextField;


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

        DataBase dataBase = new DataBase();

        button.addActionListener(actionEvent -> {
            var result = dataBase.signIn(userName.getText(), new String(password.getPassword()));
            if (!result.equals("OK")){
                System.out.println(result);
                return;
            }
            new ChatScreen(userName.getText(), frame);
            frame.dispose();
        });


        this.frame.add(panel, BorderLayout.NORTH);


        this.frame.setVisible(true);
    }
}
