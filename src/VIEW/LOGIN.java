package VIEW;

import CONTROLLER.*;
import javax.swing.*;
import java.awt.*;

public class LOGIN extends JFrame{
    private JButton regist,login;
    private JLabel judul,logo,back;

    private JTextField username;
    private JPasswordField password;

    controllerAdmin adminController = new controllerAdmin();

    public LOGIN(){
        setTitle("~ MANAGEMEN HOTEL ~");
        setSize(600,400);
        setLayout(null);
        Jlabel();
        action();
        setResizable(false);
        setVisible(true);
    }

    public void Jlabel(){
        ImageIcon imageIcon1 = new ImageIcon("src/back.jpeg");
        back = new JLabel(imageIcon1);
        back.setIcon(new ImageIcon(imageIcon1.getImage().getScaledInstance(600,500, Image.SCALE_SMOOTH)));
        back.setBounds(0,0,600,500);

        ImageIcon imageIcon = new ImageIcon("src/Poto1.png");
        logo = new JLabel(imageIcon);
        logo.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(200,150, Image.SCALE_SMOOTH)));
        logo.setBounds(203,87,193,122);

        judul= new JLabel(": ~ MANAGEMENT HOTEL ~ :");
        judul.setBounds(211,41,180,19);
        judul.setForeground(Color.WHITE);

        username  = new JTextField();
        username.setBounds(220,236,161,27);

        password  = new JPasswordField();
        password.setBounds(220,285,161,27);

        regist = new JButton("Regist");
        regist.setBounds(28,323,107,20);

        login = new JButton("Login");
        login.setBounds(455,317,107,27);

        String [] name = {"Username : ","Password : "};
        int y1 = 213;
        int x1 = 220;
        for (String date:name) {
            JLabel text = new JLabel(date);
            text.setBounds(x1, y1, 200, 30);
            text.setBackground(new Color(0xFFFFFF));
            text.setForeground(new Color(0xFFFFFF));
            y1 += 50;
            add(text);
        }


        add(login);
        add(regist);
        add(username);
        add(password);
        add(judul);
        add(logo);
        add(back);
    }

    public void action(){
        regist.addActionListener((action ->{
           dispose();
            new REG();
        }));
        login.addActionListener(e -> {
            String um = username.getText();
            String pw = String.valueOf(password.getPassword());
            System.out.println("username : " + um);
            System.out.println("pass : " + pw);
            if (adminController.cekUsername(um) && adminController.cekPass(pw)) {
                dispose();
                System.out.println("login berhasil");
                new MENU1();
            } else {
                JOptionPane.showMessageDialog(null, "isi USERNAME & PASSWORD dengan benar!!");
            }
        });
    }

    public static void main(String[] args) {
        new LOGIN();
    }
}
