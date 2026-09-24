package com.mostafanasrollahpour.chat.client.ui;

import com.mostafanasrollahpour.chat.database.Database;
import com.mostafanasrollahpour.chat.client.ui.components.Button;
import com.mostafanasrollahpour.chat.client.ui.components.Dialog;
import com.mostafanasrollahpour.chat.client.ui.components.Frame;
import com.mostafanasrollahpour.chat.client.ui.components.Panel;
import com.mostafanasrollahpour.chat.client.ui.components.PassField;
import com.mostafanasrollahpour.chat.client.ui.components.TextField;


import java.awt.*;

public class Register {

    Frame frame;

    public Register(Frame f){
        this.frame = new Frame("Register", f);
        frame.getContentPane().setBackground(new Color(100, 196, 255));

        Panel panel = new Panel();
        panel.setPreferredSize(new Dimension(400, 300));


        TextField userName = new TextField("Your User-Name");
        userName.setPreferredSize(new Dimension(this.frame.getWidth() - 80, 100));
        panel.add(userName);

        PassField password = new PassField("Your Password");
        password.setPreferredSize(new Dimension(this.frame.getWidth() - 80, 100));
        panel.add(password);

        Button button = new Button("Register");
        panel.add(button);

        Database dataBase = new Database();

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
