package gui.formeZaIzmjenu;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.formeZaPrikaz.VozaciProzor;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzmjenaVozaca extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	
	public IzmjenaVozaca(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		setTitle("Izmjena vozaca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 160, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblKorisnickoIme = new JLabel("Korisnicko ime:");
		lblKorisnickoIme.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblKorisnickoIme.setBounds(10, 80, 160, 35);
		contentPane.add(lblKorisnickoIme);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblLozinka.setBounds(10, 148, 160, 35);
		contentPane.add(lblLozinka);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblIme.setBounds(10, 216, 160, 35);
		contentPane.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblPrezime.setBounds(10, 284, 160, 35);
		contentPane.add(lblPrezime);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblJmbg.setBounds(411, 10, 160, 35);
		contentPane.add(lblJmbg);
		
		JLabel lblPol = new JLabel("Pol:");
		lblPol.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblPol.setBounds(200, 341, 160, 35);
		contentPane.add(lblPol);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(145, 10, 230, 35);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 77, 230, 35);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(145, 145, 230, 35);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(145, 213, 230, 35);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(145, 281, 230, 35);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(546, 10, 230, 35);
		contentPane.add(textField_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(2);
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
		comboBox.setBounds(387, 341, 230, 35);
		contentPane.add(comboBox);
		
		JButton btnIzmjeniVozaca = new JButton("Potvrdi izmjene");
		btnIzmjeniVozaca.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnIzmjeniVozaca.setBounds(161, 402, 150, 35);
		contentPane.add(btnIzmjeniVozaca);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VozaciProzor vop = new VozaciProzor(taksiSluzba, taksiSluzbai);
				vop.setVisible(true);
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnClose.setBounds(500, 402, 150, 35);
		contentPane.add(btnClose);
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona:");
		lblBrojTelefona.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblBrojTelefona.setBounds(411, 151, 160, 35);
		contentPane.add(lblBrojTelefona);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(546, 148, 230, 35);
		contentPane.add(textField_6);
		
		JLabel lblPlata = new JLabel("Plata:");
		lblPlata.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblPlata.setBounds(411, 224, 160, 35);
		contentPane.add(lblPlata);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(546, 221, 230, 35);
		contentPane.add(textField_7);
		
		JLabel lblBrojClanskeKarte = new JLabel("Broj clanske karte:");
		lblBrojClanskeKarte.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblBrojClanskeKarte.setBounds(400, 284, 160, 35);
		contentPane.add(lblBrojClanskeKarte);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(546, 281, 230, 35);
		contentPane.add(textField_8);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblAdresa.setBounds(411, 81, 160, 35);
		contentPane.add(lblAdresa);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(546, 78, 230, 35);
		contentPane.add(textField_9);
	}

}
