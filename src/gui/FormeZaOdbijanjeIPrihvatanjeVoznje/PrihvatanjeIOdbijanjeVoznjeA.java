package gui.FormeZaOdbijanjeIPrihvatanjeVoznje;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import enumi.Status;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import voznje.VoznjaAplikacija;


public class PrihvatanjeIOdbijanjeVoznjeA extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public PrihvatanjeIOdbijanjeVoznjeA(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		setTitle("Prihvatanje voznje aplikacija");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 866, 150);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Prihvati");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int row = table.getSelectedRow();
				  
				 long idVoznjeAP = Long.parseLong((String) table.getValueAt(row, 0));
				
				 
					  for (VoznjaAplikacija voznja : taksiSluzba.getVoznje()
							  ) {
	                        if (idVoznjeAP == voznja.getId()) {
	                            voznja.setStatus(Status.PRIHVACENA);
	                        
	                    }
					 
				 }
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setBounds(154, 238, 143, 49);
		contentPane.add(btnNewButton);
		
		JButton btnOdbij = new JButton("Odbiti");
		btnOdbij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOdbij.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnOdbij.setBounds(614, 238, 143, 49);
		contentPane.add(btnOdbij);
		
		String[] kolone = new String[] {"ID", "Datum i vrijeme narudzbe", "Adresa polaska", "Adresa destinacije", "Musterija id", "Vozac id", "Broj predjenih kilometara", "Trajanje voznje", "Status", "Tip porucivanja","Napomena","Cijena"};
		Object[][] sadrzaj = new Object[taksiSluzba.sveNeobrisaneVoznjeNaCekApl().size()][kolone.length];
		for(int i=0; i<taksiSluzba.sveNeobrisaneVoznjeNaCekApl().size(); i++) {
			VoznjaAplikacija voznja = taksiSluzba.sveNeobrisaneVoznjeNaCekApl().get(i);
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
}}
