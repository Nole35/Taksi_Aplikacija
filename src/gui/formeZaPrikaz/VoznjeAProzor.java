package gui.formeZaPrikaz;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import vozila.Automobil;
import voznje.VoznjaAplikacija;
import voznje.VoznjaTelefon;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import gui.DispecerProzor;

import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VoznjeAProzor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;


	public VoznjeAProzor(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		setTitle("Voznje aplikacijom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 866, 150);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Obrisi voznju");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite red", "Greska", JOptionPane.WARNING_MESSAGE);}
				else {
					String adresaDestinacije = table.getValueAt(row, 3).toString();
					VoznjaAplikacija voznja = taksiSluzba.nadjiVoznjua(adresaDestinacije);
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete voznju?", 
							 adresaDestinacije + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						voznja.setObrisan(true);
						tableModel.removeRow(row);
						taksiSluzba.snimiVoznje("voznje.txt");
					}
				}
			}
			
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setBounds(154, 238, 143, 49);
		contentPane.add(btnNewButton);
		
		String[] kolone = new String[] {"ID", "Datum i vrijeme narudzbe", "Adresa polaska", "Adresa destinacije", "Musterija id", "Vozac id", "Broj predjenih kilometara", "Trajanje voznje", "Status", "Tip porucivanja","Napomena","Cijena"};
		Object[][] sadrzaj = new Object[taksiSluzba.sveNeobrisaneVoznjeA().size()][kolone.length];
		for(int i=0; i<taksiSluzba.sveNeobrisaneVoznjeA().size(); i++) {
			VoznjaAplikacija voznja = taksiSluzba.sveNeobrisaneVoznjeA().get(i);
			sadrzaj[i][0] = voznja.getId();
			sadrzaj[i][1] = voznja.getDatumIVremePoruzbine();
			sadrzaj[i][2] = voznja.getAdresaPolaska();
			sadrzaj[i][3] = voznja.getAdresaDestinacije();
			sadrzaj[i][4] = voznja.getMusterijaId();
			sadrzaj[i][5] = voznja.getVozacId();
			sadrzaj[i][6] = voznja.getBrojPredjenihKilometara();
			sadrzaj[i][7] = voznja.getTrajanjeVoznje();
			sadrzaj[i][8] = voznja.getStatus();
			sadrzaj[i][9] = voznja.getTipPorucivanja();
			sadrzaj[i][10] = voznja.getNapomena();
			sadrzaj[i][11] = voznja.getCijena();
			
			
			
		
		tableModel = new DefaultTableModel(
				sadrzaj,kolone );

		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
	
	
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnClose.setBounds(361, 243, 150, 35);
		contentPane.add(btnClose);
	}
}
}


