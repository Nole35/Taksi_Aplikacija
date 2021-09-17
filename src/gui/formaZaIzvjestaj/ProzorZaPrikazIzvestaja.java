package gui.formaZaIzvjestaj;

import taksiSluzba.TaksiSluzba;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProzorZaPrikazIzvestaja extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	public TaksiSluzba ucitavanje;
	public ProzorZaPrikazIzvestaja(int ukupanBrojSvihVoznji, int ukupanBrojVoznjiAplikacija,int ukupanBrojVoznjiTelefon, int prosecnoTrajanjeVoznji, int prosecnaKilometraza, int ukupnaZaradaZaSveVoznje, int prosecnaZaradaPoVoznji, int ukupanBrojAktivnihVozaca) {
		
		
		JLabel lblNewLabel = new JLabel("Ukupan broj voznji:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(26, 31, 180, 40);
		getContentPane().add(lblNewLabel);
		
		JLabel lblBrojVoznjiPorucenih_1 = new JLabel("Broj voznji porucenih telefonom:");
		lblBrojVoznjiPorucenih_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_1.setBounds(26, 97, 274, 40);
		getContentPane().add(lblBrojVoznjiPorucenih_1);
		
		JLabel lblBrojVoznjiPorucenih_2 = new JLabel("Broj voznji porucenih aplikacijom:");
		lblBrojVoznjiPorucenih_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2.setBounds(26, 175, 274, 40);
		getContentPane().add(lblBrojVoznjiPorucenih_2);
		
		JLabel lblBrojVoznjiPorucenih_2_1 = new JLabel("Prosjecno trajanje voznje:");
		lblBrojVoznjiPorucenih_2_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1.setBounds(26, 256, 274, 40);
		getContentPane().add(lblBrojVoznjiPorucenih_2_1);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1 = new JLabel("Prosjecno duzina voznje:");
		lblBrojVoznjiPorucenih_2_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1.setBounds(26, 332, 274, 40);
		getContentPane().add(lblBrojVoznjiPorucenih_2_1_1);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1_1 = new JLabel("Ukupna zarada:");
		lblBrojVoznjiPorucenih_2_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1_1.setBounds(26, 392, 274, 40);
		getContentPane().add(lblBrojVoznjiPorucenih_2_1_1_1);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1_1_1 = new JLabel("Ukupan broj vozaca za taj period:");
		lblBrojVoznjiPorucenih_2_1_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1_1_1.setBounds(26, 509, 274, 40);
		getContentPane().add(lblBrojVoznjiPorucenih_2_1_1_1_1);
		
		JButton btnNewButton = new JButton("Stampaj");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnNewButton.setBounds(26, 584, 120, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose ();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnClose.setBounds(279, 584, 120, 40);
		getContentPane().add(btnClose);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1_1_2 = new JLabel("Prosecna zarada:");
		lblBrojVoznjiPorucenih_2_1_1_1_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1_1_2.setBounds(26, 461, 274, 40);
		getContentPane().add(lblBrojVoznjiPorucenih_2_1_1_1_2);
		
		textField = new JTextField();
		textField.setText(String.valueOf(ukupanBrojSvihVoznji));
		textField.setBounds(310, 31, 134, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(String.valueOf(ukupanBrojVoznjiAplikacija));
		textField_1.setColumns(10);
		textField_1.setBounds(310, 97, 134, 29);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText(String.valueOf(ukupanBrojVoznjiTelefon));
		textField_2.setColumns(10);
		textField_2.setBounds(310, 175, 134, 29);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText(prosecnoTrajanjeVoznji + " min");
		textField_3.setColumns(10);
		textField_3.setBounds(310, 256, 134, 29);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText(prosecnaKilometraza + " km");
		textField_4.setColumns(10);
		textField_4.setBounds(310, 332, 134, 29);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText(ukupnaZaradaZaSveVoznje + " din");
		textField_5.setColumns(10);
		textField_5.setBounds(310, 391, 134, 29);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText(prosecnaZaradaPoVoznji + " din");
		textField_6.setColumns(10);
		textField_6.setBounds(310, 461, 134, 29);
		getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText(String.valueOf(ukupanBrojAktivnihVozaca));
		textField_7.setColumns(10);
		textField_7.setBounds(310, 509, 134, 29);
		getContentPane().add(textField_7);
	}

   

}

