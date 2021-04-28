package korisnici;


import vozila.Automobil;
import voznje.Voznja;

import java.util.ArrayList;

public class Vozaci extends Osoba {
    private double plata;
    private int broj_clanske_karte;
    private ArrayList<Voznja> voznje;
    private Automobil automobil = null;

    public Vozaci() {
        this.plata = 0;
        this.broj_clanske_karte = 0;
        this.voznje = new ArrayList<Voznja>();
    }
    public Vozaci(long id, String korisnicko_ime, String lozinka, String ime, String prezime,String jmbg, String adresa, Pol pol, String broj_telefona, boolean obrisan, double plata, int broj_clanske_karte, ArrayList<Vozaci> vozaci) {
        super(id, korisnicko_ime, lozinka, ime, prezime, jmbg, adresa, pol, broj_telefona, obrisan);
        this.plata = plata;
        this.broj_clanske_karte = broj_clanske_karte;
        this.voznje = voznje;
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

    public int getBroj_clanske_karte() {
        return broj_clanske_karte;
    }

    public void setBroj_clanske_karte(int broj_clanske_karte) {
        this.broj_clanske_karte = broj_clanske_karte;
    }

    public ArrayList<Voznja> getVoznja() {
        return voznje;
    }

    public void setVozaci(ArrayList<Voznja> voznje) {
        this.voznje = voznje;
    }
    @Override
    public String toString() {
        String s = "Vozaci " + super.toString() +
                "\nPlata: " + this.plata +
                "\nBroj clanske karte: " + this.broj_clanske_karte;
        for (Voznja voznje : voznje) {
            s += "\n" + voznje;
        }
        return s;
    }
}
