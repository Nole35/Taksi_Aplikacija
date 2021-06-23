package gui.formeZaIzmjenu;




import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.formeZaPrikaz.VozilaProzor;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzmjenaVozila extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private TaksiSluzba taksiSluzba;
	private TaksiSluzbai taksiSluzbai;

	public IzmjenaVozila(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		setTitle("Izmjena vozila");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(319, 55, 230, 35);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(319, 97, 230, 35);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(319, 136, 230, 35);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(319, 186, 230, 35);
		contentPane.add(textField_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(2);
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
		comboBox.setBounds(319, 236, 230, 35);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Potvrdi izmjene");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setBounds(104, 347, 150, 35);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VozilaProzor vpr = new VozilaProzor(taksiSluzba, taksiSluzbai);
				vpr.setVisible(true);
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnClose.setBounds(420, 347, 150, 35);
		contentPane.add(btnClose);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setMaximumRowCount(2);
		comboBox_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		comboBox_1.setBounds(319, 281, 230, 35);
		contentPane.add(comboBox_1);
		
		JLabel lblVozac = new JLabel("Vozac:");
		lblVozac.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblVozac.setBounds(37, 281, 160, 35);
		contentPane.add(lblVozac);
	}
}


