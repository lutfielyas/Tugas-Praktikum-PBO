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
import javax.swing.*;
public class ModelPesanan {
    koneksi connector = new koneksi();
    public void tambahMakanan(String foodName, int price, String categories) {
		try {
			String query = "INSERT INTO food (FoodName, Price, Categories) VALUE('" + foodName + "','" + price + "','"
					+ categories + "') ";
			connector.statement = connector.koneksi.createStatement();
			connector.statement.executeUpdate(query);
			System.out.println("Berhasil Ditambahkan");
			JOptionPane.showMessageDialog(null, "Berhasil");
		} catch (Exception sql) {
			System.out.println(sql.getMessage());
			JOptionPane.showMessageDialog(null, sql.getMessage());
		}
	}

	public String[][] lihatdataUtama(String cat) {
		String data[][] = new String[getBykData(cat)][3];
		try {
			String sql = "select * from food where Categories='" + cat + "'";
			ResultSet resultSet = connector.statement.executeQuery(sql);
			int p = 0;
			while (resultSet.next()) {
				data[p][0] = resultSet.getString("FoodId");
				data[p][1] = resultSet.getString("FoodName");
				data[p][2] = resultSet.getString("Price");
				p++;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
		}
		return data;
	}

	public String[][] lihatHistoriPesanan() {
		String data[][] = new String[getBykDataPesanan()][4];
		try {
			String sql = "SELECT * FROM `order`";
			ResultSet resultSet = connector.statement.executeQuery(sql);
			int p = 0;
			while (resultSet.next()) {
				data[p][0] = Integer.toString(resultSet.getInt("OrderId"));
				data[p][1] = resultSet.getString("CustomerName");
				data[p][2] = Integer.toString(resultSet.getInt("OrderAmount"));
				data[p][3] = Integer.toString(resultSet.getInt("Total"));
				p++;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
		}
		return data;
	}

	public String[][] lihatDetailPesanan(int id) {
		String data[][] = new String[getBykDataDetail(id)][3];
		try {
			String sql = "select * from orderdetail JOIN food ON food.FoodId=orderdetail.FoodId WHERE OrderId='" + id + "'";
			ResultSet resultSet = connector.statement.executeQuery(sql);
			int p = 0;
			while (resultSet.next()) {
				data[p][0] = resultSet.getString("FoodName");
				int amount = resultSet.getInt("AmountOrder");
				int harga = resultSet.getInt("Price") * amount;
				data[p][1] = Integer.toString(amount);
				data[p][2] = Integer.toString(harga);
				p++;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
		}
		return data;
	}

	public String[][] lihatKeranjang() {
		String data[][] = new String[getBykDataKeranjang() + 1][3];
		try {
			int jml = 0;
			int bayar = 0;
			connector.statement = connector.koneksi.createStatement();
			String query = "SELECT * FROM orderbasket JOIN food ON food.FoodId=orderbasket.FName ";
			ResultSet setResult = connector.statement.executeQuery(query);
			while (setResult.next()) {
				data[jml][0] = setResult.getString("FoodName");
				int exs = setResult.getInt("jml");
				data[jml][1] = Integer.toString(exs);
				int dex = setResult.getInt("Price");
				data[jml][2] = Integer.toString(dex);
				bayar = bayar + (dex * exs);
				jml++;
			}
			data[jml][2] = Integer.toString(bayar);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
		}
		return data;
	}

	public void addToKeranjang(int id) {

		int jmlData = 0;
		int dataJml = 0;
		try {
			connector.statement = connector.koneksi.createStatement();
			String query = "SELECT * FROM orderbasket WHERE FName='" + id + "'";
			ResultSet setResult = connector.statement.executeQuery(query);
			while (setResult.next()) {
				dataJml = setResult.getInt("Jml");
				jmlData++;
			}
			if (jmlData > 0) {
				dataJml++;
				String sql = "UPDATE orderbasket SET jml='" + dataJml + "' WHERE FName='" + id + "'";
				connector.statement = connector.koneksi.createStatement();
				connector.statement.executeUpdate(sql);
			} else {
				String sql = "INSERT INTO orderbasket VALUE('" + id + "','1')";
				connector.statement = connector.koneksi.createStatement();
				connector.statement.executeUpdate(sql);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("SQL Errorr");

		}
	}

	public void potongKeranjang() {
		try {
			String sql = "TRUNCATE orderbasket ";
			connector.statement = connector.koneksi.createStatement();
			connector.statement.executeUpdate(sql);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("SQL Errorr");

		}
	}

	public void addToPesanan(String namaPemesan) {
		try {
			int jml = 0;
			int bayar = 0;
			int amount = 0;
			int data[][] = new int[getBykDataKeranjang() + 1][3];
                        
			connector.statement = connector.koneksi.createStatement();
			
                        String query = "SELECT * FROM orderbasket JOIN food ON food.FoodId=orderbasket.FName ";

			ResultSet setResult = connector.statement.executeQuery(query);
			while (setResult.next()) {
				data[jml][0] = setResult.getInt("FName");
				data[jml][1] = setResult.getInt("Price");
				data[jml][2] = setResult.getInt("jml");
				amount = amount + data[jml][2];
				bayar = bayar + (data[jml][1] * data[jml][2]);
				jml++;
			}
			
                        String sql = "INSERT INTO `order` (`CustomerName`, `OrderAmount`, `Total`) VALUE ('" + namaPemesan + "','"
					+ amount + "','" + bayar + "')";
			connector.statement.executeUpdate(sql);
			String query2 = "SELECT * FROM `order`";
			ResultSet setResult2 = connector.statement.executeQuery(query2);
			int idOrder = 0;
			while (setResult2.next()) {
				idOrder = setResult2.getInt("OrderId");
			}
			for (int i = 0; i < jml; i++) {
				String sql2 = "INSERT INTO `orderdetail` VALUE('" + data[i][0] + "','" + data[i][2] + "','" + idOrder + "')";
				connector.statement.executeUpdate(sql2);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("SQL Errorr");

		}
	}

	public String[] getEditValue(int id) {
		String data[] = new String[4];
		try {
			connector.statement = connector.koneksi.createStatement();
			String query = "SELECT * FROM food WHERE FoodId='" + id + "'";
			ResultSet setResult = connector.statement.executeQuery(query);
			while (setResult.next()) {
				data[0] = Integer.toString(id);
				data[1] = setResult.getString("FoodName");
				data[2] = Integer.toString(setResult.getInt("Price"));
				data[3] = setResult.getString("Categories");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("SQL Errorr");
		}
		return data;
	}

	public void menuHapusData(int id) {
		try {
			String query = "DELETE FROM `food` WHERE `FoodId` = '" + id + "' ";
			connector.statement = connector.koneksi.createStatement();
			connector.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void menuUpdate(int id, String name, int price, String cat) {
		try {
			String query = "UPDATE `food` SET `FoodName`='" + name + "', `Price`='" + price + "', `Categories`='" + cat
					+ "' WHERE `FoodId`='" + id + "' ";
			connector.statement = connector.koneksi.createStatement();
			connector.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Berhasil Dirubah");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int getBykData(String cat) {
		int jmlData = 0;
		try {
			connector.statement = connector.koneksi.createStatement();
			String query = "SELECT * FROM food where Categories='" + cat + "'";
			ResultSet setResult = connector.statement.executeQuery(query);

			while (setResult.next()) {
				jmlData++;
			}
			return jmlData;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("SQL Error");
			return 0;
		}
	}

	public int getBykDataPesanan() {
		int jmlData = 0;
		try {
			connector.statement = connector.koneksi.createStatement();
			String query = "SELECT * FROM `order`";
			ResultSet setResult = connector.statement.executeQuery(query);
			while (setResult.next()) {
				jmlData++;
			}
			return jmlData;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("SQL Error");
			JOptionPane.showMessageDialog(null, "gagal menhitung jumlah data");
			return 0;
		}
	}

	public int getBykDataDetail(int id) {
		int jmlData = 0;
		try {
			connector.statement = connector.koneksi.createStatement();
			String query = "SELECT * FROM orderdetail WHERE OrderId='" + id + "'";
			ResultSet setResult = connector.statement.executeQuery(query);
			while (setResult.next()) {
				jmlData++;
			}
			return jmlData;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("SQL Error");
			return 0;
		}
	}

	public int getBykDataKeranjang() {
		int jmlData = 0;
		try {
			connector.statement = connector.koneksi.createStatement();
			String query = "SELECT * FROM orderbasket";
			ResultSet setResult = connector.statement.executeQuery(query);

			while (setResult.next()) {
				jmlData++;
			}
			return jmlData;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("SQL Error");
			return 0;
		}
	}
}

