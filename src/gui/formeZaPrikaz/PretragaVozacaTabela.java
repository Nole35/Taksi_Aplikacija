package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import korisnici.Dispeceri;
import korisnici.Vozaci;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import vozila.Automobil;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PretragaVozacaTabela extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnNewButton;


	public PretragaVozacaTabela(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Dispeceri dispecer) {
		setTitle("Vozaci");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 766, 234);
		contentPane.add(scrollPane);
		String[] kolone = new String[] {"ID", "Korisnicko ime", "Ime", "Prezime", "JMBG", "Adresa ", "Pol", "Broj telefona", "Plata", "Prosjecna ocjena","ID automobila"};
		Object[][] sadrzaj = new Object[taksiSluzba.sviNeobrisaniVozaci().size()][kolone.length];
		for(int i=0; i<taksiSluzba.sviNeobrisaniVozaci().size(); i++) {
			Vozaci vozaci = taksiSluzba.sviNeobrisaniVozaci().get(i);
			sadrzaj[i][0] = vozaci.getId();
			sadrzaj[i][1] = vozaci.getKorisnickoIme();
			sadrzaj[i][2] = vozaci.getIme();
			sadrzaj[i][3] = vozaci.getPrezime();
			sadrzaj[i][4] = vozaci.getJmbg();
			sadrzaj[i][5] = vozaci.getAdresa();
			sadrzaj[i][6] = vozaci.getPol();
			sadrzaj[i][7] = vozaci.getBrojTelefona();
			sadrzaj[i][8] = vozaci.getPlata();
			sadrzaj[i][9] = vozaci.getBrojClanskeKarte();
			for (Automobil automobil: taksiSluzba.getVozila()
				 ) {
				if (automobil.getIdVozaca() == vozaci.getId()){
					sadrzaj[i][10] = automobil.getId();
				}

			}
			
		}
		tableModel = new DefaultTableModel(
				sadrzaj,kolone );
		table = new JTable(tableModel);
		table.setFont(new Font("SansSerif", Font.PLAIN, 10));
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);
	
		
		
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnNewButton.setBounds(401, 300, 85, 40);
		contentPane.add(btnNewButton);
		table.setDefaultEditor(Object.class, null);
	}}
