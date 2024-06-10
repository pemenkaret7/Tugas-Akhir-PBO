package VIEW;

import javax.swing.*;
import java.awt.*;
import CONTROLLER.*;

public class CEKOUT extends JFrame{
    JLabel back,judul,menu;
    JButton create,kembali;
    JTextField KodeKamar,Namapemesan;
    controllerPemesanan pesan = new controllerPemesanan();


    public CEKOUT(){
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

        menu = new JLabel(": ~~~ CEKOUT KAMAR ~~~~ :");
        menu.setBounds(190,55,205,22);
        menu.setForeground(Color.WHITE);

        String[] name ={"Nama Pemesan : ","Kode kamar : "};
        int y1 = 245;
        int x1 = 110;
        for (String date:name) {
            JLabel text = new JLabel(date);
            text.setBounds(x1, y1, 200, 30);
            text.setBackground(new Color(0xFFFFFF));
            text.setForeground(new Color(0xFFFFFF));
            x1 += 256;
            add(text);
        }


        Namapemesan = new JTextField();
        Namapemesan.setBounds(105,270,125,24);
        Namapemesan.setBackground(new Color(0xDED373));

        KodeKamar = new JTextField();
        KodeKamar.setBounds(360,270,125,24);
        KodeKamar.setBackground(new Color(0xded373));

        create = new JButton("Check-out");
        create.setBounds(445,317,120,27);

        kembali = new JButton("Back");
        kembali.setBounds(28,317,120,27);

        add(judul);
        add(menu);
        add(kembali);
        add(create);
        add(Namapemesan);
        add(KodeKamar);
        add(back);

    }

    private void action() {
        kembali.addActionListener((action ->{
            dispose();
            System.out.println("kembali ke menu");
            new MENU1();
        }));
        create.addActionListener((action ->{
            String nama= Namapemesan.getText();
            int kode =  Integer.parseInt(KodeKamar.getText());
            boolean cek = pesan.checkoutPesanan(nama,kode);
            if (!cek){
                JOptionPane.showMessageDialog(null, "Kode kamar atau nama pemesan tidak ada!!!");
            }
                dispose();
                System.out.println("keluar checkout");
                new MENU1();
            }));
    }

    public static void main(String[] args) {
        CEKOUT td = new CEKOUT();

    }
}

