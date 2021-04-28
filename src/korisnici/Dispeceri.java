package korisnici;

import enumi.TelefonskaOdeljenja;

public class Dispeceri extends Osoba {
    private double plata;
    private String br_tel_linije;
    private TelefonskaOdeljenja telefonskaOdeljenja;

    public Dispeceri() {
        super();
        this.plata =0;
        this.br_tel_linije =" ";
        this.telefonskaOdeljenja = TelefonskaOdeljenja.ODELJENJE_ZA_PRIJEM_VOZNJI;
    }

    public Dispeceri(long id, String korisnicko_ime, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol, String broj_telefona, boolean obrisan, double plata, String br_tel_linije, TelefonskaOdeljenja telefonskaOdeljenja) {
        super(id, korisnicko_ime, lozinka, ime, prezime, jmbg, adresa, pol, broj_telefona, obrisan);
        this.plata = plata;
        this.br_tel_linije = br_tel_linije;
        this.telefonskaOdeljenja = telefonskaOdeljenja;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public String getBr_tel_linije() {
        return br_tel_linije;
    }

    public void setBr_tel_linije(String br_tel_linije) {
        this.br_tel_linije = br_tel_linije;
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
                "\nBroj telefonske linije: " + this.br_tel_linije +
                "\nTelefonsko odeljenje: " + this.telefonskaOdeljenja;
    }


}





