package KUIS;

public class Android extends Save implements Pembobotan {

    public Android(double nilaitulis, double nilaicoding, double nilaiwawancara, String nama, String nik) {
        super(nilaitulis, nilaicoding, nilaiwawancara, nama, nik);
    }

    public void setNilaitulis(double nilaitulis) {
        super.nilaitulis = nilaitulis;
    }

    public void setNilaicoding(double nilaicoding) {
        super.nilaicoding = nilaicoding;
    }

    public void setNilaiwawancara(double nilaiwawancara) {
        super.nilaiwawancara = nilaiwawancara;
    }

    @Override
    public double tulis() {
        return super.nilaitulis*0.2;
    }

    @Override
    public double coding() {
        return super.nilaicoding*0.5;
    }

    @Override
    public double wawancara() {
        return super.nilaiwawancara*0.3;
    }

    public double hasil(){
        return wawancara()+tulis()+coding();
    }
    public void keterangan(){
        if(hasil() >= 85)
        {
            System.out.println("KETERANGAN : LOLOS");
            System.out.println("Selamat, " + super.nama + " telah diterima sebagai Developer Web");
        }

        else
        {
            System.out.println("KETERANGAN : GAGAL");
            System.out.println("Mohon maaf, " + super.nama + " telah ditolak sebagai Developer Web");
        }
    }
}
