package gui.formeZaNarucivanje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enumi.Status;
import enumi.TipPorucivanja;
import gui.MusterijaProzor;
import korisnici.Musterija;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import vozila.Automobil;
import voznje.VoznjaAplikacija;
import voznje.VoznjaTelefon;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class NarucivanjeTelefon extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public NarucivanjeTelefon(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Musterija musterija) {
		setTitle("Narucivanje voznje telefonom");
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
			long id = 0;
			for (VoznjaTelefon voznjat: taksiSluzba.getVoznjet()
					 ) {
					if (id <= voznjat.getId()){
						id = (voznjat.getId() + 1);
					}
					
					}
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			 
             Date datumKreiranja = new Date();
             String strDate = formatter.format(datumKreiranja); 
             Status statusVoznje = Status.KREIRANA;
             int cijena = 0;
             VoznjaTelefon novaVoznja = new VoznjaTelefon(id,strDate,adresaPolaska,adresaDestinacije,musterija.getId(),musterija,0,null,0,0,statusVoznje,false,cijena, TipPorucivanja.TELEFONOM);
             taksiSluzba.getVoznjet().add(novaVoznja);
             taksiSluzba.snimiVoznjet("voznjet.txt");
				}
				catch (Exception exception) {
				
			}
			}}
		);
		btnNaruci.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnNaruci.setBounds(306, 240, 160, 80);
		contentPane.add(btnNaruci);
		
		JLabel lblAdresaDestinacije = new JLabel("Adresa destinacije:");
		lblAdresaDestinacije.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblAdresaDestinacije.setBounds(40, 171, 160, 35);
		contentPane.add(lblAdresaDestinacije);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(234, 171, 350, 35);
		contentPane.add(textField_1);
	}

}

