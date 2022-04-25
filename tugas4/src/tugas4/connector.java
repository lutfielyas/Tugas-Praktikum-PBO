package tugas4;
import java.sql.*;
import javax.swing.JOptionPane;

public class connector {

    String DBurl = "jdbc:mysql://localhost/tugasjdbc";
    String DBusername = "root";
    String DBpassword = "";

    String database [] = new String[2];
    Connection connection;
    Statement statement;

    public connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
        }catch(Exception ex){
            System.out.println("Connection Failed " + ex.getMessage() );
        }
    }

    void registerdata (String username, String password){
        try {
            if (!unamecheck(username)) {
                String query = "INSERT INTO `users` (`username`, `password`)"
                        + "VALUES('" + username + "','" + password + "')";
                statement = connection.createStatement();
                statement.executeUpdate(query);
                System.out.println("Input Berhasil !");
                JOptionPane.showMessageDialog(null, "Register Berhasil !");
            }
            else{
                JOptionPane.showMessageDialog(null, "Username Sudah Ada");
            }
        }catch (Exception ex) {
            System.out.println("Input Gagal");
        }
    }

    boolean unamecheck (String username){
        try {
            String query = "SELECT * FROM `users` WHERE username = '"+username+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                database[0] = resultSet.getString("username");
            }
            statement.close();
            database[0].toString();
            return true;
        }catch (Exception e){
            System.out.println("Unavailable");
            return false;
        }
    }


    boolean Logincheck (String username, String password){
        try {
            String query = "SELECT * FROM `users` WHERE username='"+username+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                database[0] = resultSet.getString("username");
                database[1] = resultSet.getString("password");
            }
            statement.close();
            database[1].toString();
            database[0].toString();
            if (database[1].toString().equals(password)) {
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Unavailable");
            return false;
        }
    }
}
