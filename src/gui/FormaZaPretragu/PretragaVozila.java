package gui.FormaZaPretragu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.formeZaPrikaz.PretragaVozilaTabela;
import korisnici.Dispeceri;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PretragaVozila extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	public PretragaVozila(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Dispeceri dispecer) {
		setTitle("Pretraga vozila");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Model:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(61, 10, 114, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblProizvodjac = new JLabel("Proizvodjac:");
		lblProizvodjac.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblProizvodjac.setBounds(61, 70, 114, 30);
		contentPane.add(lblProizvodjac);
		
		JLabel lblBrojRegistracije = new JLabel("Broj registracije:");
		lblBrojRegistracije.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojRegistracije.setBounds(61, 130, 130, 30);
		contentPane.add(lblBrojRegistracije);
		
		JLabel lblBrojTaksiVozila = new JLabel("Broj taksi vozila:");
		lblBrojTaksiVozila.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojTaksiVozila.setBounds(61, 190, 130, 30);
		contentPane.add(lblBrojTaksiVozila);
		
		textField = new JTextField();
		textField.setBounds(228, 10, 230, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(228, 70, 230, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(228, 130, 230, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(228, 190, 230, 30);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Pretraga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PretragaVozilaTabela pvt = new  PretragaVozilaTabela(taksiSluzba, taksiSluzbai,dispecer);
				 pvt.setVisible(true);
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
		
		JLabel lblGodinaProizvodnje = new JLabel("Godina proizvodnje:");
		lblGodinaProizvodnje.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblGodinaProizvodnje.setBounds(61, 250, 171, 30);
		contentPane.add(lblGodinaProizvodnje);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(228, 250, 230, 30);
		contentPane.add(textField_4);
	}
}
