package Responsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

    public class koneksi {
        String DBurl = "jdbc:mysql://localhost/movie_db";
        String DBusername = "root";
        String DBpassword = "";

        String data[] = new String[2];
        Connection koneksi;
        Statement statement;
        static String[] username;
        public koneksi() {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
                System.out.println("Connection Successful");
            }catch(Exception ex){
                System.out.println("Connection Failed " + ex.getMessage());
            }
        }
    }
