package KUIS;

public class Web implements Pembobotan{
    double nilaitulis, nilaicoding, nilaiwawancara;
    String nama, nik;

    public Web(double nilaitulis, double nilaicoding, double nilaiwawancara, String nama, String nik) {
        this.nilaitulis = nilaitulis;
        this.nilaicoding = nilaicoding;
        this.nilaiwawancara = nilaiwawancara;
        this.nama = nama;
        this.nik = nik;
    }


    public void setNilaitulis(double nilaitulis) {
        this.nilaitulis = nilaitulis;
    }

    public void setNilaicoding(double nilaicoding) {
        this.nilaicoding = nilaicoding;
    }

    public void setNilaiwawancara(double nilaiwawancara) {
        this.nilaiwawancara = nilaiwawancara;
    }


    @Override
    public double tulis() {
        return nilaitulis*0.4;
    }

    @Override
    public double coding() {
        return nilaicoding*0.35;
    }

    @Override
    public double wawancara() {
        return nilaiwawancara*0.25;
    }

    public double hasil(){
        return wawancara()+tulis()+coding();
    }
    public void keterangan(){
        if(hasil() >= 85){
            System.out.println("KETERANGAN : LOLOS");
            System.out.println("Selamat kepada " + nama + " telah diterima sebagai Web");
        }else{
            System.out.println("KETERANGAN : GAGAL");
            System.out.println("Mohon maaf kepada " + nama + " telah ditolak sebagai Web");
        }
    }
}


