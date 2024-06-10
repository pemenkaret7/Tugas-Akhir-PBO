package VIEW;
import CONTROLLER.*;
import javax.swing.*;
import java.awt.*;
public class TD extends JFrame{

    JComboBox comboBox;
    JLabel back,judul,menu;
    JButton create,kembali;
    JTextField Harga;

    controllerKamar controllerKamar = new controllerKamar();

    public TD(){
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

        menu = new JLabel(": ~~~ TAMBAH DATA KAMAR ~~~~ :");
        menu.setBounds(190,55,205,22);
        menu.setForeground(Color.WHITE);

        String[] name ={"Jenis Kamar : ","Harga kamar : "};
        int y1 = 143;
        int x1 = 100;
        for (String date:name) {
            JLabel text = new JLabel(date);
            text.setBounds(x1, y1, 200, 30);
            text.setBackground(new Color(0xFFFFFF));
            text.setForeground(new Color(0xFFFFFF));
            x1 += 240;
            add(text);
        }

        String[] butt = {"VIP","REGULER"};
        comboBox = new JComboBox<>(butt);
        comboBox.setBounds(100,170,130,27);
        comboBox.setBackground(new Color(0xDED373));

        Harga= new JTextField();
        Harga.setBounds(340,170,130,25);
        Harga.setBackground(new Color(0xded373));

        create = new JButton("Create");
        create.setBounds(450,317,120,27);

        kembali = new JButton("Back");
        kembali.setBounds(28,317,120,27);

        add(judul);
        add(menu);
        add(kembali);
        add(create);
        add(Harga);
        add(comboBox);
        add(back);

    }

    public void action(){
        kembali.addActionListener((action ->{
            dispose();
            System.out.println("kembali ke menu");
            new MENU1();
        }));
        create.addActionListener(e -> {
            String cm = (String) comboBox.getSelectedItem();//untuk memilih combobox
            int hg = Integer. parseInt(Harga.getText());
            controllerKamar.addKamar(cm,hg);
            dispose();
            System.out.println("create data kamar");
            new MENU1();
        });
    }

    public static void main(String[] args) {
        TD td = new TD();

    }
}
