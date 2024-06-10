package VIEW;
import CONTROLLER.*;
import javax.swing.*;
import java.awt.*;

public class CEKIN extends JFrame{
        public JLabel judul,back,menu;
        public JButton kembali,cekin;
        JTextField Nama,Telp,NIK,Negara,KodeKamar,Checkin,Checkout,JenisPembayaran;

        controllerPemesanan pesan = new controllerPemesanan();
        public CEKIN(){
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

            menu = new JLabel(": ~~~ CHECK-IN ~~~~ :");
            menu.setBounds(235,55,180,22);
            menu.setForeground(Color.WHITE);

            Nama= new JTextField();
            Nama.setBounds(70,100,150,25);
            Nama.setBackground(new Color(0xDED373));
            NIK=new JTextField();
            NIK.setBounds(70,150,150,25);
            NIK.setBackground(new Color(0xDED373));
            Telp=new JTextField();
            Telp.setBounds(70,200,150,25);
            Telp.setBackground(new Color(0xDED373));
            Negara=new JTextField();
            Negara.setBounds(70,250,150,25);
            Negara.setBackground(new Color(0xDED373));
            KodeKamar=new JTextField();
            KodeKamar.setBounds(360,100,150,25);
            KodeKamar.setBackground(new Color(0xDED373));
            Checkin=new JTextField("YYYY-MM-DD");
            Checkin.setBounds(360,150,150,25);
            Checkin.setBackground(new Color(0xDED373));
            Checkout=new JTextField("YYYY-MM-DD");
            Checkout.setBounds(360,200,150,25);
            Checkout.setBackground(new Color(0xDED373));
            JenisPembayaran=new JTextField();
            JenisPembayaran.setBounds(360,250,150,25);
            JenisPembayaran.setBackground(new Color(0xDED373));

//            String [] fitur = {"","",""," ","","YYYY-MM-DD","YYYY-MM-DD",""};
//            int y = 100;
//            int x = 70;
//            for (String data:fitur){
//                JTextField tombo = new JTextField(data);
//                tombo.setBounds(x, y,150,25);
//                tombo.setBackground(new Color(0xDED373));
//                y+=50;
//                add(tombo);
//                if (data.equals(" ")){
//                    x = 360;
//                    y = 100;
//                }
//            }

            String [] name = {"Nama : ","Telp : ","NIK : ","Negara : ","Kode Kamar : ","Check-in : ","Check-out : ","Jenis Pembayaran : "};
            int y1 = 80;
            int x1 = 70;
            for (String date:name){
                JLabel text = new JLabel(date);
                text.setBounds(x1, y1,150,25);
                text.setBackground(new Color(0xDED373));
                text.setForeground(new Color(0xF8F2F2));
                y1+=50;
                add(text);
                if (date.equals("Negara : ")){
                    x1 = 360;
                    y1 = 80;
                }
            }

            cekin = new JButton("Check-in");
            cekin.setBounds(440,317,120,27);

            kembali = new JButton("Back");
            kembali.setBounds(28,317,120,27);

            add(Nama);
            add(Negara);
            add(NIK);
            add(Checkout);
            add(Checkin);
            add(Telp);
            add(KodeKamar);
            add(JenisPembayaran);

            add(cekin);
            add(kembali);
            add(menu);
            add(judul);
            add(back);
        }

    public void action(){

        kembali.addActionListener((action ->{
            dispose();
            System.out.println("Kembali ke menu1");
            new MENU1();
        }));
        cekin.addActionListener(e -> {
            String nm =Nama.getText();
            String tl = Telp.getText();
            String nik = NIK.getText();
            String ng = Negara.getText();
            String cekin = Checkin.getText();
            String cekot = Checkout.getText();
            String jp = JenisPembayaran.getText();
            int kode = Integer.parseInt(KodeKamar.getText());

            pesan.checkinPemesanan(nm,tl,nik,ng,kode,cekin,cekot,jp);
            dispose();
            System.out.println("Check-in");
            new MENU1();
        });
    }


        public static void main(String[] args) {
            CEKIN gui = new CEKIN();
        }
    }

