package gui.formeZaPrikaz;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import voznje.VoznjaAplikacija;
import voznje.VoznjaTelefon;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import gui.DispecerProzor;

import javax.swing.JScrollPane;

public class VoznjeTProzor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;


	public VoznjeTProzor(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		setTitle("Voznje telefonom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 866, 151);
		contentPane.add(scrollPane);
		String[] kolone = new String[] {"ID", "Datum i vrijeme narudzbe", "Adresa polaska", "Adresa destinacije", "Musterija id", "Vozac id", "Broj predjenih kilometara", "Trajanje voznje", "Status", "Tip porucivanja"};
		Object[][] sadrzaj = new Object[taksiSluzba.sveNeobrisaneVoznjeT().size()][kolone.length];
		for(int i=0; i<taksiSluzba.sveNeobrisaneVoznjeT().size(); i++) {
			VoznjaTelefon voznjat = taksiSluzba.sveNeobrisaneVoznjeT().get(i);
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

}}

