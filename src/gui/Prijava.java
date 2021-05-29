package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import taksiSluzba.TaksiSluzba;

public class Prijava extends JFrame {

	private JPanel contentPane;


	
	public Prijava(TaksiSluzba taksiSluzba) {
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Taksi Sluzba");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 40));
		lblTitle.setBounds(217, 32, 385, 67);
		contentPane.add(lblTitle);
		
		JButton btnDLogin = new JButton("Dispecer Prijava");
		btnDLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PrijavaDispecer pd = new PrijavaDispecer(taksiSluzba);
				pd.setVisible(true);
				
			}
		});
		btnDLogin.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnDLogin.setBounds(40, 160, 182, 81);
		contentPane.add(btnDLogin);
		
		JButton btnMLogin = new JButton("Musterija Prijava");
		btnMLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrijavaMusterija pm = new PrijavaMusterija(taksiSluzba);
				pm.setVisible(true);
				
			}
		});
		btnMLogin.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnMLogin.setBounds(290, 160, 182, 81);
		contentPane.add(btnMLogin);
		
		JButton btnVLogin = new JButton("Vozac Prijava");
		btnVLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrijavaVozac pv = new PrijavaVozac(taksiSluzba);
				pv.setVisible(true);
			}
		});
		btnVLogin.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnVLogin.setBounds(518, 160, 182, 81);
		contentPane.add(btnVLogin);
	}

}