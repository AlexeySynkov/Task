package ru;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class Main {


    public static void main(String[] args) {


        Frame frame = null;

        final Connection[] connection = {null};

        try (InputStream out = Files.newInputStream(Paths.get("c://work/frame.srz"))) {
            frame = (Frame) new ObjectInputStream(out).readObject();
        } catch (Exception e) {
            frame = new Frame();
            frame.addWindowListener(new EventAdapter());
            frame.setSize(600, 400);

            TextField user = new TextField("", 20);
            user.setName("user");
            frame.add(user);

            JPasswordField password = new JPasswordField("", 20);
            password.setName("password");
            frame.add(password);

            Button buttonConnect = new Button("connect");
            buttonConnect.setSize(40, 20);
            buttonConnect.setName("buttonConnect");
            buttonConnect.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        connection[0] = DriverManager.getConnection("jdbc:postgresql://192.168.56.200:5432/test", user.getText(), password.getText());
                    } catch (Exception ex) {
                        System.err.println(ex);
                    }
                }
            });
            frame.add(buttonConnect);

            TextArea select = new TextArea(5, 80);
            select.setName("select");
            frame.add(select);

            TextArea result = new TextArea(5, 80);
            result.setName("result");
            frame.add(result);

            Button buttonSql = new Button("sql");
            buttonSql.setSize(40, 20);
            buttonSql.setName("buttonSql");
            buttonSql.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg1) {
                    try (Statement sD = connection[0].createStatement()) {
                        try (ResultSet rD = sD.executeQuery(select.getText())) {
                            while (rD.next()) {
                                for (int i = 1; i <= rD.getMetaData().getColumnCount(); i++) {
                                    result.append(rD.getObject(rD.getMetaData().getColumnName(i)) + " ; ");
                                }
                            }
                        } catch (Exception e) {
                            throw e;
                        }

                    } catch (Exception e) {
                        try {
                            throw e;
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
            frame.add(buttonSql);

            frame.setLayout(new FlowLayout());

        }
        frame.setVisible(true);
    }

}

