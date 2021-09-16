package korisnici;


import enumi.Pol;
import kolekcije.DoubleLinkedList;
import vozila.Automobil;
import voznje.Voznja;

import java.util.ArrayList;

public class Vozaci extends Osoba {
    private double plata;
    private int brojClanskeKarte;
    public DoubleLinkedList<Voznja> voznje;
    private Automobil automobil ;
    private double prosjecnaOcjena;

    public Vozaci() {
        this.plata = 0;
        this.brojClanskeKarte = 0;
        this.voznje = new DoubleLinkedList<>();
        this.prosjecnaOcjena = 0;
    }



    public Vozaci(long id, String korisnickoIme, String lozinka,
                  String ime, String prezime, String jmbg, String adresa,
                  Pol pol, String brojTelefona, boolean obrisan,
                  double plata, int brojClanskeKarte, double prosjecnaOcjena) {
        super(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, obrisan);
        this.plata = plata;
        this.brojClanskeKarte = brojClanskeKarte;
        this.prosjecnaOcjena = prosjecnaOcjena;

    }

    public void setAutomobili(Automobil automobil) {
        this.automobil = automobil;
    }

    public Automobil getAutomobil() {
        return automobil;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public int getBrojClanskeKarte() {
        return brojClanskeKarte;
    }

    public void setBrojClanskeKarte(int brojClanskeKarte) {
        this.brojClanskeKarte = brojClanskeKarte;
    }

    public DoubleLinkedList<Voznja> getVoznja() {
        return voznje;
    }

    public void setVoznje(DoubleLinkedList<Voznja> voznje) {
        this.voznje = voznje;
    }

    public double getProsjecnaOcjena() {
        return prosjecnaOcjena;
    }

    public void setProsjecnaOcjena(double prosjecnaOcjena) {
        this.prosjecnaOcjena = prosjecnaOcjena;
    }

    @Override
    public String toString() {
        String s = "Vozaci " + super.toString() +
                "\nPlata: " + this.plata +
                "\nBroj clanske karte: " + this.brojClanskeKarte;
      
        return s;
    }
}
