package korisnici;


import enumi.Pol;
import vozila.Automobil;
import voznje.Voznja;

import java.util.ArrayList;

public class Vozaci extends Osoba {
    private double plata;
    private int brojClanskeKarte;
    public ArrayList<Voznja> voznje;
    private Automobil automobil ;

    public Vozaci() {
        this.plata = 0;
        this.brojClanskeKarte = 0;
        this.voznje = new ArrayList<Voznja>();
    }
    public Vozaci(long id, String korisnickoIme, String lozinka,
                  String ime, String prezime, String jmbg, String adresa,
                  Pol pol, String brojTelefona, boolean obrisan,
                  double plata, int brojClanskeKarte) {
        super(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, obrisan);
        this.plata = plata;
        this.brojClanskeKarte = brojClanskeKarte;

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

    public ArrayList<Voznja> getVoznja() {
        return voznje;
    }

    public void setVoznje(ArrayList<Voznja> voznje) {
        this.voznje = voznje;
    }
    @Override
    public String toString() {
        String s = "Vozaci " + super.toString() +
                "\nPlata: " + this.plata +
                "\nBroj clanske karte: " + this.brojClanskeKarte;
      
        return s;
    }
}
