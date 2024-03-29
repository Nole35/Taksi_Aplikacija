package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.Color;
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

import korisnici.Dispeceri;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import vozila.Automobil;

public class IzvjestajVozacaTabela extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnStampaj;


	public IzvjestajVozacaTabela(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Dispeceri dispecer) {
		setTitle("Voznje vozaca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		String[] kolone = new String[] {"ID", "Ukupan broj", "Ukupna duzina", "Ukupno vrijeme", "Prosjecna duzina", "Prosecno vrijeme ", "Ukupna zarada","Prosjecna zarada"};
		Object[][] sadrzaj = new Object[taksiSluzba.sviNeobrisaniAutomobili().size()][kolone.length];
		for(int i=0; i<taksiSluzba.sviNeobrisaniAutomobili().size(); i++) {
			Automobil automobil = taksiSluzba.sviNeobrisaniAutomobili().get(i);
			sadrzaj[i][0] = automobil.getId();
			sadrzaj[i][1] = automobil.getModel();
			sadrzaj[i][2] = automobil.getProizvodjac();
			sadrzaj[i][3] = automobil.getGodinaProizvodnje();
			sadrzaj[i][4] = automobil.getBrojRegistarskeOznake();
			sadrzaj[i][5] = automobil.getBrojTaksiVozila();
			sadrzaj[i][6] = automobil.getVrstaAutomobila();
			sadrzaj[i][7] = automobil.getIdVozaca();
			
			
		}
		
		tableModel = new DefaultTableModel(
				sadrzaj,kolone );
		
		
		table = new JTable(tableModel);
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		table.setBackground(Color.LIGHT_GRAY);
		
	
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 33, 766, 234);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnNewButton.setBounds(650, 296, 95, 44);
		contentPane.add(btnNewButton);
		
		btnStampaj = new JButton("Stampaj");
		btnStampaj.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnStampaj.setBounds(62, 296, 95, 44);
		contentPane.add(btnStampaj);
	}	
}