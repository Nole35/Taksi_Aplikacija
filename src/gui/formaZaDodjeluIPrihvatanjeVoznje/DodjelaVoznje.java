package gui.formaZaDodjeluIPrihvatanjeVoznje;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enumi.Status;
import gui.DispecerProzor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodjelaVoznje extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public DodjelaVoznje(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		setTitle("Dodjela voznje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdresaPolaska = new JLabel("Adresa polaska:");
		lblAdresaPolaska.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblAdresaPolaska.setBounds(30, 10, 160, 35);
		contentPane.add(lblAdresaPolaska);
		
		JLabel lblAdresaDestinacije = new JLabel("Adresa destinacije:");
		lblAdresaDestinacije.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblAdresaDestinacije.setBounds(30, 69, 160, 35);
		contentPane.add(lblAdresaDestinacije);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(224, 69, 350, 35);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(224, 10, 350, 35);
		contentPane.add(textField_1);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnClose.setBounds(591, 10, 85, 35);
		contentPane.add(btnClose);
		
		JButton btnDodjeli = new JButton("Dodjeli");
		btnDodjeli.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnDodjeli.setBounds(285, 299, 160, 54);
		contentPane.add(btnDodjeli);
		
		JLabel lblMusterija = new JLabel("Musterija:");
		lblMusterija.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblMusterija.setBounds(30, 128, 160, 35);
		contentPane.add(lblMusterija);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(224, 128, 350, 35);
		contentPane.add(textField_2);
		
		JLabel lblStatusVoznje = new JLabel("Status voznje:");
		lblStatusVoznje.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblStatusVoznje.setBounds(30, 187, 160, 35);
		contentPane.add(lblStatusVoznje);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Status.values()));
		comboBox.setBounds(224, 187, 350, 35);
		contentPane.add(comboBox);
		
		JLabel lblVozac = new JLabel("Vozac:");
		lblVozac.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblVozac.setBounds(30, 244, 160, 35);
		contentPane.add(lblVozac);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(224, 246, 350, 35);
		contentPane.add(textField_3);
	}

}

