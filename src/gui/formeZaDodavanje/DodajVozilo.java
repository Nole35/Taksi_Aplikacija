package gui.formeZaDodavanje;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enumi.VrstaAutomobila;
import gui.VozacProzor;
import gui.formeZaPrikaz.VozilaProzor;

import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import vozila.Automobil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class DodajVozilo extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private TaksiSluzba taksiSluzba;
	private TaksiSluzbai taksiSluzbai;
	
	private Automobil automobil;

	public DodajVozilo(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		this.taksiSluzba = taksiSluzba;
		this.taksiSluzbai = taksiSluzbai;
		this.automobil = automobil;
		setTitle("Dodavanje vozila");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JLabel lblModell = new JLabel("Model:");
		lblModell.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblModell.setBounds(37, 86, 160, 35);
		contentPane.add(lblModell);
		
		JLabel lblProizvodjac = new JLabel("Proizvodjac:");
		lblProizvodjac.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblProizvodjac.setBounds(37, 131, 160, 35);
		contentPane.add(lblProizvodjac);
		
		JLabel lblGodinaProizvodnje = new JLabel("Godina proizvodnje:");
		lblGodinaProizvodnje.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblGodinaProizvodnje.setBounds(37, 173, 160, 35);
		contentPane.add(lblGodinaProizvodnje);
		
		JLabel lblBrojRegistracije = new JLabel("Broj registracije:");
		lblBrojRegistracije.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblBrojRegistracije.setBounds(37, 212, 160, 35);
		contentPane.add(lblBrojRegistracije);
		
		JLabel lblVrstaAutomobila = new JLabel("Vrsta automobila:");
		lblVrstaAutomobila.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblVrstaAutomobila.setBounds(37, 257, 160, 35);
		contentPane.add(lblVrstaAutomobila);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(319, 83, 230, 35);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(319, 128, 230, 35);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(319, 170, 230, 35);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(319, 209, 230, 35);
		contentPane.add(textField_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(VrstaAutomobila.values()));
		comboBox.setMaximumRowCount(2);
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
		comboBox.setBounds(319, 257, 230, 35);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(validacija()) {
					String model = textField_1.getText();
					String proizvodjac = textField_2.getText();
					long godinaProizvodnje = Long.parseLong(textField_3.getText()) ;
					String brojRegistarskeOznake = textField_4.getText();
					VrstaAutomobila vrstaAutomobila = (VrstaAutomobila) comboBox.getSelectedItem();
					long id = 0;
					long brojTaksiVozila = 0;

					for (Automobil automobil: taksiSluzba.getVozila()
						 ) {
						if (id<= automobil.getId()){
							id = (automobil.getId() + 1);
						}
						if (brojTaksiVozila<=automobil.getBrojTaksiVozila()){
							brojTaksiVozila = automobil.getBrojTaksiVozila() + 1;
						}

					}
					
					Automobil automobil = new Automobil(id,model,proizvodjac,godinaProizvodnje,brojRegistarskeOznake,brojTaksiVozila,vrstaAutomobila,false,0);
					taksiSluzba.getVozila().add(automobil);
					taksiSluzba.snimiVozila("automobil.txt");
					JOptionPane.showMessageDialog(null, "Uspjesno  ste dodali vozilo", "Uspjesno dodavanje  ", JOptionPane.INFORMATION_MESSAGE);

				}
				
				
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setBounds(574, 86, 85, 35);
		contentPane.add(btnNewButton);

		
		
		
				
			

			
		
		
	
	
		
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				dispose();
			}
		
			
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnClose.setBounds(574, 256, 85, 35);
		contentPane.add(btnClose);}
		
		
		private boolean validacija() {
			boolean ok = true;
			String poruka = "Molimo popravite sledece greske u unosu:\n";
			
			if(textField_1.getText().trim().equals("")) {
				poruka += "- Unesite model\n";
				ok = false;
			}
			if(textField_2.getText().trim().equals("")) {
				poruka += "- Unesite proizvodjaca\n";
				ok = false;
			}
			if(textField_3.getText().trim().equals("")) {
				poruka += "- Unesite godinu proizvodnje\n";
				ok = false;
			}
			if(textField_4.getText().trim().equals("")) {
				poruka += "- Unesite broj registracije\n";
				ok = false;
			}
			else if(automobil == null){
				String brojRegistarskeOznake = textField_4.getText().trim();
				Automobil nadji = taksiSluzba.nadjiAutomobil(brojRegistarskeOznake);
				if(nadji != null) {
					poruka += "- Automobil sa tom registracijom vec postoji\n";
					ok = false;
				}
			}
				if(ok == false) {
					JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
				}
				
				return ok;
		}
	}

		


