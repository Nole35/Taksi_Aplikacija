package gui.formaZaIzvjestaj;

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
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzvjestajVozaca extends JFrame {

	private JPanel contentPane;

	public IzvjestajVozaca(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Dispeceri dispecer) {
		setTitle("Izvjestaj vozaca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dan:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel.setBounds(62, 49, 162, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblMjesec = new JLabel("Mjesec:");
		lblMjesec.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblMjesec.setBounds(258, 49, 162, 41);
		contentPane.add(lblMjesec);
		
		JLabel lblGodina = new JLabel("Godina:");
		lblGodina.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblGodina.setBounds(430, 49, 162, 41);
		contentPane.add(lblGodina);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox.setBounds(50, 100, 75, 41);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_1.setBounds(243, 100, 75, 41);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_1_1.setBounds(421, 100, 75, 41);
		contentPane.add(comboBox_1_1);
		
		JButton btnNewButton = new JButton("Kreiraj izvjestaj");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 197, 162, 41);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnClose.setBounds(374, 197, 162, 41);
		contentPane.add(btnClose);
	}

}
