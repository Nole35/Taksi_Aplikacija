package gui.formeZaPrikaz;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.DispecerProzor;
import gui.formeZaDodavanje.DodajVozaca;
import gui.formeZaIzmjenu.IzmjenaVozaca;
import korisnici.Dispeceri;
import korisnici.Vozaci;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import vozila.Automobil;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.lazic.Main;

import gui.formeZaDodavanje.DodajVozilo;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VozaciProzor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	


	public VozaciProzor(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Dispeceri dispecer) {
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
		String[] kolone = new String[] {"ID", "Korisnicko ime", "Lozinka", "Ime", "Prezime", "JMBG", "Adresa ", "Pol", "Broj telefona", "Plata", "Broj clanske karte","ID automobila"};
		Object[][] sadrzaj = new Object[taksiSluzba.sviNeobrisaniVozaci().size()][kolone.length];
		for(int i=0; i<taksiSluzba.sviNeobrisaniVozaci().size(); i++) {
			Vozaci vozaci = taksiSluzba.sviNeobrisaniVozaci().get(i);
			sadrzaj[i][0] = vozaci.getId();
			sadrzaj[i][1] = vozaci.getKorisnickoIme();
			sadrzaj[i][2] = vozaci.getLozinka();
			sadrzaj[i][3] = vozaci.getIme();
			sadrzaj[i][4] = vozaci.getPrezime();
			sadrzaj[i][5] = vozaci.getJmbg();
			sadrzaj[i][6] = vozaci.getAdresa();
			sadrzaj[i][7] = vozaci.getPol();
			sadrzaj[i][8] = vozaci.getBrojTelefona();
			sadrzaj[i][9] = vozaci.getPlata();
			sadrzaj[i][10] = vozaci.getBrojClanskeKarte();
			for (Automobil automobil: taksiSluzba.getVozila()
				 ) {
				if (automobil.getIdVozaca() == vozaci.getId()){
					sadrzaj[i][11] = automobil.getId();
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
		table.setDefaultEditor(Object.class, null);
			
		
		JButton btnNewButton = new JButton("Dodaj vozaca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajVozaca dovo = new DodajVozaca(taksiSluzba, taksiSluzbai);
				dovo.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton.setBounds(61, 303, 111, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Izbrisi vozaca");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int red = table.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else {
					String korisnickoIme = table.getValueAt(red, 1).toString();
					Vozaci vozaci = taksiSluzba.nadjiVozaca(korisnickoIme);
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete vozaca?", 
							korisnickoIme + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						vozaci.setObrisan(true);
						tableModel.removeRow(red);
						taksiSluzba.snimiVozace("vozaci.txt");
					}
				}
			}
			});
					
		
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_1.setBounds(288, 303, 111, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Izmjeni vozaca");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int red = table.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite red ", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String korisnickoIme = table.getValueAt(red, 1).toString();
					Vozaci vozaci = taksiSluzba.nadjiVozaca(korisnickoIme);
					if(vozaci == null) {
						JOptionPane.showMessageDialog(null, "Greska nema korisnika sa tim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
				IzmjenaVozaca iv = new IzmjenaVozaca(taksiSluzba, taksiSluzbai,vozaci);
				iv.setVisible(true);
				dispose();
					
			}
		}
				}
			});
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_2.setBounds(515, 303, 115, 50);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Close");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_3.setBounds(716, 303, 111, 50);
		contentPane.add(btnNewButton_3);
		
		
		
	}
}

