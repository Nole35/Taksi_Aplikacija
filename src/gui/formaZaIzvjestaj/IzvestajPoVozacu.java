package gui.formaZaIzvjestaj;

import kolekcije.DoubleLinkedList;
import korisnici.Vozaci;
import taksiSluzba.TaksiSluzba;
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

public class IzvestajPoVozacu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public TaksiSluzba taksiSluzba;
	private int trazeniVozacID;

	public IzvestajPoVozacu(TaksiSluzba taksiSluzba, long VozacID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unesite datum:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(65, 103, 147, 41);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(222, 117, 200, 19);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Kreiraj izvjestaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validacija() == true) {
					String unosDatuma = textField.getText().trim();
					boolean voznje = taksiSluzba.nadjiDatum(unosDatuma);

					if (voznje == false) {
						JOptionPane.showMessageDialog(null, "Nazalost, za uneti datum, nema voznji.", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
					} else {
						String uneseniDatum = textField.getText().trim();
						String[] nizDatum = uneseniDatum.split("-");
						int uneseniDan = Integer.parseInt(nizDatum[2]);
						int uneseniMesec = Integer.parseInt(nizDatum[1]);
						int unesenaGodina = Integer.parseInt(nizDatum[0]);

						DoubleLinkedList<VoznjaAplikacija> voznjaAplikacije = taksiSluzba.sveZavrseneAplikacija1();
						DoubleLinkedList<VoznjaTelefon> voznjaTelefon = taksiSluzba.sveZavrseneTelefon1();

						int ukupnoVoznji = 0;
						double ukupnoKilometara = 0;
						double ukupnoTrajanje = 0;
						double prosekKilometara = 0;
						double prosekTrajanja = 0;
						double ukupnaZarada = 0;
						double prosecnaZarada = 0;

						for (VoznjaAplikacija voznja : taksiSluzba.getVoznje()) {

							int vozacID = (int) voznja.getVozacId();
							if (voznja.getVozac().getId() == (vozacID)) {
								LocalDateTime datum = voznja.getDatumIVremePoruzbine();
								int dan = datum.getDayOfMonth();
								int mesec = datum.getMonthValue();
								int godina = datum.getYear();
								if (dan == uneseniDan && mesec == uneseniMesec && godina == unesenaGodina) {
									ukupnoVoznji++;
									ukupnoKilometara += voznja.getBrojPredjenihKilometara();
									ukupnoTrajanje += voznja.getTrajanjeVoznje();
									ukupnaZarada += voznja.getCijena();
								}
							}
						}
						for (VoznjaTelefon voznjet : taksiSluzba.getVoznjet()) {

							long vozacID =  voznjet.getVozacId();
							if (voznjet.getVozac().getId() == (vozacID)) {
								LocalDateTime datum = voznjet.getDatumIVremePoruzbine();
								int dan = datum.getDayOfMonth();
								int mesec = datum.getMonthValue();
								int godina = datum.getYear();
								if (dan == uneseniDan && mesec == uneseniMesec && godina == unesenaGodina) {
									ukupnoVoznji++;
									ukupnoKilometara += voznjet.getBrojPredjenihKilometara();
									ukupnoTrajanje += voznjet.getTrajanjeVoznje();
									ukupnaZarada += voznjet.getCijena();
								}


							}
						}
						if (ukupnoVoznji > 0) {
							prosekKilometara = ukupnoKilometara / ukupnoVoznji;
							prosekTrajanja = ukupnoTrajanje / ukupnoVoznji;
							prosecnaZarada = ukupnaZarada / ukupnoVoznji;

						}
						PrikazIzvestajaPoVozacu pip = new PrikazIzvestajaPoVozacu(ukupnoVoznji, ukupnoKilometara, ukupnoTrajanje, prosekKilometara, prosekTrajanja, ukupnaZarada, prosecnaZarada);
						pip.setVisible(true);

					}
				}
			}
		});
						;
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton.setBounds(27, 176, 162, 41);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnClose.setBounds(391, 176, 162, 41);
		contentPane.add(btnClose);
	}
	 public boolean validacija() {

	        boolean ok = true;
	        String obavestenjeZaGresku = "Napravili ste neke greske pri unosu, molimo vas ispravite! \n";
	        if(textField.getText().equals("")){
	            obavestenjeZaGresku += "\nMorate uneti datum! \n";
	            ok = false;
	        }
	        if (ok == false) {
	            JOptionPane.showMessageDialog(null, obavestenjeZaGresku, "Neispravni podaci!", JOptionPane.WARNING_MESSAGE);
	        }
	        return ok;
	    }
}
