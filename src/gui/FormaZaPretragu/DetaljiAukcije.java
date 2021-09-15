package gui.FormaZaPretragu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import korisnici.Dispeceri;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import voznje.VoznjaAplikacija;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetaljiAukcije extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;


	public DetaljiAukcije(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Dispeceri dispecer) {
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
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnNewButton.setBounds(392, 260, 161, 40);
		contentPane.add(btnNewButton);
		
		String[] kolone = new String[] {"ID Voznje", "ID vozaca", "Korisnicko ime", "Prosjecna ocjena", "Broj voznji ","Vrijeme", "Ocjena ponude"};
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
			
			
			
			
		
		tableModel = new DefaultTableModel(
				sadrzaj,kolone );

		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
	
	}

}}
