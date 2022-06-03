package PesanMakanan;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.sql.*;
public class koneksi {
    String DBurl = "jdbc:mysql://localhost/pesanan1";
    String DBusername = "root";
    String DBpassword = "";
    public Connection koneksi;
    public Statement statement;
    public koneksi() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Terkoneksi");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
