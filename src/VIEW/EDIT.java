package VIEW;
import CONTROLLER.*;
import NODE.Kamar;
import MODEL.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EDIT extends JFrame {
        JComboBox comboBox,comboBox1;
        JLabel back,judul,menu,update;
        JButton create,kembali;
        JTextField kode;

        controllerKamar controllerKamar = new controllerKamar();

        public EDIT(){
            setTitle("~ MANAGEMEN HOTEL ~");
            setSize(600,400);
            setLayout(null);
            company();
            action();
            setResizable(false);
            setVisible(true);
        }

        public void company(){
            ImageIcon imageIcon1 = new ImageIcon("src/back.jpeg");
            back = new JLabel(imageIcon1);
            back.setIcon(new ImageIcon(imageIcon1.getImage().getScaledInstance(600,500, Image.SCALE_SMOOTH)));
            back.setBounds(0,0,600,500);

            judul= new JLabel(": ~ MANAGEMENT HOTEL ~ :");
            judul.setBounds(207,41,180,19);
            judul.setForeground(Color.WHITE);

            menu = new JLabel(": ~~~ UPDATE DATA KAMAR ~~~~ :");
            menu.setBounds(190,55,205,22);
            menu.setForeground(Color.WHITE);

            update= new JLabel("Update : ");
            update.setBounds(225,107,130,27);
            update.setForeground(Color.WHITE);

            String[] name ={"Kode Kamar : ","Jenis kamar : "};
            int y1 = 193;
            int x1 = 100;
            for (String date:name) {
                JLabel text = new JLabel(date);
                text.setBounds(x1, y1, 200, 30);
                text.setBackground(new Color(0xFFFFFF));
                text.setForeground(new Color(0xFFFFFF));
                x1 += 260;
                add(text);
            }

            String[] butt = {"JENIS KAMAR","HARGA"};
            comboBox1 = new JComboBox<>(butt);
            comboBox1.setBounds(225,130,130,27);
            comboBox1.setBackground(new Color(0xDED373));

            String[] jenis = {"VIP","REGULER"};
            comboBox = new JComboBox<>(jenis);
            comboBox.setBounds(360,220,130,25);
            comboBox.setBackground(new Color(0xDED373));

            kode = new JTextField();
            kode.setBounds(100,220,130,25);
            kode.setBackground(new Color(0xded373));

            create = new JButton("Update");
            create.setBounds(450,317,120,27);

            kembali = new JButton("Back");
            kembali.setBounds(28,317,120,27);


            add(update);
            add(kode);
            add(judul);
            add(menu);
            add(kembali);
            add(create);
            add(comboBox1);
            add(comboBox);
            add(back);

        }



    private void action() {
            comboBox1.addActionListener((action ->{
                System.out.println("masuk edit harga");
                dispose();
                new EditHarga();
            }));
        kembali.addActionListener((action ->{
            dispose();
            System.out.println("kembali ke menu");
            new MENU1();
        }));

        create.addActionListener((action ->{
            String com = (String) comboBox.getSelectedItem();
            int kd = Integer.parseInt(kode.getText());
                boolean cek = controllerKamar.updateJeniskamar(kd,com);
                if (!cek){
                    JOptionPane.showMessageDialog(null, "Kode kamar gaenek");
                }
                System.out.println("Update");
                new MENU1();


        }));


    }

        public static void main(String[] args) {
            EDIT td = new EDIT();

        }
    }

