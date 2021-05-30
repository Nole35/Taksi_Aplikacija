package gui;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import korisnici.Dispeceri;
import korisnici.Vozaci;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrijavaVozac extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	

	
	public PrijavaVozac(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		setTitle("Prijava Vozac");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Vozac");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 34));
		lblTitle.setBounds(207, 10, 202, 66);
		contentPane.add(lblTitle);
		
		JLabel lblUsername = new JLabel("Korisnicko Ime:");
		lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblUsername.setBounds(42, 81, 162, 36);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Sifra:");
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblPassword.setBounds(42, 137, 107, 36);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(217, 94, 313, 19);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(217, 150, 313, 19);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Prijava");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean postojiVozac = false;
				for (Vozaci vozac : taksiSluzba.getVozaci()) {
					if(passwordField.getText().equals(vozac.getLozinka()) && textField.getText().equals(vozac.getKorisnickoIme())) {
						System.out.println("VOZAC: " + vozac.getIme());
						 postojiVozac = true;
				VozacProzor vp = new VozacProzor(taksiSluzba,taksiSluzbai);
				vp.setVisible(true);
				dispose();
			}
				}
				if(!postojiVozac) {
					JOptionPane.showMessageDialog(null, "Ne postoji trazeni korisnik.", "Greška", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnLogin.setBounds(217, 211, 114, 27);
		contentPane.add(btnLogin);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prijava p = new Prijava(taksiSluzba,taksiSluzbai);
				p.setVisible(true);
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnClose.setBounds(376, 211, 114, 27);
		contentPane.add(btnClose);
	}

}

