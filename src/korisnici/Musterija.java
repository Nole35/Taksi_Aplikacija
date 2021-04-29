package korisnici;

import enumi.Pol;
import voznje.Voznja;

import java.util.ArrayList;


public class Musterija extends Osoba {
    private ArrayList<Voznja> voznje;

    public Musterija() {
        this.voznje = new ArrayList<Voznja>();
    }

    public Musterija(long id, String korisnickoIme, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol, String brojTelefona, boolean obrisan
                     ) {
        super(id, korisnickoIme,lozinka,ime,prezime,jmbg,adresa,pol,brojTelefona,obrisan);

    }

    public ArrayList<Voznja> getVoznje() {
        return voznje;
    }

    public void setVoznje(ArrayList<Voznja> voznje) {
        this.voznje = voznje;
    }




}
