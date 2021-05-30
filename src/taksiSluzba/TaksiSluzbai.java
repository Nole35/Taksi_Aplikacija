package taksiSluzba;

public class TaksiSluzbai {
    private String pib;
    private String naziv;
    private String adresa;
    private double cijenaStartaVoznje;
    private double cijenaPoKilometru;

    public TaksiSluzbai() {
        this.pib = "";
        this.naziv = "";
        this.adresa = "";
        this.cijenaStartaVoznje = 0;
        this.cijenaPoKilometru = 0;
    }


    public TaksiSluzbai(String pib, String naziv, String adresa, double cijenaStartaVoznje, double cijenaPoKilometru) {
        this.pib = pib;
        this.naziv = naziv;
        this.adresa = adresa;
        this.cijenaStartaVoznje = cijenaStartaVoznje;
        this.cijenaPoKilometru = cijenaPoKilometru;



    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public double getCijenaStartaVoznje() {
        return cijenaStartaVoznje;
    }

    public void setCijenaStartaVoznje(double cijenaStartaVoznje) {
        this.cijenaStartaVoznje = cijenaStartaVoznje;
    }

    public double getCijenaPoKilometru() {
        return cijenaPoKilometru;
    }

    public void setCijenaPoKilometru(double cijenaPoKilometru) {
        this.cijenaPoKilometru = cijenaPoKilometru;
    }

}
