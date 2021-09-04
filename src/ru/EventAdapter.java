package ru;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class EventAdapter implements Serializable,WindowListener, ActionListener, ItemListener {

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Закрываюсь");

        try (OutputStream out = Files.newOutputStream(Paths.get("c://work/frame.srz"))){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(e.getSource());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.exit(0);

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

//    private void action (AWTEvent e) throws SQLException {
//        Connection connection = null;
//        if (((Component)e.getSource()).getParent() instanceof Frame){
//
//            Component c[] = (((Component)e.getSource()).getParent()).getComponents();
//            for (int i = 0; i < c.length; i++) {
//                if(c[i] instanceof Button){
//                    if(c[i].getName().equals("user")){
////                        addTextToTextArea((TextArea) c[i], (Component) e.getSource());
//
//                        try {
//                            connection = DriverManager.getConnection("jdbc:postgresql://192.168.56.200:5432/test",user.getText(),password.getText());
//                        }catch (Exception ex){
//                            System.err.println(ex);
//                        }
//
//                    }else if(c[i].getName().equals("password")){
////                        addTextToTextArea((TextArea) c[i], (Component) e.getSource());
////                        System.out.println(c[i].getS);
//                        try(Statement sD = connection.createStatement()) {
//                            try(ResultSet rD = sD.executeQuery("select dname from scott.dept")){
//                                while (rD.next()){
//                                    addTextToTextArea((TextArea) c[i], ;
//                                }
//                            }catch (Exception ex){
//                                throw ex;
//                            }
//
//                        }catch (Exception ex){
//                            throw ex;
//                        }
//
//
//                        }
//
//                    }
//                }
//
//            }
//        }


//    private void addTextToTextArea(TextArea t,String s){
//
//            t.append(s);
//
//    }
}
