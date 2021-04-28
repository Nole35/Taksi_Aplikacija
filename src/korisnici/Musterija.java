package korisnici;

import voznje.Voznja;

import java.util.ArrayList;


public class Musterija extends Osoba {
    private ArrayList<Voznja> voznje;

    public Musterija() {
        this.voznje = new ArrayList<Voznja>();
    }

    public Musterija(long id, String korisnicko_ime, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol, String broj_telefona, boolean obrisan,
                ArrayList<Voznja> voznje) {
        super(id, korisnicko_ime,lozinka,ime,prezime,jmbg,adresa,pol,broj_telefona,obrisan);
        this.voznje = voznje;
    }

    public ArrayList<Voznja> getVoznje() {
        return voznje;
    }

    public void setVoznje(ArrayList<Voznja> voznje) {
        this.voznje = voznje;
    }




}
