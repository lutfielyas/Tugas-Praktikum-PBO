package tugas4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame{
    JLabel judullogin = new JLabel ("LOGIN");
    JLabel lusername = new JLabel("Username : ");
    JTextField fusername = new JTextField (20);
    JLabel lpassw = new JLabel ("Password : ");
    JPasswordField fpassw = new JPasswordField(10);
    JButton blogin = new JButton("Login");
    JLabel lregisteruname = new JLabel ("Username : ");
    JTextField freguname = new JTextField (20);
    JLabel lregpassw = new JLabel ("Password : ");
    JPasswordField fregpassw = new JPasswordField (10);
    JButton bregister = new JButton ("Register");
    public GUI(){
        setVisible(true);
        setTitle("LOGIN");
        setSize(520,200);
        setLayout(null);
        add(judullogin);
        add(lusername);
        add(fusername);
        add(lpassw);
        add(fpassw);
        add(blogin);
        add(lregisteruname);
        add(freguname);
        add(lregpassw);
        add(fregpassw);
        add(bregister);
        judullogin.setBounds(230,10,80,20);
        lusername.setBounds(10, 40, 150,30);
        fusername.setBounds(80,40,150,30);
        lpassw.setBounds(10,80,150,30);
        fpassw.setBounds(80,80,150,30);
        blogin.setBounds(105,120,90,20);
        lregisteruname.setBounds(250,40,100,30);
        freguname.setBounds(330,40,150,30);
        lregpassw.setBounds(250,80,150,30);
        fregpassw.setBounds(330,80,150,30);
        bregister.setBounds(355,120,90,20);

        blogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                connector conn = new connector();
                String user = fusername.getText();
                if (conn.unamecheck(user) && user != "" && conn.Logincheck(user, String.valueOf(fpassw.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login Sukses!");
                }
                else if (user.isEmpty() || String.valueOf(fpassw.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong!");
                }
                else if (!conn.unamecheck(user)) {
                    JOptionPane.showMessageDialog(null, "Username Salah!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Password Salah!");
                }
            }
        });

        bregister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                connector conn = new connector();
                String reguser = freguname.getText();
                String regpass = String.valueOf(fregpassw.getPassword());
                if (!reguser.isEmpty() && !regpass.isEmpty()) {
                    conn.registerdata(reguser,regpass);
                    JOptionPane.showMessageDialog(null, "Register Berhasil!");
                }
                else if (reguser.isEmpty() || regpass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong!");
                }
            }
        });
    }
}
