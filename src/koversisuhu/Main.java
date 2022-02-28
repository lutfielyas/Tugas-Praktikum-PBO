package koversisuhu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        float SuhuAwal;
        int pilMenu;

        System.out.println("PROGRAM KONVERSI SUHU");
        System.out.println("=====================");
        System.out.println("Input suhu (Celcius) : ");
        Scanner input = new Scanner(System.in);
        SuhuAwal = input.nextFloat();

        do
        {
            Konversi konversi = new Konversi(SuhuAwal);
            System.out.println("\n");
            System.out.println("Pilihan Menu");
            System.out.println("=================");
            System.out.println("1. Lihat Data Konversi");
            System.out.println("2. Edit Data Konversi");
            System.out.println("3. Exit");
            System.out.println("Pilih : ");
            pilMenu = input.nextInt();

            switch(pilMenu) {
                case 1:
                    System.out.println();
                    System.out.println("\n");
                    System.out.println("Suhu dalam Celcius : " + konversi.celcius + "° C");
                    System.out.println("Suhu dalam Fahrenheit : " + konversi.ubahFahrenheit() + "° F");
                    System.out.println("Suhu dalam Reamur : " + konversi.ubahReamur() + "° R");
                    System.out.println("Suhu dalam Kelvin : " + konversi.ubahKelvin() + " K");
                    System.out.println("Kondisi Air " + konversi.kondisiAir());
                    break;

                case 2:
                    System.out.println("\n");
                    System.out.println("Input suhu (Celcius) : ");
                    SuhuAwal = input.nextFloat();
                    konversi.celcius = SuhuAwal;
                    break;

                case 3:
                    System.out.println("\n");
                    System.out.println("Exit Program");
                    break;

                default:
                    System.out.println("\n");
                    System.out.println("Menu tidak ada");
            }

        }while(pilMenu != 3);

            System.exit(0);
    }
}
