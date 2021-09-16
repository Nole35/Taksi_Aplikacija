package gui.formaZaIzvjestaj;

import kolekcije.DoubleLinkedList;
import korisnici.Vozaci;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import voznje.VoznjaAplikacija;
import voznje.VoznjaTelefon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IzvjestajVozac extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public IzvjestajVozac(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai, Vozaci vozac) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Unesite datum:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(63, 105, 147, 41);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(220, 119, 200, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Kreiraj izvjestaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacija()==true){
					String datum1 = textField.getText().trim();
					boolean voznje = taksiSluzba.nadjiDatum(datum1);





					if (voznje == false) {
						JOptionPane.showMessageDialog(null, "Nazalost, za uneti datum, nema voznji.", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
					} else {

						String uneseniDatum = textField.getText().trim();
						String[] nizDatum = uneseniDatum.split("-");
						int uneseniDan = Integer.parseInt(nizDatum[2]);
						int uneseniMesec = Integer.parseInt(nizDatum[1]);
						int unesenaGodina = Integer.parseInt(nizDatum[0]);

						DoubleLinkedList<Vozaci> vozaci = taksiSluzba.sviNeobrisaniVozaci();
						DoubleLinkedList<VoznjaAplikacija> voznjaAplikacije = taksiSluzba.sveZavrseneAplikacija1();
						DoubleLinkedList<VoznjaTelefon> voznjaTelefon = taksiSluzba.sveZavrseneTelefon1();
						DoubleLinkedList<IzvestajVozacaPodaci> tests = new DoubleLinkedList<>();


						for (Vozaci v : vozaci) {
							int idVozaca = (int) v.getId();
							int ukupnoVoznji = 0;
							double ukupnoKilometara = 0;
							double ukupnoTrajanje = 0;
							double prosekKilometara = 0;
							double prosekTrajanja = 0;
							double prosecnoBezVoznje = 0;
							double ukupnaZarada = 0;
							double prosecnaZarada = 0;

							for (VoznjaAplikacija x : voznjaAplikacije) {
								if (x.getVozacId() == idVozaca) {
									LocalDateTime datum = x.getDatumIVremePoruzbine();
									int dan = datum.getDayOfMonth();
									int mesec = datum.getMonthValue();
									int godina = datum.getYear();
									if (dan == uneseniDan && mesec == uneseniMesec && godina == unesenaGodina ){
										ukupnoVoznji++;
										ukupnoKilometara+= x.getBrojPredjenihKilometara();
										ukupnoTrajanje+= x.getTrajanjeVoznje();
										ukupnaZarada+= x.getCijena();
									}
								}
							}

							for (VoznjaTelefon x : voznjaTelefon) {
								if (x.getVozacId() == idVozaca) {
									LocalDateTime datum = x.getDatumIVremePoruzbine();
									int dan = datum.getDayOfMonth();
									int mesec = datum.getMonthValue();
									int godina = datum.getYear();
									if (dan == uneseniDan && mesec == uneseniMesec && godina == unesenaGodina ){
										ukupnoVoznji++;
										ukupnoKilometara+= x.getBrojPredjenihKilometara();
										ukupnoTrajanje+= x.getTrajanjeVoznje();
										ukupnaZarada+= x.getCijena();
									}
								}
							}

							if (ukupnoVoznji > 0) {
								prosekKilometara = ukupnoKilometara / ukupnoVoznji;
								prosekTrajanja = ukupnoTrajanje / ukupnoVoznji;
								prosecnaZarada = ukupnaZarada / ukupnoVoznji;
								//todo
								prosecnoBezVoznje = (480 - ukupnoTrajanje) / 60;
							}


							IzvestajVozacaPodaci proba = new IzvestajVozacaPodaci(idVozaca,ukupnoVoznji,ukupnoKilometara,ukupnoTrajanje,prosekKilometara,prosekTrajanja,ukupnaZarada,prosecnaZarada);
							if(ukupnoVoznji!=0) {
								tests.add(proba);
							}

						}
						TabelaPrikaz tabelaPrikaz = new TabelaPrikaz(tests); // napraviti
						tabelaPrikaz.setVisible(true);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton.setBounds(25, 178, 162, 41);
		contentPane.add(btnNewButton);

		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnClose.setBounds(389, 178, 162, 41);
		contentPane.add(btnClose);
	}
	private boolean validacija(){
		boolean ok = true;
		String obavvjestenje = "napravili ste gresku\n";
		if (textField.getText().equals("")){
			obavvjestenje += "morate unijeti datum\n";
			ok = false;
		}
		if (ok == false){
			JOptionPane.showMessageDialog(null, obavvjestenje,"neispravan datum",JOptionPane.WARNING_MESSAGE);
		}
		return  ok;
	}
}
