package gui.formeZaPrikaz;

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

public class AktivneAukcije extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;


	public AktivneAukcije(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Dispeceri dispecer) {
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
		

}}}
