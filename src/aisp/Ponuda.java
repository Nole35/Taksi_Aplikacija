package aisp;

import korisnici.Vozaci;

public class Ponuda {
    private int idVoznje;
    private int idVozaca;
    private String korisnickoImeVozaca;
    private double prosjecnaOcjenaVozaca;
    private int brojVoznjiVozaca;
    private int vrijemeDolaska;
    private double ocjenaPonude;
    private Vozaci vozac;


    public Vozaci getVozac() {
        return vozac;
    }

    public void setVozac(Vozaci vozac) {
        this.vozac = vozac;
    }

    public double getOcjenaPonude() {
        return ocjenaPonude;
    }

    public void setOcjenaPonude(double ocjenaPonude) {
        this.ocjenaPonude = ocjenaPonude;
    }

    public int getIdVoznje() {
        return idVoznje;
    }

    public void setIdVoznje(int idVoznje) {
        this.idVoznje = idVoznje;
    }

    public int getIdVozaca() {
        return idVozaca;
    }

    public void setIdVozaca(int idVozaca) {
        this.idVozaca = idVozaca;
    }

    public String getKorisnickoImeVozaca() {
        return korisnickoImeVozaca;
    }

    public void setKorisnickoImeVozaca(String korisnickoImeVozaca) {
        this.korisnickoImeVozaca = korisnickoImeVozaca;
    }

    public double getProsjecnaOcjenaVozaca() {
        return prosjecnaOcjenaVozaca;
    }

    public void setProsjecnaOcjenaVozaca(double prosjecnaOcjenaVozaca) {
        this.prosjecnaOcjenaVozaca = prosjecnaOcjenaVozaca;
    }

    public int getBrojVoznjiVozaca() {
        return brojVoznjiVozaca;
    }

    public void setBrojVoznjiVozaca(int brojVoznjiVozaca) {
        this.brojVoznjiVozaca = brojVoznjiVozaca;
    }

    public int getVrijemeDolaska() {
        return vrijemeDolaska;
    }

    public void setVrijemeDolaska(int vrijemeDolaska) {
        this.vrijemeDolaska = vrijemeDolaska;
    }

    public Ponuda(
            int idVoznje,
            int idVozaca,
            String korisnickoImeVozaca,
            double prosjecnaOcjenaVozaca,
            int brojVoznjiVozaca,
            double ocjenaPonude){
        this.idVoznje = idVoznje;
        this.idVozaca = idVozaca;
        this.korisnickoImeVozaca = korisnickoImeVozaca;
        this.brojVoznjiVozaca = brojVoznjiVozaca;
        this.vrijemeDolaska = vrijemeDolaska;
        this.prosjecnaOcjenaVozaca = prosjecnaOcjenaVozaca;
        this.ocjenaPonude = (double) (izracunajOcjenuBrojVoznji(this.brojVoznjiVozaca) + (2 * izracunajOcjenuVrijeme(this.vrijemeDolaska)) + prosjecnaOcjenaVozaca);
        System.out.println("OCJENA PONUDE " + this.ocjenaPonude);

    }

    public double izracunajOcjenuVrijeme(int vrijeme){
        return (double) 1/vrijeme;
    }

    public double izracunajOcjenuBrojVoznji(int brojVoznjiVozaca){
        return (double) ( 1 / 2 ) * ( (double) 1 / brojVoznjiVozaca );
    }

    @Override
    public String toString() {
        return idVoznje + "|" +
                idVozaca + "|" +
                korisnickoImeVozaca + "|" +
                prosjecnaOcjenaVozaca + "|" +
                brojVoznjiVozaca + "|" +
                vrijemeDolaska + "\n";
    }

}
