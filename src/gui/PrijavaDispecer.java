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
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;

public class PrijavaDispecer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	

	
	public PrijavaDispecer(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		setTitle("Prijava Dispecera");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Dispecer");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 34));
		lblTitle.setBounds(178, 10, 202, 66);
		contentPane.add(lblTitle);
		
		JLabel lblUsername = new JLabel("Korisnicko Ime:");
		lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblUsername.setBounds(23, 75, 162, 36);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(195, 88, 313, 19);
		contentPane.add(textField);
		
		JLabel lblPassword = new JLabel("Sifra:");
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblPassword.setBounds(23, 121, 107, 36);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 134, 313, 19);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Prijava");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Algoritam prijave
				
				boolean postojiDispecer = false;
				for (Dispeceri dispecer : taksiSluzba.getDispeceri()) {
					if(passwordField.getText().equals(dispecer.getLozinka()) && textField.getText().equals(dispecer.getKorisnickoIme())) {
						System.out.println("DISPECER: " + dispecer.getIme());
						 postojiDispecer = true;
						DispecerProzor dp = new DispecerProzor(taksiSluzba, taksiSluzbai,dispecer);
						dp.setVisible(true);
						
						dispose();
						break;
					} 
				}
				if(!postojiDispecer) {
					JOptionPane.showMessageDialog(null, "Ne postoji trazeni korisnik.", "Gre�ka", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnLogin.setBounds(198, 195, 114, 27);
		contentPane.add(btnLogin);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnClose.setBounds(357, 195, 114, 27);
		contentPane.add(btnClose);
	}
}
