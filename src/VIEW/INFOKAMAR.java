package VIEW;
import CONTROLLER.*;
import MODEL.modell;
import NODE.Kamar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class INFOKAMAR extends JFrame{
    JLabel back,judul,menu;
    JButton kembali;

    JTable tabel;
    DefaultTableModel model;
    public INFOKAMAR(){
        setTitle("~ MANAGEMEN HOTEL ~");
        setSize(600,400);
        setLayout(null);
        comp();
        action();
        setResizable(false);
        setVisible(true);
    }



    public void comp(){
        ImageIcon imageIcon1 = new ImageIcon("src/back.jpeg");
        back = new JLabel(imageIcon1);
        back.setIcon(new ImageIcon(imageIcon1.getImage().getScaledInstance(600,500, Image.SCALE_SMOOTH)));
        back.setBounds(0,0,600,500);

        judul= new JLabel(": ~ MANAGEMENT HOTEL ~ :");
        judul.setBounds(207,41,180,19);
        judul.setForeground(Color.WHITE);

        menu = new JLabel(": ~~~ INFORMASI KAMAR ~~~~ :");
        menu.setBounds(200,55,205,22);
        menu.setForeground(Color.WHITE);

        kembali = new JButton("Back");
        kembali.setBounds(28,317,120,27);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Kode Kamar","Jenis Kamar", "Harga Kamar", "Status"});

        tabel = new JTable(model);
        tabel.setBackground(new Color(0xABFFFFFF));


        for (Kamar kamar : modell.modelKamar.kamarList) {
            model.addRow(new Object[]{
                    kamar.getKodeKamar(),
                    kamar.getJeniskamar(),
                    kamar.getHarga(),
                    kamar.getStatus()
            });
        }

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabel);
        scroll.setBounds(30, 130, 520, 170);

        add(scroll);
        add(judul);
        add(menu);
        add(kembali);
        add(back);

    }

    private void action() {
        kembali.addActionListener((action ->{
            dispose();
            System.out.println("kembali ke menu");
            new MENU1();
        }));
    }

    public static void main(String[] args) {
        INFOKAMAR td = new INFOKAMAR();

    }
}
