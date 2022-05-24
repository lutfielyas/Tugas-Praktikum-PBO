package Responsi;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerMovie {
    ModelMovie modelMovie;
    MovieView vM;

    public String dataterpilih;

    public ControllerMovie(ModelMovie mM, MovieView vM) {
        this.modelMovie = mM;
        this.vM = vM;


        if (mM.getBanyakData() != 0) {
            String dataMovie[][] = mM.MovieList();
            vM.tabel.setModel((new JTable(dataMovie, vM.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }



        vM.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = vM.getJudul();
                String alur = vM.getAlur();
                String penokohan = vM.getPenokohan();
                String akting = vM.getAkting();
                mM.insertmovie(judul, alur, penokohan, akting);

                String dataMovie[][] = mM.MovieList();
                vM.tabel.setModel((new JTable(dataMovie, vM.namaKolom)).getModel());
            }
        });

        vM.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = vM.getJudul();
                String alur = vM.getAlur();
                String penokohan = vM.getPenokohan();
                String akting = vM.getAkting();

                String dataMovie[][] = mM.MovieList();
                vM.tabel.setModel((new JTable(dataMovie, vM.namaKolom)).getModel());
            }
        });


        vM.tabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = vM.tabel.getSelectedRow();

                dataterpilih = vM.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);

            }

        });

        vM.tabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = vM.tabel.getSelectedRow();

                dataterpilih = vM.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
            }
        });


        vM.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Film " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    mM.deleteMovie(dataterpilih);
                    String dataMovie[][] = mM.MovieList();
                    vM.tabel.setModel((new JTable(dataMovie, vM.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
    }
}