package VIEW;

import CONTROLLER.controllerAdmin;
import MODEL.*;
import javax.swing.*;
import java.awt.*;

public class REG extends JFrame {
    JButton menuUtama;
    JLabel judul, back;
    JTextField username,pass,nip;

    controllerAdmin adminController = new controllerAdmin();

    public REG() {
        setTitle("~ MANAGEMEN HOTEL ~");
        setSize(600, 400);
        setLayout(null);
        comp();
        action();
        setResizable(false);
        setVisible(true);
    }

    public void comp() {
        ImageIcon imageIcon1 = new ImageIcon("src/back.jpeg");
        back = new JLabel(imageIcon1);
        back.setIcon(new ImageIcon(imageIcon1.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH)));
        back.setBounds(0, 0, 600, 500);

        judul = new JLabel(": ~ MANAGEMENT HOTEL ~ :");
        judul.setBounds(211, 41, 180, 19);
        judul.setForeground(Color.WHITE);

        menuUtama = new JButton(" Sign in");
        menuUtama.setBounds(455, 317, 120, 27);

        String[] name = {"Username : ", "Password : ", "NIP :"};
        int y1 = 105;
        int x1 = 50;
        for (String date : name) {
            JLabel text = new JLabel(date);
            text.setBounds(x1, y1, 200, 30);
            text.setBackground(new Color(0xFFFFFF));
            text.setForeground(new Color(0xFFFFFF));
            y1 += 50;
            add(text);
        }

        username = new JTextField();
        username.setBackground(new Color(0xDED373));
        username.setBounds(50,130,200,30);

        pass = new JTextField();
        pass.setBackground(new Color(0xDED373));
        pass.setBounds(50,180,200,30);

        nip = new JTextField();
        nip.setBackground(new Color(0xDED373));
        nip.setBounds(50,230,200,30);

        add(nip);
        add(pass);
        add(username);
        add(menuUtama);
        add(judul);
        add(back);
    }


    public void action() {
        menuUtama.addActionListener(e -> {
            String name = username.getText();
            String password = pass.getText();
            String nipp = nip.getText();
            if(name.isEmpty() || password.isEmpty() || nipp.isEmpty()){
                JOptionPane.showMessageDialog(null, "isi input dulu bang");
            }else{
                JOptionPane.showMessageDialog(null, "Register berhasil");
                adminController.addAdmin(name, password, nipp);
            }
            dispose();
            System.out.println("Registrasi");
            modell.modelAdmin.commit();
            new LOGIN();
        });
    }

    public static void main(String[] args) {
        REG gui = new REG();
    }
}
