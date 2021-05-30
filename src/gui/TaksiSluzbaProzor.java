package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import taksiSluzba.TaksiSluzba;

public class TaksiSluzbaProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	
	

	public TaksiSluzbaProzor(TaksiSluzba taksiSluzba) {
		setTitle("Prikaz i izmjena podataka taksi sluzbe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPib = new JLabel("PIB:");
		lblPib.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblPib.setBounds(71, 10, 137, 67);
		contentPane.add(lblPib);
		
		JLabel lblName = new JLabel("Naziv:");
		lblName.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblName.setBounds(71, 71, 137, 54);
		contentPane.add(lblName);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblAdresa.setBounds(71, 146, 137, 42);
		contentPane.add(lblAdresa);
		
		JLabel lblPrice = new JLabel("Cijena starta voznje:");
		lblPrice.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblPrice.setBounds(71, 198, 149, 44);
		contentPane.add(lblPrice);
		
		JLabel lblPricekm = new JLabel("Cijena po kilometru:");
		lblPricekm.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblPricekm.setBounds(71, 252, 149, 59);
		contentPane.add(lblPricekm);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textField.setBounds(246, 30, 305, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(246, 92, 305, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(246, 150, 305, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(246, 214, 305, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(246, 275, 305, 26);
		contentPane.add(textField_4);
		
		JButton btnSubmit = new JButton("Potvrdi izmjene");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnSubmit.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnSubmit.setBounds(246, 311, 149, 43);
		contentPane.add(btnSubmit);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DispecerProzor dp = new DispecerProzor(taksiSluzba);
				dp.setVisible(true);
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnClose.setBounds(402, 311, 149, 43);
		contentPane.add(btnClose);
	}
}
