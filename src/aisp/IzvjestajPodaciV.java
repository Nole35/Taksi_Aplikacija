package aisp;

public class IzvjestajPodaciV {
	 private int vozacID;
	 private int ukupanBrojVoznji;
     private double duzina;
     private double vrijeme;
	 private double prosjecnaDuzina;
     private double prosjecnoVrijeme;
     private double zarada;
     private double prosjecnaZarada;

     
     public IzvjestajPodaciV(int vozacID, int ukupanBrojVoznji, double duzina, double vrijeme, double prosjecnaDuzina, double prosjecnoVreme, double zarada, double prosjecnaZarada) {


}

    public IzvjestajPodaciV(int vozacID, int ukupanBrojVoznji, double duzina, double vrijeme, double prosjecnaDuzina, double prosjecnoVrijeme) {
        this.vozacID = vozacID;
        this.ukupanBrojVoznji = ukupanBrojVoznji;
        this.duzina = duzina;
        this.vrijeme = vrijeme;
        this.prosjecnaDuzina = prosjecnaDuzina;
        this.prosjecnoVrijeme = prosjecnoVrijeme;
        this.zarada = zarada;
        this.prosjecnaZarada = prosjecnaZarada;

    }

    public int getVozacID() {
        return vozacID;
    }

    public void setVozacID(int vozacID) {
        this.vozacID = vozacID;
    }

    public int getUkupanBrojVoznji() {
        return ukupanBrojVoznji;
    }

    public void setUkupanBrojVoznji(int ukupanBrojVoznji) {
        this.ukupanBrojVoznji = ukupanBrojVoznji;
    }

    public double getDuzina() {
        return duzina;
    }

    public void setDuzina(double duzina) {
        this.duzina = duzina;
    }

    public double getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(double vrijeme) {
        this.vrijeme = vrijeme;
    }

    public double getProsjecnaDuzina() {
        return prosjecnaDuzina;
    }

    public void setProsjecnaDuzina(double prosjecnaDuzina) {
        this.prosjecnaDuzina = prosjecnaDuzina;
    }

    public double getProsjecnoVrijeme() {
        return prosjecnoVrijeme;
    }

    public void setProsjecnoVrijeme(double prosjecnoVrijeme) {
        this.prosjecnoVrijeme = prosjecnoVrijeme;
    }

    public double getZarada() {
        return zarada;
    }

    public void setZarada(double zarada) {
        this.zarada = zarada;
    }

    public double getProsjecnaZarada() {
        return prosjecnaZarada;
    }

    public void setProsjecnaZarada(double prosjecnaZarada) {
        this.prosjecnaZarada = prosjecnaZarada;
    }
}
