package korisnici;

public abstract class Osoba {
    protected long id;
    protected String korisnickoIme;
    protected String lozinka;
    protected String ime;
    protected String prezime;
    protected String jmbg;
    protected String adresa;
    protected Pol pol;
    protected String brojTelefona;
    protected boolean obrisan;

    public Osoba() {
        this.id = 0;
        this.korisnickoIme = "";
        this.lozinka = "";
        this.ime = "";
        this.prezime = "";
        this.jmbg = "";
        this.adresa = "";
        this.pol = Pol.ZENSKI;
        this.brojTelefona = "";
        this.obrisan = false;
    }

    public Osoba(long id,
                 String korisnickoIme,
                 String lozinka,
                 String ime,
                 String prezime,
                 String jmbg,
                 String adresa,
                 Pol pol,
                 String brojTelefona,
                 boolean obrisan)
    {
        super();
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
        this.pol = pol;
        this.brojTelefona = brojTelefona;
        this.obrisan = obrisan;
    }
    public long getId () {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnicko_ime(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
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

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
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
                + "\nkorisnicko ime: " + korisnickoIme
                + "\nlozinka: " + lozinka
                + "\nime: " + ime
                + "\nprezime: " + prezime
                + "\nJMBG: " + jmbg
                + "\nadresa: " + adresa
                + "\npol: " + pol
                + "\nbroj telefona: " + brojTelefona
                + "\nObrisan: " + obrisan;
    }
}
