package gui.formaZaIzvjestaj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.formeZaPrikaz.IzvjestajVoznjiDispecer;
import gui.formeZaPrikaz.IzvjestajVoznjiVozac;
import korisnici.Vozaci;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzvjestajVoznjiV extends JFrame {

	private JPanel contentPane;

	public IzvjestajVoznjiV(TaksiSluzba taksiSluzba,TaksiSluzbai taksiSluzbai,Vozaci vozac) {
		setTitle("Izvjestaj voznji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dan:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel.setBounds(101, 48, 162, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblMjesec = new JLabel("Mjesec:");
		lblMjesec.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblMjesec.setBounds(297, 48, 162, 41);
		contentPane.add(lblMjesec);
		
		JLabel lblGodina = new JLabel("Godina:");
		lblGodina.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblGodina.setBounds(469, 48, 162, 41);
		contentPane.add(lblGodina);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox.setBounds(89, 99, 75, 41);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_1.setBounds(282, 99, 75, 41);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_1_1.setBounds(460, 99, 75, 41);
		contentPane.add(comboBox_1_1);
		
		JButton btnNewButton = new JButton("Kreiraj izvjestaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzvjestajVoznjiVozac ivv = new  IzvjestajVoznjiVozac(taksiSluzba, taksiSluzbai,vozac);
				 ivv.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton.setBounds(49, 196, 162, 41);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnClose.setBounds(413, 196, 162, 41);
		contentPane.add(btnClose);
	}
}
