/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PesanMakanan;

import java.awt.*;
import javax.swing.table.*;
import javax.swing.*;

public class ViewPesanan extends JFrame{
	private static final long serialVersionUID = 1L;

	ControllerPesanan control;
	JFrame currentFrame;
	JButton bOpenAdd = new JButton("Tambah Menu");
	JButton bOpenOrder = new JButton("New Order");
	String[] kolom = { "ID", "Name", "Price" };
	String[] kolomH = { "Order ID", "Customer Name", "Amount", "Total" };
	String[] kolomDH = { "Food ID", "Amount", "Price" };
	String[] kolomB = { "Order List", "Amount", "Price" };
	JTable tabelUtamaMinuman;
	JTable tabelUtamaMakanan;
	JTable tabelPsnMinum;
	JTable tabelPsnMakan;
	JTable tabelkeranjang;
	JTable tabelRiwayatPesanan;
	JTable tabelDetailRiwayat;
	DefaultTableModel tableModel;
	JScrollPane scrollPane;
	Dimension dimensiUtama;
	Dimension dimensiMenu;
	JLabel lmakanan = new JLabel("Makanan");
	JLabel lminuman = new JLabel("Minuman");
	JLabel lhistory = new JLabel("Riwayat Pesanan");
	JLabel ldetailhistory = new JLabel("Detail Pesanan(Pilih Data)");

	public ViewPesanan() {
		dimensiUtama = new Dimension(900, 700);
		dimensiMenu = new Dimension(600, 370); // lebar,tinggi
		tableModel = new DefaultTableModel(kolom, 0);

		tabelUtamaMinuman = new JTable(tableModel);
		JTableHeader tabelHeader = tabelUtamaMinuman.getTableHeader();
		tabelHeader.setBackground(Color.RED);
		tabelHeader.setForeground(Color.BLACK);
		tabelUtamaMinuman.setBackground(Color.WHITE);
		tabelUtamaMinuman.setForeground(Color.BLACK);

		tabelUtamaMakanan = new JTable(tableModel);
		JTableHeader tabelHeader1 = tabelUtamaMakanan.getTableHeader();
		tabelHeader1.setBackground(Color.RED);
		tabelHeader1.setForeground(Color.BLACK);
		tabelUtamaMakanan.setBackground(Color.WHITE);
		tabelUtamaMakanan.setForeground(Color.BLACK);

		tabelPsnMinum = new JTable(tableModel);
		JTableHeader tabelHeader2 = tabelPsnMinum.getTableHeader();
		tabelHeader2.setBackground(Color.RED);
		tabelHeader2.setForeground(Color.WHITE);
		tabelPsnMinum.setBackground(Color.WHITE);
		tabelPsnMinum.setForeground(Color.BLACK);

		tabelPsnMakan = new JTable(tableModel);
		JTableHeader tabelHeader3 = tabelPsnMakan.getTableHeader();
		tabelHeader3.setBackground(Color.RED);
		tabelHeader3.setForeground(Color.BLACK);
		tabelPsnMakan.setBackground(Color.WHITE);
		tabelPsnMakan.setForeground(Color.BLACK);

		tableModel = new DefaultTableModel(kolomB, 0);
		tabelkeranjang = new JTable(tableModel);
		JTableHeader tabelHeader4 = tabelkeranjang.getTableHeader();
		tabelHeader4.setBackground(Color.RED);
		tabelHeader4.setForeground(Color.BLACK);
		tabelkeranjang.setBackground(Color.WHITE);
		tabelkeranjang.setForeground(Color.BLACK);

		tableModel = new DefaultTableModel(kolomH, 0);
		tabelRiwayatPesanan = new JTable(tableModel);
		JTableHeader tabelHeader5 = tabelRiwayatPesanan.getTableHeader();
		tabelHeader5.setBackground(Color.RED);
		tabelHeader5.setForeground(Color.BLACK);
		tabelRiwayatPesanan.setBackground(Color.WHITE);
		tabelRiwayatPesanan.setForeground(Color.BLACK);

		tableModel = new DefaultTableModel(kolomDH, 0);
		tabelDetailRiwayat = new JTable(tableModel);
		JTableHeader tabelHeader6 = tabelDetailRiwayat.getTableHeader();
		tabelHeader6.setBackground(Color.RED);
		tabelHeader6.setForeground(Color.BLACK);
		tabelDetailRiwayat.setBackground(Color.WHITE);
		tabelDetailRiwayat.setForeground(Color.BLACK);

		viewMenu();
	}

