package Frontend;

import Backend.Database.DataBase;
import Frontend.Components.Button;
import Frontend.Components.Dialog;
import Frontend.Components.Frame;
import Frontend.Components.Panel;
import Frontend.Components.PassField;
import Frontend.Components.TextField;


import java.awt.*;

public class SignIn {

    Frame frame;

    public SignIn(Frame f){
        this.frame = new Frame("Sign-in", f);
        frame.getContentPane().setBackground(new Color(100, 196, 255));

        Panel panel = new Panel();
        panel.setPreferredSize(new Dimension(400, 300));


        TextField userName = new TextField("Your User-Name");
        userName.setPreferredSize(new Dimension(this.frame.getWidth() - 80, 100));
        panel.add(userName);

        PassField password = new PassField("Your Password");
        password.setPreferredSize(new Dimension(this.frame.getWidth() - 80, 100));
        panel.add(password);

        Button button = new Button("Sign in");
        panel.add(button);

        DataBase dataBase = new DataBase();

        button.addActionListener(actionEvent -> {
            var name = userName.getText().toLowerCase();
            var pass = new String(password.getPassword());

            if(name.isEmpty() || pass.isEmpty()){
                new Dialog(frame, "fill all fields");
                return;
            }
            var result = dataBase.signIn(name, pass);
            if (!result.equals("OK")){
                new Dialog(frame, result);
                return;
            }
            var chat = new ChatScreen(userName.getText(), frame);
            chat.getMessage();
            frame.dispose();
        });


        this.frame.add(panel, BorderLayout.NORTH);


        this.frame.setVisible(true);
    }
}
