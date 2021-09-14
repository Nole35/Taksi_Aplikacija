package gui.formeZaNarucivanje;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import enumi.Status;
import enumi.TipPorucivanja;
import korisnici.Musterija;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import voznje.VoznjaAplikacija;
import voznje.VoznjaTelefon;
import javax.swing.JCheckBox;

public class NarucivanjeAplikacija extends JFrame {

private JPanel contentPane;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;


public NarucivanjeAplikacija(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Musterija musterija) {
	setTitle("Narucivanje voznje aplikacijom");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 700, 400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblAdresaPolaska = new JLabel("Adresa polaska:");
	lblAdresaPolaska.setFont(new Font("SansSerif", Font.PLAIN, 16));
	lblAdresaPolaska.setBounds(40, 53, 160, 35);
	contentPane.add(lblAdresaPolaska);
	
	textField = new JTextField();
	textField.setColumns(10);
	textField.setBounds(234, 53, 350, 35);
	contentPane.add(textField);
	
	JButton btnClose = new JButton("Close");
	btnClose.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			dispose();
			
		}
	});
	btnClose.setFont(new Font("SansSerif", Font.PLAIN, 16));
	btnClose.setBounds(591, 10, 85, 35);
	contentPane.add(btnClose);
	
	JButton btnNaruci = new JButton("Naruci");
	btnNaruci.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
		String adresaPolaska =	textField.getText();
		String adresaDestinacije =	textField_1.getText();
		String napomena = textField_2.getText();
		long id = 0;
		for (VoznjaAplikacija voznja: taksiSluzba.getVoznje()
				 ) {
				if (id <= voznja.getId()){
					id = (voznja.getId() + 1);
				}
				
				}
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 
         Date datumKreiranja = new Date();
         String strDate = formatter.format(datumKreiranja); 
         Status statusVoznje = Status.KREIRANA_NA_CEKANJU;
         if (adresaPolaska.equals("") || adresaDestinacije.equals("")) {
             System.out.println("Niste unijeli podatke");
             throw new Exception();}
         int cijena = 0;
         VoznjaAplikacija novaVoznja = new VoznjaAplikacija(id,strDate,adresaPolaska,adresaDestinacije,musterija.getId(),musterija,0,null,0,0,statusVoznje,false,cijena, TipPorucivanja.APLIKACIJOM,napomena);
         taksiSluzba.getVoznje().add(novaVoznja);
         taksiSluzba.snimiVoznje("voznje.txt");
			JOptionPane.showMessageDialog(null, "Uspjesno narucena voznja", "Uspjesno narucivanje  ", JOptionPane.INFORMATION_MESSAGE);

			}
			catch (Exception exception) {
			
		}
		}}
	);
	btnNaruci.setFont(new Font("SansSerif", Font.PLAIN, 20));
	btnNaruci.setBounds(302, 328, 160, 35);
	contentPane.add(btnNaruci);
	
	JLabel lblAdresaDestinacije = new JLabel("Adresa destinacije:");
	lblAdresaDestinacije.setFont(new Font("SansSerif", Font.PLAIN, 16));
	lblAdresaDestinacije.setBounds(40, 111, 160, 35);
	contentPane.add(lblAdresaDestinacije);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(234, 111, 350, 35);
	contentPane.add(textField_1);
	
	JLabel lblNapomena = new JLabel("Napomena:");
	lblNapomena.setFont(new Font("SansSerif", Font.PLAIN, 16));
	lblNapomena.setBounds(40, 260, 160, 35);
	contentPane.add(lblNapomena);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(234, 244, 350, 74);
	contentPane.add(textField_2);
	
	JLabel lblNewLabel = new JLabel("Pet friendly");
	lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
	lblNewLabel.setBounds(40, 179, 160, 35);
	contentPane.add(lblNewLabel);
	
	JCheckBox chckbxNewCheckBox = new JCheckBox("");
	chckbxNewCheckBox.setBounds(234, 189, 93, 21);
	contentPane.add(chckbxNewCheckBox);
}
}

