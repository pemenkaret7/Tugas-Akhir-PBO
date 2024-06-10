package VIEW;

import javax.swing.*;
import java.awt.*;

public class MENU1 extends JFrame{
    public JLabel judul,back,menu;

    JButton kembali,button;
    public MENU1(){
        setTitle("~ MANAGEMEN HOTEL ~");
        setSize(600,400);
        setLayout(null);
        component();
        action();
        setResizable(false);
        setVisible(true);
    }

    public void component(){
        ImageIcon imageIcon = new ImageIcon("src/back.jpeg");
        back = new JLabel(imageIcon);
        back.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(600,500, Image.SCALE_SMOOTH)));
        back.setBounds(0,0,600,500);

        judul= new JLabel(": ~ MANAGEMENT HOTEL ~ :");
        judul.setBounds(207,41,180,19);
        judul.setForeground(Color.WHITE);

        menu = new JLabel(": ~~~ MENU ~~~~ :");
        menu.setBounds(235,55,180,22);
        menu.setForeground(Color.WHITE);

        String [] fitur = {"Tambah Data","View Kamar","Edit Kamar","Check-in","Check-out","Lihat Reservasi","Lihat Kamar Kosong","Lihat Tamu"};
        int y = 100;
        int x = 50;
        for (String data:fitur){
            JButton tombo = new JButton(data);
            tombo.setBounds(x, y,200,30);
            tombo.setBackground(new Color(0xDED373));
            y+=50;
            add(tombo);
            if (data.equals("Check-in")){
                x = 340;
                y = 100;
            }
        }

        kembali = new JButton("Back");
        kembali.setBounds(28,317,120,27);

        add(kembali);
        add(menu);
        add(judul);
        add(back);
    }

    public void action() {
        kembali.addActionListener((action ->{
            dispose();
            System.out.println("kembali ke login");
            new LOGIN();
        }));

        for (Component component : getContentPane().getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                switch (button.getText()) {
                    case "Tambah Data":
                        button.addActionListener((action -> {
                            System.out.println("MASUK TAMBAH DATA");
                            dispose();
                            System.out.println("tambah data");
                            new TD();
                        }));
                        break;
                    case "View Kamar":
                        button.addActionListener((action -> {
                            dispose();
                            System.out.println("informasi seluruh kamar ");
                            new INFOKAMAR();
                        }));
                        break;
                    // Tambahkan case untuk tombol-tombol lain di sini
                    case "Edit Kamar":
                        button.addActionListener((action -> {
                            dispose();
                            System.out.println("masuk menu update");
                            new EDIT();
                        }));
                        break;
                    case "Check-in":
                        button.addActionListener((action -> {
                            dispose();
                            System.out.println("masuk cekin");
                            new CEKIN();
                        }));
                        break;
                    case "Check-out":
                        button.addActionListener((action -> {
                            dispose();
                            System.out.println("masuk cekout");
                            new CEKOUT();
                        }));
                        break;
                    case "Lihat Reservasi":
                        button.addActionListener((action -> {
                            dispose();
                            System.out.println("lihat data pemesanan");
                            new LIHATRESERVASI();
                        }));
                        break;
                    case "Lihat Kamar Kosong":
                        button.addActionListener((action -> {
                            dispose();
                            System.out.println("lihat kamar tersedia");
                            new KAMARKOSONG();
                        }));
                        break;
                    case "Lihat Tamu":
                        button.addActionListener((action -> {
                            dispose();
                            System.out.println("lihat data tamu");
                            new DATATAMU();
                        }));
                        break;
                }
            }
        }
    }
    public static void main(String[] args){
            MENU1 gui = new MENU1();

        }
}


