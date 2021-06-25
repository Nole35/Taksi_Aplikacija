package gui.formaZaZavrsavanjeVoznje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enumi.Status;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import voznje.VoznjaTelefon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZavrsavanjeVoznjeT extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	public ZavrsavanjeVoznjeT(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,long id) {
		setTitle("Zavrsavanje voznje telefonom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBrojPredjenihKilometara = new JLabel("Broj predjenih kilometara:");
		lblBrojPredjenihKilometara.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblBrojPredjenihKilometara.setBounds(24, 53, 184, 35);
		contentPane.add(lblBrojPredjenihKilometara);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(218, 53, 350, 35);
		contentPane.add(textField);
		
		JLabel lblTrajanjeVoznje = new JLabel("Trajanje voznje:");
		lblTrajanjeVoznje.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblTrajanjeVoznje.setBounds(24, 98, 160, 35);
		contentPane.add(lblTrajanjeVoznje);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(218, 98, 350, 35);
		contentPane.add(textField_1);
		
		JButton btnZavrsi = new JButton("Zavrsi"); try {
            int brojPredjenihKilometara = Integer.parseInt(textField.getText());
            int trajanjeVoznje = Integer.parseInt(textField.getText());

            int cijena = (int) (taksiSluzba.getCijenaPoKilometru() * brojPredjenihKilometara + taksiSluzba.getCijenaStartaVoznje());
            
            for (VoznjaTelefon voznjat : taksiSluzba.getVoznjet()
                    ) {
                        if (voznjat.getId() == id) {
                            voznjat.setStatus(Status.ZAVRSENA);
                            voznjat.setCijena(cijena);
                            voznjat.setTrajanjeVoznje( trajanjeVoznje);
                            voznjat.setBrojPredjenihKilometara(brojPredjenihKilometara);
                        }
            }
            JOptionPane.showMessageDialog(new Frame(),
                    "Cijena vožnje je: " + cijena + " RSD",
                    null,
                    JOptionPane.INFORMATION_MESSAGE);

            setVisible(false);}
            catch (Exception exception){
                JOptionPane.showMessageDialog(new Frame(),
                        "Greška prilikom završavanje vožnje",
                        "Greška",
                        JOptionPane.WARNING_MESSAGE);
            }

        

	
			
		btnZavrsi.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnZavrsi.setBounds(262, 239, 160, 80);
		contentPane.add(btnZavrsi);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnClose.setBounds(575, 10, 85, 35);
		contentPane.add(btnClose);
		
		JLabel lblCijena = new JLabel("Cijena:");
		lblCijena.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCijena.setBounds(24, 156, 160, 35);
		contentPane.add(lblCijena);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(218, 156, 350, 35);
		contentPane.add(textField_2);
	

}}