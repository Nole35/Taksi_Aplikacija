package gui.formeZaPrikaz;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.DispecerProzor;
import gui.formeZaDodavanje.DodajVozilo;
import gui.formeZaIzmjenu.IzmjenaVozila;

import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import vozila.Automobil;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.lazic.Main;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VozilaProzor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;

	public VozilaProzor(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		setTitle("Vozila");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 766, 234);
		contentPane.add(scrollPane);
		String[] kolone = new String[] {"ID", "Model", "Proizvodjac", "Godina proizvodnje", "Broj registracije", "Broj taksi vozila", "Vrsta automobila","Id vozaca"};
		Object[][] sadrzaj = new Object[taksiSluzba.sviNeobrisaniAutomobili().size()][kolone.length];
		for(int i=0; i<taksiSluzba.sviNeobrisaniAutomobili().size(); i++) {
			Automobil auto = taksiSluzba.sviNeobrisaniAutomobili().get(i);
			sadrzaj[i][0] = auto.getId();
			sadrzaj[i][1] = auto.getModel();
			sadrzaj[i][2] = auto.getProizvodjac();
			sadrzaj[i][3] = auto.getGodinaProizvodnje();
			sadrzaj[i][4] = auto.getBrojRegistarskeOznake();
			sadrzaj[i][5] = auto.getBrojTaksiVozila();
			sadrzaj[i][6] = auto.getVrstaAutomobila();
			sadrzaj[i][7] = auto.getIdVozaca();
			
			
		}
		tableModel = new DefaultTableModel(
				sadrzaj,kolone );
		
		
		table = new JTable(tableModel);
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);
	
		
		tableModel = new DefaultTableModel(
				sadrzaj,kolone );
		
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		
	
			
		
		
		
		JButton btnNewButton = new JButton("Dodaj vozilo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajVozilo dov = new DodajVozilo(taksiSluzba, taksiSluzbai);
				dov.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton.setBounds(10, 277, 111, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Izbrisi vozilo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite red", "Greska", JOptionPane.WARNING_MESSAGE);}
				else {
					String brojRegistarskeOznake = table.getValueAt(row, 4).toString();
					Automobil auto = taksiSluzba.nadjiAutomobil(brojRegistarskeOznake);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete vozilo?", 
							brojRegistarskeOznake + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						auto.setObrisan(true);
						tableModel.removeRow(row);
						taksiSluzba.snimiVozila(Main.VOZILA_FAJL);
					}
				}
			}
			});
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_1.setBounds(237, 277, 111, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Izmjeni vozilo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzmjenaVozila iv = new IzmjenaVozila(taksiSluzba, taksiSluzbai);
				iv.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_2.setBounds(464, 277, 111, 50);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Close");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_3.setBounds(665, 277, 111, 50);
		contentPane.add(btnNewButton_3);
	}
}

