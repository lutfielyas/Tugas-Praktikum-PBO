package PesanMakanan;

import javax.swing.*;
import java.awt.event.*;

public class ControllerPesanan extends WindowAdapter{
    ModelPesanan model;
    ViewPesanan view;

	JFrame currentFrame = new JFrame();

	public ControllerPesanan(ModelPesanan model, ViewPesanan view) {
		this.model = model;
		this.view = view;

		lihatData();
		lihatHistori();

		view.bOpenAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getContentPane().removeAll();
				view.refresh();
				showRequest(view.viewTambahMenu());

			}
		});
		view.bOpenOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getContentPane().removeAll();
				view.refresh();
				lihatDataOrder();
				showRequest(view.newOrder());
			}
		});
		view.btnAddMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = view.getName();
				int price = Integer.parseInt(view.getPrice());
				String categories = view.getCat();
                                    model.tambahMakanan(name, price, categories);
				lihatData();
				lihatHistori();
			}
		});
		view.btnClearAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextField();
			}
		});
		view.tabelPsnMakan.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mousePressed(e);
				int baris = view.tabelPsnMakan.getSelectedRow();
				int dataTerpilih = Integer.parseInt(view.tabelPsnMakan.getValueAt(baris, 0).toString());

				System.out.println(dataTerpilih);
				model.addToKeranjang(dataTerpilih);
				lihatDataKeranjang();
			}
		});
		view.tabelPsnMinum.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mousePressed(e);
				int baris = view.tabelPsnMinum.getSelectedRow();
				int dataTerpilih = Integer.parseInt(view.tabelPsnMinum.getValueAt(baris, 0).toString());

				System.out.println(dataTerpilih);
				model.addToKeranjang(dataTerpilih);
				lihatDataKeranjang();
			}
		});
		view.btnSelesaiOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namaPemesan = view.getName();
				JOptionPane.showMessageDialog(null, "Pesanan Telah Diproses");
				clearTextField();
				model.addToPesanan(namaPemesan);
				model.potongKeranjang();
				lihatDataKeranjang();
				view.getContentPane().removeAll();
				view.refresh();
				lihatHistori();
				showRequest(view.viewMenu());
			}
		});
		view.btnClearOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin? Semua Order Di Keranjang Akan Dihapus",
						"Pilih Opsi : ", JOptionPane.YES_NO_OPTION);
				if (input == 0) {
					model.potongKeranjang();
					lihatDataKeranjang();
				} else {
					JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
				}

			}
		});
		view.tabelUtamaMakanan.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mousePressed(e);
				int baris = view.tabelUtamaMakanan.getSelectedRow();
				int dataTerpilih = Integer.parseInt(view.tabelUtamaMakanan.getValueAt(baris, 0).toString());
				view.getContentPane().removeAll();
				view.refresh();
				clearTextField();
				setInsideEditView(dataTerpilih);
				showRequest(view.EditDeleteView());
			}
		});
		view.tabelUtamaMinuman.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mousePressed(e);
				int baris = view.tabelUtamaMinuman.getSelectedRow();
				int dataTerpilih = Integer.parseInt(view.tabelUtamaMinuman.getValueAt(baris, 0).toString());
				view.getContentPane().removeAll();
				view.refresh();
				clearTextField();
				setInsideEditView(dataTerpilih);
				showRequest(view.EditDeleteView());
			}
		});
		view.tabelRiwayatPesanan.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mousePressed(e);
				int baris = view.tabelRiwayatPesanan.getSelectedRow();
				int dataTerpilih = Integer.parseInt(view.tabelRiwayatPesanan.getValueAt(baris, 0).toString());
				lihatDetailHistori(dataTerpilih);
			}
		});
		view.btnDeleteMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = view.getId();
				int input = JOptionPane.showConfirmDialog(null, "Yakin Hapus Menu?", "Pilih Opsi : ",
						JOptionPane.YES_NO_OPTION);

				view.getContentPane().removeAll();

				if (input == 0) {
					model.menuHapusData(id);
					lihatData();
				} else {
					JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
				}
				view.refresh();
				clearTextField();
				showRequest(view.viewMenu());
			}
		});
		view.btnChangeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = view.getId();
				String name = view.getName();
				int price = Integer.parseInt(view.getPrice());
				String cat = view.getCat();
				int input = JOptionPane.showConfirmDialog(null, "Yakin Mengubah Menu?", "Pilih Opsi : ",
						JOptionPane.YES_NO_OPTION);

				view.getContentPane().removeAll();

				if (input == 0) {
					model.menuUpdate(id, name, price, cat);
					lihatData();
				} else {
					JOptionPane.showMessageDialog(null, "Tidak Jadi Dirubah");
				}
				view.refresh();
				clearTextField();
				showRequest(view.viewMenu());
			}
		});
		view.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getContentPane().removeAll();
				view.refresh();
				clearTextField();
				model.potongKeranjang();
				lihatDataKeranjang();
				// lihatData();
				showRequest(view.viewMenu());
			}
		});
	}

	public void lihatData() {
		try {
			String dataDrink[][] = new String[model.getBykData("Drink")][3];
			String dataEat[][] = new String[model.getBykData("Eat")][3];

			dataDrink = model.lihatdataUtama("Drink");
			dataEat = model.lihatdataUtama("Eat");
			view.tabelUtamaMinuman.setModel((new JTable(dataDrink, view.kolom)).getModel());
			view.tabelUtamaMakanan.setModel((new JTable(dataEat, view.kolom)).getModel());
		} catch (IllegalArgumentException i) {
			System.err.println(i);
		}
	}

	public void lihatHistori() {
		try {
			String data[][] = new String[model.getBykDataPesanan()][4];
			data = model.lihatHistoriPesanan();
			view.tabelRiwayatPesanan.setModel((new JTable(data, view.kolomH)).getModel());
		} catch (IllegalArgumentException i) {
			System.err.println(i);
		}
	}

	public void lihatDetailHistori(int id) {
		try {
			String data[][] = new String[model.getBykDataDetail(id)][3];
			data = model.lihatDetailPesanan(id);
			view.ldetailhistory.setText("Order Detail (Order ID : " + id + " )");
			view.tabelDetailRiwayat.setModel((new JTable(data, view.kolomDH)).getModel());
		} catch (IllegalArgumentException i) {
			System.err.println(i);
		}
	}

	public void lihatDataOrder() {
		try {
			String dataDrink[][] = new String[model.getBykData("Drink")][3];
			String dataEat[][] = new String[model.getBykData("Eat")][3];

			dataDrink = model.lihatdataUtama("Drink");
			dataEat = model.lihatdataUtama("Eat");
			view.tabelPsnMinum.setModel((new JTable(dataDrink, view.kolom)).getModel());
			view.tabelPsnMakan.setModel((new JTable(dataEat, view.kolom)).getModel());
		} catch (IllegalArgumentException i) {
			System.err.println(i);
		}
	}

	public void lihatDataKeranjang() {
		String databasket[][] = new String[model.getBykDataKeranjang() + 1][3];
		databasket = model.lihatKeranjang();
		view.tabelkeranjang.setModel((new JTable(databasket, view.kolomB)).getModel());
	}

	public void setInsideEditView(int dataTerpilih) {
		String data[] = new String[4];
		data = model.getEditValue(dataTerpilih);
		view.tfId.setText(data[0]);
		view.tfName.setText(data[1]);
		view.tfPrice.setText(data[2]);
		view.cmbCategories.setSelectedItem(data[3]);
	}

	public void clearTextField() {
		view.tfName.setText("");
		view.tfPrice.setText("");
		view.cmbCategories.setSelectedItem("Eat");
	}

	public void showRequest(JFrame frame) {
		try {
			frame.setVisible(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
