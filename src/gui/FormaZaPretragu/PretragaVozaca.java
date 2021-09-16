package gui.FormaZaPretragu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.formeZaPrikaz.PretragaVozacaTabela;
import gui.formeZaPrikaz.PretragaVozilaTabela;
import korisnici.Dispeceri;
import korisnici.Vozaci;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(218, 10, 230, 30);
		contentPane.add(textField);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblPrezime.setBounds(51, 70, 114, 30);
		contentPane.add(lblPrezime);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(218, 70, 230, 30);
		contentPane.add(textField_1);
		
		JLabel lblPlata = new JLabel("Plata:");
		lblPlata.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblPlata.setBounds(51, 130, 130, 30);
		contentPane.add(lblPlata);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(218, 130, 230, 30);
		contentPane.add(textField_2);
		
		JLabel lblAutomobil = new JLabel("Automobil:");
		lblAutomobil.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblAutomobil.setBounds(51, 190, 130, 30);
		contentPane.add(lblAutomobil);


		
		JButton btnNewButton = new JButton("Pretraga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PretragaVozacaTabela pvt = new  PretragaVozacaTabela(taksiSluzba, taksiSluzbai,dispecer);
				 pvt.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnNewButton.setBounds(51, 270, 135, 34);
		contentPane.add(btnNewButton);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnClose.setBounds(420, 270, 135, 34);
		contentPane.add(btnClose);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(218, 190, 230, 30);
		contentPane.add(comboBox);
	}



}
