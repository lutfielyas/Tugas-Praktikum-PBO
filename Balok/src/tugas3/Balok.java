

package tugas3;

    // Abstract Window Toolkit
    import java.awt.Component;
    import java.awt.LayoutManager;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    // GUI Widget Toolkit
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JTextField;

    public class Balok extends JFrame implements ActionListener {

        // GUI
        JLabel labelJudul = new JLabel("Kalkulator Balok");
        JLabel labelPanjang = new JLabel("Panjang");
        JLabel labelLebar = new JLabel("Lebar");
        JLabel labelTinggi = new JLabel("Tinggi");
        JLabel labelHasil = new JLabel("Hasil Perhitungan");

        // Hasil
        JLabel labelLuas = new JLabel();
        JLabel labelKeliling= new JLabel();
        JLabel labelVolume = new JLabel();
        JLabel labelLuasPermukaan = new JLabel();

        final JTextField fieldPanjang = new JTextField(20);
        final JTextField fieldLebar = new JTextField(20);
        final JTextField fieldTinggi = new JTextField(20);

        JButton buttonHitung = new JButton("Hitung");
        JButton buttonReset = new JButton("Reset");

        public Balok() {
            this.setSize(450, 500);
            this.setTitle("Kalkulator Balok");
            this.setLayout((LayoutManager)null);

            this.buttonHitung.addActionListener(this);
            this.buttonReset.addActionListener(this);

            this.add(this.labelJudul);
            this.add(this.labelPanjang);
            this.add(this.fieldPanjang);
            this.add(this.labelLebar);
            this.add(this.fieldLebar);
            this.add(this.labelTinggi);
            this.add(this.fieldTinggi);
            this.add(this.labelHasil);
            this.add(this.labelLuas);
            this.add(this.labelKeliling);
            this.add(this.labelVolume);
            this.add(this.labelLuasPermukaan);
            this.add(this.buttonHitung);
            this.add(this.buttonReset);

            this.labelJudul.setBounds(40, 10, 200, 40);

            this.labelPanjang.setBounds(40, 70, 150, 25);
            this.fieldPanjang.setBounds(200, 70, 150, 25);

            this.labelLebar.setBounds(40, 120, 150, 25);
            this.fieldLebar.setBounds(200, 120, 150, 25);

            this.labelTinggi.setBounds(40, 170, 150, 25);
            this.fieldTinggi.setBounds(200, 170, 150, 25);

            this.labelHasil.setBounds(40, 220, 150, 25);
            this.labelLuas.setBounds(40, 250, 200, 25);
            this.labelKeliling.setBounds(40, 280, 200, 25);
            this.labelVolume.setBounds(40, 310, 200, 25);
            this.labelLuasPermukaan.setBounds(40, 340, 200, 25);

            this.buttonHitung.setBounds(100, 390, 100, 30);
            this.buttonReset.setBounds(280, 390, 100, 30);

            this.setVisible(true);
            this.setDefaultCloseOperation(3);
            this.setLocationRelativeTo((Component)null);
        }

        public void actionPerformed(ActionEvent e) {
            try {
                int p = Integer.parseInt(this.fieldPanjang.getText());
                int l = Integer.parseInt(this.fieldLebar.getText());
                int t = Integer.parseInt(this.fieldTinggi.getText());
                if (e.getSource() == this.buttonHitung) {
                    int luas = p * l;
                    this.labelLuas.setText
                            ("Luas Persegi : " + luas);
                    int keliling = 2 * p + 2 * l;
                    this.labelKeliling.setText
                            ("Keliling Persegi : " + keliling);
                    int volume = p * l * t;
                    this.labelVolume.setText
                            ("Volume Balok : " + volume);
                    int luaspermukaan = 2 * p * l + 2 * p * t + 2 * t * l;
                    this.labelLuasPermukaan.setText
                            ("Luas Permukaan Balok : " + luaspermukaan);
                } else if (e.getSource() == this.buttonReset)
                    {
                    this.clearFields();
                    }
            } catch (NumberFormatException var9)
                {
                JOptionPane.showMessageDialog((Component)null, "Hanya bisa angka, tidak boleh kosong.");
                }

        }

        private void clearFields() {
            this.fieldPanjang.setText("");
            this.fieldLebar.setText("");
            this.fieldTinggi.setText("");

            this.labelLuas.setText("");
            this.labelVolume.setText("");
            this.labelKeliling.setText("");

            this.labelLuasPermukaan.setText("");
        }
    }
