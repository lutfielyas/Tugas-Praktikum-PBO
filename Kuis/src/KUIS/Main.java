package KUIS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        double nilaitulis, nilaicoding, nilaiwawancara;
        int pilihan, pilih;
        String nik, nama;
        System.out.println("FORM PENDAFTARAN PT.UDIN");
        System.out.println("1. Android Development\n2. Web Development");
        System.out.print("Pilih Jenis Form : ");
        pilihan = input.nextInt();
        if(pilihan == 1){
            System.out.println("FORM PENDAFTARAN\n");
            System.out.print("Input NIK : ");
            nik = input2.nextLine();
            System.out.print("Input Nama : ");
            nama = input2.nextLine();
            System.out.print("Input Nilai Tulis : ");
            nilaitulis = input.nextDouble();
            System.out.print("Input Nilai Coding : ");
            nilaicoding = input.nextDouble();
            System.out.print("Input Nilai Wawancara : ");
            nilaiwawancara = input.nextDouble();
            Android android = new Android(nilaitulis,  nilaicoding,  nilaiwawancara, nama, nik);
            do{
                System.out.println("Menu");
                System.out.println("1. Edit\n2. Tampil\n3. Exit");
                System.out.print("Pilih : ");
                pilih = input.nextInt();
                if(pilih == 1){
                    System.out.print("Input Nilai Tulis : ");
                    nilaitulis = input.nextDouble();
                    android.setNilaitulis(nilaitulis);
                    System.out.print("Input Nilai Coding : ");
                    nilaicoding = input.nextDouble();
                    android.setNilaicoding(nilaicoding);
                    System.out.print("Input Nilai Wawancara : ");
                    nilaiwawancara = input.nextDouble();
                    android.setNilaiwawancara(nilaiwawancara);
                }
                else if(pilih == 2){
                    System.out.println("Hasil : " + android.hasil());
                    android.keterangan();
                }
            }while(pilih > 0 && pilih <3);
        }
        else if(pilihan == 2){
            System.out.println("FORM PENDAFTARAN\n");
            System.out.print("Input NIK : ");
            nik = input2.nextLine();
            System.out.print("Input Nama : ");
            nama = input2.nextLine();
            System.out.print("Input Nilai Tulis : ");
            nilaitulis = input.nextDouble();
            System.out.print("Input Nilai Coding : ");
            nilaicoding = input.nextDouble();
            System.out.print("Input Nilai Wawancara : ");
            nilaiwawancara = input.nextDouble();
            Web Web = new Web(nilaitulis, nilaicoding, nilaiwawancara, nama, nik);
            do{
                System.out.println("Menu");
                System.out.println("1. Edit\n2. Tampil\n3. Exit");
                System.out.print("Pilih : ");
                pilih = input.nextInt();
                if(pilih == 1){
                    System.out.print("Input Nilai Tulis : ");
                    nilaitulis = input.nextDouble();
                    Web.setNilaitulis(nilaitulis);
                    System.out.print("Input Nilai Coding : ");
                    nilaicoding = input.nextDouble();
                    Web.setNilaicoding(nilaicoding);
                    System.out.print("Input Nilai Wawancara : ");
                    nilaiwawancara = input.nextDouble();
                    Web.setNilaiwawancara(nilaiwawancara);
                }
                else if(pilih == 2){
                    System.out.println("Hasil : " + Web.hasil());
                    Web.keterangan();
                }
            }while(pilih > 0 && pilih <3);
        }
    }
}

