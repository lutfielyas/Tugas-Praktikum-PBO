package Bangun;

import Hitung.MenghitungRuang;

public class Balok extends PersegiPanjang implements MenghitungRuang
    {
        double tinggi, volume, luasPermukaan;

        public Balok(double panjang, double lebar, double tinggi)
        {
            super(panjang, lebar);
            this.tinggi = tinggi;
        }

        public Balok(double panjang, double lebar)
        {
            super(panjang, lebar);
        }

        @Override
        public double hitungVol()
        {
            volume = this.panjang*this.lebar*this.tinggi;
            return volume;
        }

        @Override
        public double hitungLP()
        {
            luasPermukaan = 2*(this.panjang*this.lebar+this.panjang*this.tinggi+this.lebar*this.tinggi);
            return luasPermukaan;
        }
    }
