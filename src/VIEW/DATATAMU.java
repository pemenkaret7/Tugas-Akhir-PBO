package VIEW;
import MODEL.*;
import NODE.*;
import CONTROLLER.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class DATATAMU extends JFrame {
    JLabel back, judul, menu, NamaTamu;
    JButton kembali, cari;
    JTextField Namapemesan;
    JTable tabel;
    DefaultTableModel model;
    controllerTamu controllerTamu = new controllerTamu();

    public DATATAMU() {
        setTitle("~ MANAJEMEN HOTEL ~");
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

        judul = new JLabel(": ~ MANAJEMEN HOTEL ~ :");
        judul.setBounds(207, 41, 180, 19);
        judul.setForeground(Color.WHITE);

        menu = new JLabel(": ~~~ LIHAT DATA TAMU ~~~~ :");
        menu.setBounds(203, 55, 205, 22);
        menu.setForeground(Color.WHITE);

        NamaTamu = new JLabel("Nama Tamu : ");
        NamaTamu.setBounds(30, 85, 125, 24);
        NamaTamu.setForeground(new Color(0xFFFFFF));

        Namapemesan = new JTextField();
        Namapemesan.setBounds(30, 105, 115, 20);
        Namapemesan.setBackground(new Color(0xDED373));

        cari = new JButton("Cari");
        cari.setBounds(160, 105, 65, 20);

        kembali = new JButton("Back");
        kembali.setBounds(28, 317, 120, 27);


        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID","Nama", "Telp", "NIK", "Kode Kamar","Negara"});

        tabel = new JTable(model);
        tabel.setBackground(new Color(0xABFFFFFF));


            for (Tamu tamu : modell.modelTamu.daftartamu) {
                model.addRow(new Object[]{
                        tamu.getID(),
                        tamu.getName(),
                        tamu.getTelp(),
                        tamu.getNik(),
                        tamu.getKamar().getKodeKamar(),
                        tamu.getNegara()
                });
            }

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabel);
        scroll.setBounds(30, 130, 520, 170);

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
        kembali.addActionListener((action -> {
            dispose();
            System.out.println("kembali ke menu");
            new MENU1();
        }));

        cari.addActionListener((action -> {
            String nm = Namapemesan.getText();
            Tamu tamu = controllerTamu.ViewDataTamu(nm);
            model.setRowCount(0);
            if (tamu != null){
                for (Tamu t : modell.modelTamu.daftartamu) {
                    if (t.getName().equalsIgnoreCase(nm)) {
                        model.addRow(new Object[]{
                                t.getID(),
                                t.getName(),
                                t.getTelp(),
                                t.getNik(),
                                t.getKamar().getKodeKamar(),
                                t.getNegara()
                        });
                    }
                    System.out.println("berhasil menemukan nama tamu");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Nama Tamu gada bang");
            }
        }));
    }

    public static void main(String[] args) {
        new DATATAMU();
    }
}
