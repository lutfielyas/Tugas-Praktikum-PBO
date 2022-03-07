package Bangun;

import Hitung.MenghitungBidang;

public class Lingkaran implements MenghitungBidang
    {

        double jari, luas, keliling;

        public Lingkaran(double jari)
        {
            this.jari = jari;
        }

        @Override
        public double hitungL()
        {
            luas = PI*Math.pow(this.jari, 2);
            return luas;
        }

        @Override
        public double hitungK()
        {
            keliling = 2*PI*this.jari;
            return keliling;
        }

    }
