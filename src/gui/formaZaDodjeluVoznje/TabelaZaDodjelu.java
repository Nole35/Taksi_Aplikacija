package gui.formaZaDodjeluVoznje;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;


import voznje.VoznjaTelefon;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import enumi.Status;
import gui.formaZaZavrsavanjeVoznje.ZavrsavanjeVoznjeT;
import korisnici.Dispeceri;
import korisnici.Vozaci;

import javax.swing.JScrollPane;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class TabelaZaDodjelu extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public TabelaZaDodjelu(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Dispeceri dispecer) {
		setTitle("Dodjela voznje telefonom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 866, 150);
		contentPane.add(scrollPane);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel());
		comboBox.addItem("Nije odabran vozac");
		for (Vozaci vozac: taksiSluzba.getVozaci()
			 ) {
			comboBox.addItem(vozac.getKorisnickoIme());


		}
		
		
		comboBox.setBounds(717, 237, 129, 35);
		contentPane.add(comboBox);
		
		JButton btnDodjeli = new JButton("Dodjeli");
		btnDodjeli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					if(row == -1) {
						JOptionPane.showMessageDialog(null, "Izaberite red", "Greska", JOptionPane.WARNING_MESSAGE);}
					else {
						String id = table.getValueAt(row, 0).toString();
						
						Long idVoznje = Long.parseLong(id);
						String korisnickoImeVozaca = String.valueOf(comboBox.getSelectedItem());
						long idVozaca = 0;
						for (Vozaci vozac: taksiSluzba.getVozaci()
							 ) {
							if (vozac.getKorisnickoIme().equals(korisnickoImeVozaca)){
								idVozaca = vozac.getId();
							}

						}
						if (idVozaca == 0){
							throw new Exception();
						}


						for (VoznjaTelefon voznjet: taksiSluzba.getVoznjet()
							 ) {
							if (voznjet.getId()== idVoznje){
								voznjet.setStatus(Status.DODELJENA);
								voznjet.setVozacId(idVozaca);
							}
							

						}
						taksiSluzba.snimiVoznjet("voznjet.txt");
						JOptionPane.showMessageDialog(null, "Voznja je dodijeljena", "Dodjela uspjela  ", JOptionPane.INFORMATION_MESSAGE);
						
						
						
						
					
					
					}
				}
						catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Greska pri dodjeli", "Greska   ", JOptionPane.WARNING_MESSAGE);
							
						} 
				}
			
		});
		btnDodjeli.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnDodjeli.setBounds(77, 237, 85, 35);
		contentPane.add(btnDodjeli);
		
		
		
		JLabel lblNewLabel = new JLabel("Vozac ID:");
		lblNewLabel.setBounds(600, 237, 85, 35);
		contentPane.add(lblNewLabel);
		
		
		
		
	
				
			
		
	
		
		String[] kolone = new String[] {"ID", "Datum i vrijeme narudzbe", "Adresa polaska", "Adresa destinacije", "Musterija id", "Vozac id", "Broj predjenih kilometara", "Trajanje voznje", "Status", "Tip porucivanja","Cijena"};
		Object[][] sadrzaj = new Object[taksiSluzba.sveNeobrisaneVoznjeDodTelT().size()][kolone.length];
		for(int i=0; i<taksiSluzba.sveNeobrisaneVoznjeDodTelT().size(); i++) {
			VoznjaTelefon voznjat = taksiSluzba.sveNeobrisaneVoznjeDodTelT().get(i);
			
			sadrzaj[i][0] = voznjat.getId();
			sadrzaj[i][1] = voznjat.getDatumIVremePoruzbine();
			sadrzaj[i][2] = voznjat.getAdresaPolaska();
			sadrzaj[i][3] = voznjat.getAdresaDestinacije();
			sadrzaj[i][4] = voznjat.getMusterijaId();
			sadrzaj[i][5] = voznjat.getVozacId();
			sadrzaj[i][6] = voznjat.getBrojPredjenihKilometara();
			sadrzaj[i][7] = voznjat.getTrajanjeVoznje();
			sadrzaj[i][8] = voznjat.getStatus();
			sadrzaj[i][9] = voznjat.getTipPorucivanja();
			sadrzaj[i][10] = voznjat.getCijena();
			

		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				sadrzaj,kolone ));
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

