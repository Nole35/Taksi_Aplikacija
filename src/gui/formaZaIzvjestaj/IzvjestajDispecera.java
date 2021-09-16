package gui.formaZaIzvjestaj;

import kolekcije.DoubleLinkedList;
import taksiSluzba.TaksiSluzba;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class IzvjestajDispecera extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public IzvjestajDispecera(TaksiSluzba taksiSluzba, String[] days) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unesite datum:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(62, 48, 147, 41);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(219, 62, 200, 19);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Kreiraj izvjestaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacija() == true) {

					String unosDatuma = textField.getText().trim();

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate parsiranjeUnesenogDatuma = LocalDate.parse(unosDatuma, formatter);

					for (int i = 0; i < days.length; i++) {
						days[i] = parsiranjeUnesenogDatuma.minusDays(days.length - i - 1).toString();
					}
					DoubleLinkedList<String> listaDana = new DoubleLinkedList<>();
					for (String x : days) {
						listaDana.add(x);
					}

					// UKUPAN BROJ VOZNJI KREIRANIH PUTEM TELEFONA
					DoubleLinkedList<String> listaVoznjiTelefon = taksiSluzba.sveZavrseneTelefon();
					int ukupanBrojVoznjiPrekoTelefona = 0;
					for(String y : listaDana){
						for(String x : listaVoznjiTelefon){
							if(y.equals(x)){
								ukupanBrojVoznjiPrekoTelefona++;
							}
						}
					}

					// UKUPAN BROJ VOZNJI KREIRANIH PUTEM APLIKACIJE
					DoubleLinkedList<String> listaVoznjiAplikacija = taksiSluzba.sveZavrseneAplikacija();
					int ukupanBrojVoznjiPrekoAplikacije = 0;
					for(String y : listaDana){
						for(String x : listaVoznjiAplikacija){
							if(y.equals(x)){
								ukupanBrojVoznjiPrekoAplikacije++;
							}
						}
					}

					// UKUPAN BROJ SVIH VOZNJI
					int ukupanBrojSvihVoznji = ukupanBrojVoznjiPrekoTelefona + ukupanBrojVoznjiPrekoAplikacije;


					// PRAVLJENJE NOVE LISTE BEZ DUPLIRANIH ID-EVA
					String datumiZaTelefon;
					String datumiZaAplikaciju;
					DoubleLinkedList<Integer> novaListaTelefoni = new DoubleLinkedList<>();
					DoubleLinkedList<Integer> novaListaAplikacija = new DoubleLinkedList<>();
					for(String y : listaDana){
						for(String x : listaVoznjiTelefon){
							if(y.equals(x)){
								datumiZaTelefon = x;
								DoubleLinkedList<Integer> listaIdevaTelefon = taksiSluzba.nadjiVoznjuNarucenuPrekoTelefonaPoDatumu(datumiZaTelefon);
								for(Integer q : listaIdevaTelefon) {
									novaListaTelefoni.add(q);
								}
							}
						}
						for(String q : listaVoznjiAplikacija){
							if(y.equals(q)){
								datumiZaAplikaciju = q;
								DoubleLinkedList<Integer> listaIdevaAplikacija = taksiSluzba.nadjiVoznjuNarucenuPrekoAplikacijePoDatumu(datumiZaAplikaciju);
								for(Integer g : listaIdevaAplikacija){
									novaListaAplikacija.add(g);
								}
							}
						}
					}
					// PROSECNO TRAJANJE VOZNJI
					double rezultatTelefoni;
					double sumaTrajanjaVoznjeTelefoni = 0;
					Set<Integer> listaBezDupliranihIDevaTelefon = findDuplicatesIntegers(novaListaTelefoni);
					for(Integer idKojiTrebaPronaci : listaBezDupliranihIDevaTelefon){
						rezultatTelefoni = taksiSluzba.ukupnoTrajanjeVoznjiTelefoni(idKojiTrebaPronaci);
						sumaTrajanjaVoznjeTelefoni += rezultatTelefoni;
					}
					double rezultatAplikacija;
					double sumaTrajanjaVoznjeAplikacija = 0;
					Set<Integer> listaBezDupliranihIDevaAplikacija = findDuplicatesIntegers(novaListaAplikacija);
					for(Integer idKojiTrebaPronaci : listaBezDupliranihIDevaAplikacija){
						rezultatAplikacija = taksiSluzba.ukupnoTrajanjeVoznjiAplikacija(idKojiTrebaPronaci);
						sumaTrajanjaVoznjeAplikacija += rezultatAplikacija;
					}
					double ukupnoTrajanjeVoznjiTelefonIaplikacija = sumaTrajanjaVoznjeTelefoni + sumaTrajanjaVoznjeAplikacija;
					double averageDoubleTrajanje = ukupnoTrajanjeVoznjiTelefonIaplikacija / ukupanBrojSvihVoznji;
					int prosecnoTrajanjeVoznje = (int) averageDoubleTrajanje;


					// PROSECNA KILOMETRAZA
					double rezultatTelefoni1;
					double sumaPredjenihKilometaraTelefoni = 0;
					for(Integer idKojiTrebaPronaci : listaBezDupliranihIDevaTelefon){
						rezultatTelefoni1 = taksiSluzba.ukupnaKilometrazaTelefoni(idKojiTrebaPronaci);
						sumaPredjenihKilometaraTelefoni += rezultatTelefoni1;
					}
					double rezultatAplikacija1;
					double sumaPredjenihKilometaraAplikacija = 0;
					for(Integer idKojiTrebaPronaci : listaBezDupliranihIDevaAplikacija){
						rezultatAplikacija1 = taksiSluzba.ukupnaKilometrazaAplikacija(idKojiTrebaPronaci);
						sumaPredjenihKilometaraAplikacija += rezultatAplikacija1;
					}
					double ukupnaKilometrazaTelefoniIaplikacija = sumaPredjenihKilometaraTelefoni + sumaPredjenihKilometaraAplikacija;
					double averageDoubleKM = ukupnaKilometrazaTelefoniIaplikacija / ukupanBrojSvihVoznji;
					int prosecnaKilometraza = (int) averageDoubleKM;


					// UKUPNA ZARADA ZA SVE VOZNJE
					double rezultatTelefoni2;
					double sumaZaradeTelefoni = 0;
					for(Integer idKojiTrebaPronaci : listaBezDupliranihIDevaTelefon){
						rezultatTelefoni2 = taksiSluzba.ukupnaZaradaTelefoni(idKojiTrebaPronaci);
						sumaZaradeTelefoni += rezultatTelefoni2;
					}
					double rezultatAplikacija2;
					double sumaZaradeAplikacija = 0;
					for(Integer idKojiTrebaPronaci : listaBezDupliranihIDevaAplikacija){
						rezultatAplikacija2 = taksiSluzba.ukupnaZaradaAplikacija(idKojiTrebaPronaci);
						sumaZaradeAplikacija += rezultatAplikacija2;
					}
					double ukupnaZaradaZaSveVoznjeDouble = sumaZaradeTelefoni + sumaZaradeAplikacija;
					int ukupnaZaradaZaSveVoznje = (int) ukupnaZaradaZaSveVoznjeDouble;

					// PROSECNA ZARADA PO VOZNJI

					int prosecnaZaradaPoVoznji = (int) (ukupnaZaradaZaSveVoznjeDouble / ukupanBrojSvihVoznji);


					// UKUPAN BROJ AKTIVNIH VOZACA
					DoubleLinkedList<String> novaListaVozaca = new DoubleLinkedList<>();
					for(Integer idKojiTrebaPronaci : listaBezDupliranihIDevaTelefon){
						DoubleLinkedList<String> listaSvihKorisnickihImenaVozaca = taksiSluzba.listaKorisnickihImenaVozaca(idKojiTrebaPronaci);
						for(String f : listaSvihKorisnickihImenaVozaca){
							novaListaVozaca.add(f);
						}
					}
					Set<String> listaBezDupliranihVozaca = findDuplicatesStrings(novaListaVozaca);
					int count = 0;
					for(String s : listaBezDupliranihVozaca){
						count++;
					}
					int ukupanBrojAktivnihVozaca = count;

					if(ukupanBrojSvihVoznji == 0){
						JOptionPane.showMessageDialog(null, "Nazalost, za uneti datum, nema voznji.", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
					}else {
						ProzorZaPrikazIzvestaja prozorZaPrikazDnevnogIzvestaja = new ProzorZaPrikazIzvestaja(ukupanBrojSvihVoznji, ukupanBrojVoznjiPrekoAplikacije, ukupanBrojVoznjiPrekoTelefona, prosecnoTrajanjeVoznje, prosecnaKilometraza, ukupnaZaradaZaSveVoznje, prosecnaZaradaPoVoznji, ukupanBrojAktivnihVozaca);
						prozorZaPrikazDnevnogIzvestaja.setVisible(true);
					}

				}
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton.setBounds(24, 121, 162, 41);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnClose.setBounds(388, 121, 162, 41);
		contentPane.add(btnClose);
	}
	public boolean validacija() {

		boolean ok = true;
		String obavestenjeZaGresku = "Napravili ste neke greske pri unosu, molimo vas ispravite! \n";

		if (textField.getText().equals("")) {
			obavestenjeZaGresku += "\nMorate uneti datum! \n";
			ok = false;
		}

		if (ok == false) {
			JOptionPane.showMessageDialog(null, obavestenjeZaGresku, "Neispravni podaci!", JOptionPane.WARNING_MESSAGE);
		}

		return ok;
	}

	private Set<Integer> findDuplicatesIntegers(DoubleLinkedList<Integer> list){
		Set<Integer> items = new HashSet<Integer>();
		Set<Integer> duplicates = new HashSet<Integer>();
		for (Integer item : list) {
			if (items.contains(item)) {
				duplicates.remove(item);
			} else {
				items.add(item);
			}
		}
		return items;
	}
	private Set<String> findDuplicatesStrings(DoubleLinkedList<String> list){
		Set<String> items = new HashSet<String>();
		Set<String> duplicates = new HashSet<String>();
		for (String item : list) {
			if (items.contains(item)) {
				duplicates.remove(item);
			} else {
				items.add(item);
			}
		}
		return items;
	}

}
