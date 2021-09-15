package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import korisnici.Dispeceri;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzvjestajVoznjiDispecer extends JFrame {

	private JPanel contentPane;

	
	public IzvjestajVoznjiDispecer(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Dispeceri dispecer) {
		setTitle("Izvjestaj voznji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ukupan broj voznji:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(43, 22, 180, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblBrojVoznjiPorucenih = new JLabel("Broj voznji porucenih aplikacijom:");
		lblBrojVoznjiPorucenih.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih.setBounds(43, 88, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih);
		
		JLabel lblBrojVoznjiPorucenih_2 = new JLabel("Broj voznji porucenih telefonom:");
		lblBrojVoznjiPorucenih_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2.setBounds(43, 166, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih_2);
		
		JLabel lblBrojVoznjiPorucenih_2_1 = new JLabel("Prosjecno trajanje voznje:");
		lblBrojVoznjiPorucenih_2_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1.setBounds(43, 247, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih_2_1);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1 = new JLabel("Prosjecno duzina voznje:");
		lblBrojVoznjiPorucenih_2_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1.setBounds(43, 323, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih_2_1_1);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1_1 = new JLabel("Ukupna zarada:");
		lblBrojVoznjiPorucenih_2_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1_1.setBounds(43, 402, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih_2_1_1_1);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1_1_1 = new JLabel("Ukupan broj vozaca za taj period:");
		lblBrojVoznjiPorucenih_2_1_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1_1_1.setBounds(43, 474, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih_2_1_1_1_1);
		
		JButton btnNewButton = new JButton("Stampaj");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnNewButton.setBounds(43, 550, 120, 40);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnClose.setBounds(291, 550, 120, 40);
		contentPane.add(btnClose);
	}
}
