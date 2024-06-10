package VIEW;
import CONTROLLER.*;
import MODEL.modell;
import NODE.Pemesanan;
import NODE.Tamu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LIHATRESERVASI extends JFrame {
    JLabel back,judul,menu,NamaTamu;
    JButton kembali,cari;
    JTextField Namapemesan;
    JTable tabel;
    DefaultTableModel model;

    controllerPemesanan controllerPemesanan = new controllerPemesanan();
    public LIHATRESERVASI(){
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

        menu = new JLabel(": ~~~ LIHAT RESERVASI ~~~~ :");
        menu.setBounds(203,55,205,22);
        menu.setForeground(Color.WHITE);

        NamaTamu = new JLabel("Nama Pemesan : ");
        NamaTamu.setBounds(30,85,125,24);
        NamaTamu.setForeground(new Color(0xFFFFFF));

        Namapemesan = new JTextField();
        Namapemesan.setBounds(30,105,115,20);
        Namapemesan.setBackground(new Color(0xDED373));

        cari = new JButton("Cari");
        cari.setBounds(160,105,65,20);

        kembali = new JButton("Back");
        kembali.setBounds(28,317,120,27);


        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID","Nama","Kode kamar","Jenis Kamar","Check-In","Check-Out","Total Harga","Jenis Pembayaran"});

        tabel = new JTable(model);
        tabel.setBackground(new Color(0xABFFFFFF));

            for (Pemesanan pemesanan : modell.modelPemesanan.daftarPemesanan) {
                model.addRow(new Object[]{
                        pemesanan.getID(),
                        pemesanan.getNama(),
                        pemesanan.getKamar().getKodeKamar(),
                        pemesanan.getKamar().getJeniskamar(),
                        pemesanan.getTglCheckin(),
                        pemesanan.getTglCheckout(),
                        pemesanan.getTotharga(),
                        pemesanan.getJenisPembayaran()
                });
            }


        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabel);
        scroll.setBounds(5, 130, 570, 170);

        add(scroll);
        add(cari);
        add(NamaTamu);
        add(judul);
        add(menu);
        add(kembali);
        add(Namapemesan);
        add(back);

    }

    private void action() {
        kembali.addActionListener((action ->{
            dispose();
            System.out.println("kembali ke menu");
            new MENU1();
        }));
        cari.addActionListener((action ->{
            String nm = Namapemesan.getText();
            Pemesanan cek = controllerPemesanan.viewNamaPemesan(nm);
            model.setRowCount(0);
            if (cek != null){
                for (Pemesanan pemesanan : modell.modelPemesanan.daftarPemesanan) {
                    if (pemesanan.getNama().equalsIgnoreCase(nm)) {
                        model.addRow(new Object[]{
                                pemesanan.getID(),
                                pemesanan.getNama(),
                                pemesanan.getKamar().getKodeKamar(),
                                pemesanan.getKamar().getJeniskamar(),
                                pemesanan.getTglCheckin(),
                                pemesanan.getTglCheckout(),
                                pemesanan.getTotharga(),
                                pemesanan.getJenisPembayaran()
                        });
                    }
                }
                System.out.println("berhasil menemenukan nama pemesan");

            } else {
                JOptionPane.showMessageDialog(null, "Nama Pemesan gada bang");
            }
        }));


    }

    public static void main(String[] args) {
        LIHATRESERVASI td = new LIHATRESERVASI();

    }
}
