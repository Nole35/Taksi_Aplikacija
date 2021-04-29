package korisnici;

import enumi.Pol;
import enumi.TelefonskaOdeljenja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Dispeceri extends Osoba {
    private double plata;
    private String brTelLinije;
    private TelefonskaOdeljenja telefonskaOdeljenja;

    public Dispeceri() {

        this.plata =0;
        this.brTelLinije =" ";
        this.telefonskaOdeljenja = TelefonskaOdeljenja.ODELJENJE_ZA_PRIJEM_VOZNJI;
    }

    public Dispeceri(long id, String korisnickoIme, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol, String brojTelefona, boolean obrisan, double plata, String brTelLinije, TelefonskaOdeljenja telefonskaOdeljenja) {
        super(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, obrisan);
        this.plata = plata;
        this.brTelLinije = brTelLinije;
        this.telefonskaOdeljenja = telefonskaOdeljenja;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public String getBrTelLinije() {
        return brTelLinije;
    }

    public void setBrTelLinije(String brTelLinije) {
        this.brTelLinije = brTelLinije;
    }

    public TelefonskaOdeljenja getTelefonskaOdeljenja() {
        return telefonskaOdeljenja;
    }

    public void setTelefonskaOdeljenja(TelefonskaOdeljenja telefonskaOdeljenja) {
        this.telefonskaOdeljenja = telefonskaOdeljenja;
    }
    @Override
    public String toString() {
        return "Dispeceri " + super.toString() +
                "\nPlata: " + this.plata +
                "\nBroj telefonske linije: " + this.brTelLinije +
                "\nTelefonsko odeljenje: " + this.telefonskaOdeljenja;
    }



}





