package gui.formeZaPrikaz;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.DispecerProzor;
import gui.formeZaDodavanje.DodajVozilo;
import gui.formeZaIzmjenu.IzmjenaVozila;
import korisnici.Dispeceri;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import vozila.Automobil;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.lazic.Main;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VozilaProzor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;

	public VozilaProzor(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Dispeceri dispecer) {
		setTitle("Vozila");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		String[] kolone = new String[] {"ID", "Model", "Proizvodjac", "Godina proizvodnje", "Broj registracije", "Broj taksi vozila", "Vrsta automobila","Id vozaca"};
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
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 33, 766, 234);
		contentPane.add(scrollPane);
	
		
	
			
		
		
		
		JButton btnNewButton = new JButton("Dodaj vozilo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajVozilo dov = new DodajVozilo(taksiSluzba, taksiSluzbai);
				dov.setVisible(true);
				
				
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton.setBounds(10, 277, 111, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Izbrisi vozilo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite red", "Greska", JOptionPane.WARNING_MESSAGE);}
				else {
					String brojRegistarskeOznake = table.getValueAt(row, 4).toString();
					Automobil automobil = taksiSluzba.nadjiAutomobil(brojRegistarskeOznake);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete vozilo?", 
							brojRegistarskeOznake + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						automobil.setObrisan(true);
						tableModel.removeRow(row);
						taksiSluzba.snimiVozila("automobil.txt");
					}
				}
			}
			});
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_1.setBounds(237, 277, 111, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Izmjeni vozilo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite  red ", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String brojRegistarskeOznake = table.getValueAt(row, 4).toString();
					Automobil automobil = taksiSluzba.nadjiAutomobil(brojRegistarskeOznake);
					if(automobil == null) {
						JOptionPane.showMessageDialog(null, "Greska nema automobila sa tom registracijom", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						IzmjenaVozila iv = new IzmjenaVozila(taksiSluzba, taksiSluzbai,automobil);
						iv.setVisible(true);
						
					}
					
				}
	
			}
		});
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_2.setBounds(464, 277, 111, 50);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Close");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_3.setBounds(665, 277, 111, 50);
		contentPane.add(btnNewButton_3);
	}
}

