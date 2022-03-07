package Bangun;

import Hitung.MenghitungBidang;

public class PersegiPanjang implements MenghitungBidang
{
        double panjang, lebar, luas, keliling;

        public PersegiPanjang(double panjang, double lebar)
        {
            this.panjang = panjang;
            this.lebar = lebar;
        }

        @Override
        public double hitungL()
        {
            luas = this.panjang*this.lebar;
            return luas;
        }

        @Override
        public double hitungK()
        {
            keliling = 2*(this.panjang+this.lebar);
            return keliling;
        }
}
