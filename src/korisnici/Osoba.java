package korisnici;

public abstract class Osoba {
    protected long id;
    protected String korisnicko_ime;
    protected String lozinka;
    protected String ime;
    protected String prezime;
    protected String jmbg;
    protected String adresa;
    protected Pol pol;
    protected String broj_telefona;
    protected boolean obrisan;

    public Osoba() {
        this.id = 0;
        this.korisnicko_ime = "";
        this.lozinka = "";
        this.ime = "";
        this.prezime = "";
        this.jmbg = "";
        this.adresa = "";
        this.pol = Pol.ZENSKI;
        this.broj_telefona = "";
        this.obrisan = false;
    }

    public Osoba(long id, String korisnicko_ime, String lozinka, String ime, String prezime, String jmbg, String adresa, Pol pol, String broj_telefona, boolean obrisan) {
        super();
        this.id = id;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
        this.pol = pol;
        this.broj_telefona = broj_telefona;
        this.obrisan = obrisan;
    }
    public long getId () {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public String getBroj_telefona() {
        return broj_telefona;
    }

    public void setBroj_telefona(String broj_telefona) {
        this.broj_telefona = broj_telefona;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }


    @Override
    public String toString() {
        return "\n id" + id
                + "\nkorisnicko ime: " + korisnicko_ime
                + "\nlozinka: " + lozinka
                + "\nime: " + ime
                + "\nprezime: " + prezime
                + "\nJMBG: " + jmbg
                + "\nadresa: " + adresa
                + "\npol: " + pol
                + "\nbroj telefona: " + broj_telefona
                + "\nObrisan: " + obrisan;
    }
}
