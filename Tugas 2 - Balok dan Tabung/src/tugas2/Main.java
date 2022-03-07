package tugas2;

import Bangun.Balok;
import Bangun.Tabung;

import java.util.Scanner;

public class Main
    {

        public static void main(String[] args)
        {
            int pilMenu;
            double panjang, lebar, tinggi, jari;

            Scanner input = new Scanner(System.in);

            do
            {
                System.out.println("===========");
                System.out.println("MENU");
                System.out.println("===========");
                System.out.println("1. Hitung Balok");
                System.out.println("2. Hitung Tabung");
                System.out.println("3. Exit Program");
                System.out.println("Pilihan :");
                pilMenu = input.nextInt();

                switch (pilMenu)
                {

                    case 1:
                        System.out.println("Input Panjang : ");
                        panjang = input.nextDouble();
                        System.out.println("Input Lebar");
                        lebar = input.nextDouble();
                        System.out.println("Input Tinggi : ");
                        tinggi = input.nextDouble();

                        Balok balok = new Balok(panjang, lebar, tinggi);

                        System.out.println("Luas Persegi Panjang : " + balok.hitungL());
                        System.out.println("Keliling Persegi Panjang : " + balok.hitungK());
                        System.out.println("Volume Balok : " + balok.hitungVol());
                        System.out.println("Luas Permukaan Balok : " + balok.hitungLP());

                        System.out.println("Ulangi ? (Yes ketik 1 , No ketik 2) : ");
                        pilMenu = input.nextInt();
                        if (pilMenu == 2){
                            System.out.println("Exit...");
                            System.exit(0);
                        }
                        break;

                    case 2:
                        System.out.println("Input Jari-Jari : ");
                        jari = input.nextDouble();
                        System.out.println("Input Tinggi : ");
                        tinggi = input.nextDouble();

                        Tabung tabung = new Tabung(jari, tinggi);

                        System.out.println("Luas Lingkaran : " + tabung.hitungL());
                        System.out.println("Keliling Lingkaran : " + tabung.hitungK());
                        System.out.println("Volume Tabung : " + tabung.hitungVol());
                        System.out.println("Luas Permukaan Tabung : " + tabung.hitungLP());

                        System.out.println("Ulangi ? (Yes ketik 1 , No ketik 2) : ");
                        pilMenu = input.nextInt();
                        if (pilMenu == 2){
                            System.out.println("Exit...");
                            System.exit(0);
                        }
                        break;

                    case 3:
                        System.out.println("Exit...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("\n");
                        System.out.println("Menu tidak tersedia");
                }

            }while (pilMenu != 0);
        }
    }

