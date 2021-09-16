package gui.FormaZaPretragu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import gui.formeZaPrikaz.PretragaVozacaTabela;
import gui.formeZaPrikaz.PretragaVozilaTabela;
import kolekcije.DoubleLinkedList;
import korisnici.Dispeceri;
import korisnici.Vozaci;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import vozila.Automobil;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PretragaVozaca extends JFrame {


	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;



	public PretragaVozaca(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Dispeceri dispecer) {
		setTitle("Petraga vozaca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);




		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblIme.setBounds(51, 10, 114, 30);
		contentPane.add(lblIme);

		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblPrezime.setBounds(51, 70, 114, 30);
		contentPane.add(lblPrezime);

		JLabel lblPlata = new JLabel("Plata:");
		lblPlata.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblPlata.setBounds(51, 130, 130, 30);
		contentPane.add(lblPlata);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(218, 10, 230, 30);
		contentPane.add(textField);


		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(218, 70, 230, 30);
		contentPane.add(textField_1);
		

		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(218, 130, 230, 30);
		contentPane.add(textField_2);
		



		
		JButton btnNewButton = new JButton("Pretraga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(validacija() == true) {
					String ime = textField.getText();
					String prezime = textField_1.getText();
					String plata = textField_2.getText();



					DoubleLinkedList<Vozaci> rezultatPretrageVozaca = taksiSluzba.pretraga1(ime, prezime, plata);
					PretragaVozacaTabela pvvt = new PretragaVozacaTabela(rezultatPretrageVozaca);
					pvvt.setVisible(true);
				}
			}
		});

		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnNewButton.setBounds(43, 318, 135, 34);
		contentPane.add(btnNewButton);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnClose.setBounds(412, 318, 135, 34);
		contentPane.add(btnClose);


		}



	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";

		if(textField.getText().trim().equals("")) {
			poruka += "- Unesite model\n";
			ok = false;
		}
		if(textField_1.getText().trim().equals("")) {
			poruka += "- Unesite proizvodjaca\n";
			ok = false;
		}
		if(textField_2.getText().trim().equals("")) {
			poruka += "- Unesite godinu proizvodnje\n";
			ok = false;
		}


		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}

		return ok;
	}





}
