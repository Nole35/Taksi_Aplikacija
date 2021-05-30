package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import korisnici.Dispeceri;
import korisnici.Musterija;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;

public class PrijavaMusterija extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	

	public PrijavaMusterija(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		setTitle("Prijava Musterija");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Musterija");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 34));
		lblTitle.setBounds(209, 10, 202, 66);
		contentPane.add(lblTitle);
		
		JLabel lblUsername = new JLabel("Korisnicko Ime:");
		lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblUsername.setBounds(44, 81, 162, 36);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Sifra:");
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblPassword.setBounds(44, 137, 107, 36);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(219, 94, 313, 19);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(219, 150, 313, 19);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Prijava");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean postojiMusterija = false;
				for (Musterija musterija : taksiSluzba.getMusterije()) {
					if(passwordField.getText().equals(musterija.getLozinka()) && textField.getText().equals(musterija.getKorisnickoIme())) {
						System.out.println("MUSTERIJA: " + musterija.getIme());
						 postojiMusterija = true;
				MusterijaProzor mp = new MusterijaProzor(taksiSluzba,taksiSluzbai);
				mp.setVisible(true);
				dispose();
			}
		}
				if(!postojiMusterija) {
					JOptionPane.showMessageDialog(null, "Ne postoji trazeni korisnik.", "Greška", JOptionPane.WARNING_MESSAGE);
				}
				}
				});
		btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnLogin.setBounds(219, 211, 114, 27);
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
		btnClose.setBounds(378, 211, 114, 27);
		contentPane.add(btnClose);
	}

}


