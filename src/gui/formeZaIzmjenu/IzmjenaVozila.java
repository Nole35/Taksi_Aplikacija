package gui.formeZaIzmjenu;




import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enumi.VrstaAutomobila;
import gui.formeZaPrikaz.VozilaProzor;

import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import vozila.Automobil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzmjenaVozila extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1 =  new JTextField(20);
	private JTextField textField_2 =  new JTextField(20);
	private JTextField textField_3 =  new JTextField(20);
	private JTextField textField_4 =  new JTextField(20);
	private JTextField textField_5 =  new JTextField(20);
	private JComboBox<VrstaAutomobila> comboBox = new JComboBox<VrstaAutomobila>(VrstaAutomobila.values());
	private TaksiSluzba taksiSluzba;
	private TaksiSluzbai taksiSluzbai;
	private Automobil automobil;

	public IzmjenaVozila(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Automobil automobil) {
		this.automobil = automobil;
		this.taksiSluzba = taksiSluzba;
		this.taksiSluzbai= taksiSluzbai;
		System. out. println("Vraceni automobil " + automobil );

		
		setTitle("Izmjena vozila " + automobil.getBrojRegistarskeOznake());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		if(automobil != null && automobil.getModel()!=null) {
			popuniPolja();
		}
		
		JLabel lblModell = new JLabel("Model:");
		lblModell.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblModell.setBounds(37, 13, 160, 35);
		contentPane.add(lblModell);
		
		JLabel lblProizvodjac = new JLabel("Proizvodjac:");
		lblProizvodjac.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblProizvodjac.setBounds(37, 58, 160, 35);
		contentPane.add(lblProizvodjac);
		
		JLabel lblGodinaProizvodnje = new JLabel("Godina proizvodnje:");
		lblGodinaProizvodnje.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblGodinaProizvodnje.setBounds(37, 100, 160, 35);
		contentPane.add(lblGodinaProizvodnje);
		
		JLabel lblBrojRegistracije = new JLabel("Broj registracije:");
		lblBrojRegistracije.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblBrojRegistracije.setBounds(37, 139, 160, 35);
		contentPane.add(lblBrojRegistracije);
		
		JLabel lblBrojTaksiVozila = new JLabel("Broj taksi vozila:");
		lblBrojTaksiVozila.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblBrojTaksiVozila.setBounds(37, 189, 160, 35);
		contentPane.add(lblBrojTaksiVozila);
		
		JLabel lblVrstaAutomobila = new JLabel("Vrsta automobila:");
		lblVrstaAutomobila.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblVrstaAutomobila.setBounds(37, 236, 160, 35);
		contentPane.add(lblVrstaAutomobila);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(319, 10, 230, 35);
		textField_1.setText(automobil.getModel());
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(319, 55, 230, 35);
		textField_2.setText(automobil.getProizvodjac());
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(319, 97, 230, 35);
		textField_3.setText(String.valueOf(automobil.getGodinaProizvodnje()));
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(319, 136, 230, 35);
		textField_4.setText(automobil.getBrojRegistarskeOznake());
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(319, 186, 230, 35);
		textField_5.setText(String.valueOf(automobil.getBrojTaksiVozila()));
		
		contentPane.add(textField_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(VrstaAutomobila.values()));
		comboBox.setMaximumRowCount(2);
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
		comboBox.setBounds(319, 236, 230, 35);
		comboBox.setSelectedItem(automobil.getVrstaAutomobila());
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Potvrdi izmjene");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String model = textField_1.getText();
					String proizvodjac = textField_2.getText();
					long godinaProizvodnje = Long.parseLong(textField_3.getText()) ;
					String brojRegistarskeOznake = textField_4.getText();
					long brojTaksiVozila = Long.parseLong(textField_5.getText());
					VrstaAutomobila vrstaAutomobila = (VrstaAutomobila) comboBox.getSelectedItem();
					if(automobil != null) {
						automobil.setModel(model);
						automobil.setProizvodjac(proizvodjac);
						automobil.setGodinaProizvodnje(godinaProizvodnje);;
						automobil.setBrojRegistarskeOznake(brojRegistarskeOznake);
						automobil.setBrojTaksiVozila(brojTaksiVozila);
						automobil.setVrstaAutomobila(vrstaAutomobila);
						
					}
					taksiSluzba.snimiVozila("automobil.txt");
						
					}
			}
		});
		
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setBounds(104, 347, 150, 35);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnClose.setBounds(420, 347, 150, 35);
		contentPane.add(btnClose);
		
	
	}
	private void popuniPolja() {
		System.out.println("popunjavanje");
		this.textField_1.setText(automobil.getModel());
		textField_2.setText(automobil.getProizvodjac());
		textField_3.setText(String.valueOf(automobil.getGodinaProizvodnje()));
		textField_4.setText(automobil.getBrojRegistarskeOznake());
		textField_5.setText(String.valueOf(automobil.getBrojTaksiVozila()));
		comboBox.setSelectedItem(automobil.getVrstaAutomobila());
		System.out.println("kraj popunjavanja");
		System.out.println(automobil);

		
		
		
	}
	
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