	public void refresh() {
		dispose();
	}

	public JFrame viewMenu() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		setPreferredSize(dimensiUtama);
		setTitle("==Menu==");
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		add(bOpenAdd);
		add(bOpenOrder);
		bOpenAdd.setBounds(285, 40, 120, 20); // x,y,lebar,tinggi
		bOpenOrder.setBounds(425, 40, 120, 20);

		bOpenAdd.setBackground(Color.white);
		bOpenOrder.setBackground(Color.white);

		add(lminuman);
		scrollPane = new JScrollPane(tabelUtamaMinuman);
		add(scrollPane);
		lminuman.setBounds(200, 80, 90, 20);
		lminuman.setBackground(Color.white);
		scrollPane.setBounds(20, 110, 380, 210); // x,y,lebar,tinggi
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(lmakanan);
		scrollPane = new JScrollPane(tabelUtamaMakanan);
		add(scrollPane);
		lmakanan.setBounds(200, 330, 90, 20);
		lmakanan.setBackground(Color.white);
		scrollPane.setBounds(20, 360, 380, 210); // x,y,lebar,tinggi
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(lhistory);
		scrollPane = new JScrollPane(tabelRiwayatPesanan);
		add(scrollPane);
		lhistory.setBounds(590, 80, 90, 20);
		lhistory.setBackground(Color.yellow);
		scrollPane.setBounds(430, 110, 380, 210); // x,y,lebar,tinggi
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(ldetailhistory);
		scrollPane = new JScrollPane(tabelDetailRiwayat);
		add(scrollPane);
		ldetailhistory.setBounds(550, 330, 200, 20);
		ldetailhistory.setBackground(Color.WHITE);
		scrollPane.setBounds(430, 360, 380, 210); // x,y,lebar,tinggi
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		pack();
		return currentFrame;
	}

	JLabel lName = new JLabel("Name : ");
	JTextField tfName = new JTextField();
	JLabel lPrice = new JLabel("Price : ");
	JTextField tfPrice = new JTextField();
	JLabel lCategories = new JLabel("Categories : ");
	String categories[] = { "Eat", "Drink" };
	JComboBox<String> cmbCategories = new JComboBox<>(categories);

	JButton btnAddMenu = new JButton("Add Menu");
	JButton btnClearAdd = new JButton("Clear");
	JButton btnBack = new JButton("Back");

	public JFrame viewTambahMenu() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		setPreferredSize(dimensiMenu);
		setTitle("==Tambah Menu==");
		getContentPane().setBackground(Color.WHITE);

		add(lName);
		add(tfName);
		add(lPrice);
		add(tfPrice);
		add(lCategories);
		add(cmbCategories);
		add(btnAddMenu);
		add(btnBack);
		add(btnClearAdd);

		lName.setBounds(40, 40, 200, 20); // x,y,lebar,tinggi
		tfName.setBounds(240, 40, 200, 20);
		lPrice.setBounds(40, 70, 200, 20);
		tfPrice.setBounds(240, 70, 200, 20);
		lCategories.setBounds(40, 100, 200, 20);
		cmbCategories.setBounds(240, 100, 200, 20);

		btnAddMenu.setBounds(180, 140, 100, 20);
		btnBack.setBounds(120, 180, 100, 20);
		btnClearAdd.setBounds(240, 180, 100, 20);

		lName.setBackground(Color.white);
		tfName.setBackground(Color.white);
		lPrice.setBackground(Color.white);
		tfPrice.setBackground(Color.white);
		lCategories.setBackground(Color.white);

		btnAddMenu.setBackground(Color.WHITE);
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnClearAdd.setBackground(Color.red);

		pack();
		return currentFrame;
	}

	JLabel keranjang = new JLabel("Basket");
	JLabel nama = new JLabel("Customer Name : ");
	JLabel lTotal = new JLabel();

	JButton btnSelesaiOrder = new JButton("Order Now");
	JButton btnClearOrder = new JButton("Clear/Reorder");

	public JFrame newOrder() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		setPreferredSize(dimensiUtama);
		setTitle("==Pesan Makan==");
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);

		add(lminuman);
		scrollPane = new JScrollPane(tabelPsnMinum);
		add(scrollPane);
		lminuman.setBounds(200, 20, 90, 20);// (200,80,90,20)
		lminuman.setBackground(Color.white);
		scrollPane.setBounds(20, 50, 380, 240); // x,y,lebar,tinggi (20,110,380,210);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(lmakanan);
		scrollPane = new JScrollPane(tabelPsnMakan);
		add(scrollPane);
		lmakanan.setBounds(200, 300, 90, 20); // (200,340,90,20);
		lmakanan.setBackground(Color.WHITE);
		scrollPane.setBounds(20, 330, 380, 240); // x,y,lebar,tinggi (20,370,380,210);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(keranjang);
		scrollPane = new JScrollPane(tabelkeranjang);
		add(scrollPane);
		keranjang.setBounds(590, 230, 90, 20);
		keranjang.setBackground(Color.white);
		scrollPane.setBounds(430, 260, 380, 310); // x,y,lebar,tinggi
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(nama);
		add(tfName);
		add(btnSelesaiOrder);
		add(btnClearOrder);
		add(btnBack);
		add(lTotal);

		nama.setBounds(500, 50, 250, 20);
		tfName.setBounds(500, 80, 250, 20);
		btnSelesaiOrder.setBounds(575, 130, 100, 20);
		btnSelesaiOrder.setBackground(Color.white);
		btnClearOrder.setBounds(635, 170, 115, 20);
		btnClearOrder.setBackground(Color.lightGray);
		btnBack.setBounds(500, 170, 115, 20);
		btnBack.setBackground(Color.yellow);
		lTotal.setBounds(635, 490, 100, 20);
		pack();
		return currentFrame;
	}

	JLabel lEditTitle = new JLabel("Data ");
	JLabel lId = new JLabel("ID : ");
	JTextField tfId = new JTextField();
	JButton btnDeleteMenu = new JButton("Delete This Menu");
	JButton btnChangeMenu = new JButton("Change Menu Value");

	public JFrame EditDeleteView() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		setPreferredSize(dimensiUtama);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);

		add(lEditTitle);
		add(lId);
		add(tfId);
		add(lName);
		add(tfName);
		add(lPrice);
		add(tfPrice);
		add(lCategories);
		add(cmbCategories);
		add(btnDeleteMenu);
		add(btnChangeMenu);
		add(btnBack);

		lEditTitle.setBounds(90, 20, 100, 60);
		lEditTitle.setFont(new Font("Arial", Font.BOLD, 24));
		lId.setBounds(40, 80, 100, 20); // x,y,lebar,tinggi
		tfId.setBounds(165, 80, 200, 20);
		tfId.setEditable(false);

		lName.setBounds(40, 110, 100, 20);
		tfName.setBounds(165, 110, 200, 20);
		lPrice.setBounds(40, 140, 100, 20);
		tfPrice.setBounds(165, 140, 200, 20);
		lCategories.setBounds(40, 170, 100, 20);
		cmbCategories.setBounds(165, 170, 200, 20);

		btnDeleteMenu.setBounds(430, 80, 150, 20);
		btnChangeMenu.setBounds(430, 125, 150, 20);
		btnBack.setBounds(430, 170, 150, 20);

		lName.setBackground(Color.white);
		tfName.setBackground(Color.white);
		lPrice.setBackground(Color.white);
		tfPrice.setBackground(Color.white);
		lCategories.setBackground(Color.white);

		btnDeleteMenu.setBackground(Color.RED);
		btnChangeMenu.setBackground(Color.YELLOW);
		btnBack.setBackground(Color.white);

		return currentFrame;
	}

	public int getId() {
		return Integer.parseInt(tfId.getText());
	}

	public String getName() {
		return tfName.getText();
	}

	public String getPrice() {
		return tfPrice.getText();
	}

	public String getCat() {
		String selectCat = (String) cmbCategories.getSelectedItem();
		return selectCat;
	}
}