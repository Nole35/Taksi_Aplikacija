package gui.IstorijaVoznji;

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


import korisnici.Musterija;


import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IstorijaMusterijeT extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;


	public IstorijaMusterijeT(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Musterija musterija) {
		setTitle("Istorija voznji telefonom musterije " + musterija.getKorisnickoIme());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 866, 150);
		contentPane.add(scrollPane);
		
		String[] kolone = new String[] {"ID", "Datum i vrijeme narudzbe", "Adresa polaska", "Adresa destinacije", "Musterija id", "Vozac id", "Broj predjenih kilometara", "Trajanje voznje", "Status", "Tip porucivanja","Cijena"};
		Object[][] sadrzaj = new Object[taksiSluzba.sveNeobrisaneVoznjeT().size()][kolone.length];
		for(int i=0; i<taksiSluzba.sveNeobrisaneVoznjeT().size(); i++) {
			VoznjaTelefon voznjat = taksiSluzba.sveNeobrisaneVoznjeT().get(i);
		if(voznjat.getMusterijaId() == musterija.getId()) {
			
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
			}
			
			
			
		
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




