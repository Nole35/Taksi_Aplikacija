package gui.formaZaIzvjestaj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import taksiSluzba.TaksiSluzba;

import javax.swing.JLabel;
import java.awt.Font;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PrikazIzvestajaPoVozacu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	TaksiSluzba taksisluzba;
	public PrikazIzvestajaPoVozacu(int ukupnoVoznji, double ukupnoKilometara, double ukupnoTrajanje, double prosekKilometara, double prosekTrajanja, double ukupnaZarada, double prosecnaZarada) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ukupan broj voznji:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setBounds(23, 10, 180, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();

		textField.setText("0");
		textField.setColumns(10);
		textField.setBounds(307, 10, 134, 29);
		contentPane.add(textField);
		
		JLabel lblBrojVoznjiPorucenih_1 = new JLabel("Ukupna duzina:");
		lblBrojVoznjiPorucenih_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_1.setBounds(23, 76, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih_1);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setColumns(10);
		textField_1.setBounds(307, 76, 134, 29);
		contentPane.add(textField_1);
		
		JLabel lblBrojVoznjiPorucenih_2 = new JLabel("Ukupno trajanje:");
		lblBrojVoznjiPorucenih_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2.setBounds(23, 154, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih_2);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setColumns(10);
		textField_2.setBounds(307, 154, 134, 29);
		contentPane.add(textField_2);
		
		JLabel lblBrojVoznjiPorucenih_2_1 = new JLabel("Prosjecna duzina voznje:");
		lblBrojVoznjiPorucenih_2_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1.setBounds(23, 235, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih_2_1);
		
		textField_3 = new JTextField();
		textField_3.setText("0 min");
		textField_3.setColumns(10);
		textField_3.setBounds(307, 235, 134, 29);
		contentPane.add(textField_3);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1 = new JLabel("Prosjecno trajanje voznje:");
		lblBrojVoznjiPorucenih_2_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1.setBounds(23, 311, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih_2_1_1);

		textField_4 = new JTextField();
		textField_4.setText("0 din");
		textField_4.setColumns(10);
		textField_4.setBounds(307, 504, 134, 29);
		contentPane.add(textField_4);

		JLabel lblBrojVoznjiPorucenih_2_1_1_1_2_1 = new JLabel("Prosecno bez voznje:");
		lblBrojVoznjiPorucenih_2_1_1_1_2_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1_1_2_1.setBounds(23, 495, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih_2_1_1_1_2_1);
		
		textField_5 = new JTextField();
		textField_5.setText("0 km");
		textField_5.setColumns(10);
		textField_5.setBounds(307, 311, 134, 29);
		contentPane.add(textField_5);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1_1 = new JLabel("Ukupna zarada:");
		lblBrojVoznjiPorucenih_2_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1_1.setBounds(23, 371, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih_2_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setText("0 din");
		textField_6.setColumns(10);
		textField_6.setBounds(307, 370, 134, 29);
		contentPane.add(textField_6);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1_1_2 = new JLabel("Prosecna zarada:");
		lblBrojVoznjiPorucenih_2_1_1_1_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1_1_2.setBounds(23, 440, 274, 40);
		contentPane.add(lblBrojVoznjiPorucenih_2_1_1_1_2);
		
		textField_7 = new JTextField();
		textField_7.setText("0 din");
		textField_7.setColumns(10);
		textField_7.setBounds(307, 440, 134, 29);
		contentPane.add(textField_7);

		popunjavanjePolja(ukupnoVoznji, ukupnoKilometara, ukupnoTrajanje, prosekKilometara, prosekTrajanja, ukupnaZarada, prosecnaZarada);



				JButton btnNewButton = new JButton("Stampaj");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnNewButton.setBounds(23, 563, 120, 40);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnClose.setBounds(276, 563, 120, 40);
		contentPane.add(btnClose);
		


	}
	private void popunjavanjePolja(int ukupnoVoznji, double ukupnoKilometara, double ukupnoTrajanje, double prosekKilometara, double prosekTrajanja, double ukupnaZarada, double prosecnaZarada){
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);
		textField.setText(String.valueOf(ukupnoVoznji));
		textField_1.setText(String.valueOf(ukupnoKilometara + " km"));
		textField_2.setText(String.valueOf(ukupnoTrajanje + " min"));
		textField_3.setText(String.valueOf(prosekKilometara));
		textField_4.setText(String.valueOf(prosekTrajanja + " min"));

		textField_6.setText(String.valueOf(ukupnaZarada + " din"));
		textField_7.setText(String.valueOf(prosecnaZarada + " din"));
	}
}
