package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kolekcije.DoubleLinkedList;
import korisnici.Vozaci;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import voznje.Voznja;
import voznje.VoznjaAplikacija;
import voznje.VoznjaTelefon;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzvjestajVoznjiVozac extends JFrame {

	private JPanel contentPane;


	public IzvjestajVoznjiVozac(DoubleLinkedList<Voznja> VoznjaAplikacija) {
		setTitle("Izvjestaj voznji vozaca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 double trajanje = 0;
	        double duzina = 0;
	        int ukupanBroj = 0;
	        int aplikacija = 0;
	        int telefon = 0;
	        int ukZarada = 0;
	        double prosTrajanje = 0;
	        double prosDuzina = 0;
	        double ukupnoKilometara = 0;
	        double ukupnoVremena = 0;
	        

            for (
        Voznja voznja : VoznjaAplikacija
                 ) {
            	ukupanBroj++;
            	
            	if (voznja instanceof VoznjaAplikacija){
                    aplikacija++;
            }else if (voznja instanceof VoznjaTelefon){
                telefon++;
            }
            	 trajanje += voznja.getTrajanjeVoznje();
                 duzina += voznja.getBrojPredjenihKilometara();

                 ukZarada += voznja.getCijena();
                 ukupnoKilometara += voznja.getBrojPredjenihKilometara();
                 ukupnoVremena += voznja.getTrajanjeVoznje();



             }
            
            prosTrajanje = trajanje / VoznjaAplikacija.size();
            prosDuzina = duzina / VoznjaAplikacija.size();
            
            
       
            
          
         

		
		JLabel lblNewLabel = new JLabel("Ukupan broj voznji:");
		lblNewLabel.setBounds(20, 10, 180, 40);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setText(String.valueOf(ukupanBroj));
		contentPane.add(lblNewLabel);
		
		JLabel lblBrojVoznjiPorucenih = new JLabel("Broj voznji porucenih aplikacijom:");
		lblBrojVoznjiPorucenih.setBounds(20, 76, 274, 40);
		lblBrojVoznjiPorucenih.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih.setText(String.valueOf(aplikacija));
		contentPane.add(lblBrojVoznjiPorucenih);
		
		JLabel lblBrojVoznjiPorucenih_2 = new JLabel("Broj voznji porucenih telefonom:");
		lblBrojVoznjiPorucenih_2.setBounds(20, 143, 274, 40);
		lblBrojVoznjiPorucenih_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2.setText(String.valueOf(telefon));
		contentPane.add(lblBrojVoznjiPorucenih_2);
		
		JLabel lblBrojVoznjiPorucenih_2_1 = new JLabel("Prosjecno trajanje voznje:");
		lblBrojVoznjiPorucenih_2_1.setBounds(20, 215, 274, 40);
		lblBrojVoznjiPorucenih_2_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1.setText(String.valueOf(prosTrajanje));
		
		contentPane.add(lblBrojVoznjiPorucenih_2_1);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1 = new JLabel("Prosjecna duzina voznje:");
		lblBrojVoznjiPorucenih_2_1_1.setBounds(20, 275, 274, 40);
		lblBrojVoznjiPorucenih_2_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1.setText(String.valueOf(prosDuzina));
		contentPane.add(lblBrojVoznjiPorucenih_2_1_1);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1_1 = new JLabel("Ukupna zarada:");
		lblBrojVoznjiPorucenih_2_1_1_1.setBounds(20, 325, 274, 40);
		lblBrojVoznjiPorucenih_2_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1_1.setText(String.valueOf(ukZarada));
		contentPane.add(lblBrojVoznjiPorucenih_2_1_1_1);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1_1_1 = new JLabel("Ukupno predjenih kilometara:");
		lblBrojVoznjiPorucenih_2_1_1_1_1.setBounds(20, 390, 274, 40);
		lblBrojVoznjiPorucenih_2_1_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1_1_1.setText(String.valueOf(ukupnoKilometara));

		contentPane.add(lblBrojVoznjiPorucenih_2_1_1_1_1);
		
		JButton btnNewButton = new JButton("Stampaj");
		btnNewButton.setBounds(20, 513, 120, 40);
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(268, 513, 120, 40);
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 18));
		contentPane.add(btnClose);
		
		JLabel lblBrojVoznjiPorucenih_2_1_1_1_1_1 = new JLabel("Ukupno vremena u voznji:");
		lblBrojVoznjiPorucenih_2_1_1_1_1_1.setBounds(20, 453, 274, 40);
		lblBrojVoznjiPorucenih_2_1_1_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBrojVoznjiPorucenih_2_1_1_1_1_1.setText(String.valueOf(ukupnoVremena));

		contentPane.add(lblBrojVoznjiPorucenih_2_1_1_1_1_1);
	}

}
