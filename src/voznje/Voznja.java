package voznje;

import enumi.Status;
import korisnici.Musterija;
import korisnici.Vozaci;

import java.time.LocalDateTime;


public abstract class Voznja {
    protected long id;
    protected LocalDateTime datumIVremePoruzbine;
    protected String adresaPolaska;
    protected String adresaDestinacije;
    protected long musterijaId;
    protected Musterija musterija;
    protected long vozacId;
    protected Vozaci vozac;
    protected int brojPredjenihKilometara;
    protected LocalDateTime trajanjeVoznje;
    protected Status status;

    public Voznja (){
        this.id = 0;
        this.datumIVremePoruzbine = null;
        this.adresaPolaska = "";
        this.adresaDestinacije = "";
        this.musterijaId = 0;
        this.vozacId = 0;
        this.brojPredjenihKilometara = 0;
        this.trajanjeVoznje = null;
        this.status = Status.KREIRANA;

    }



    public Voznja(long id,
                  LocalDateTime datumIVremePoruzbine,
                  String adresaPolaska,
                  String adresaDestinacije,
                  long musterijaId,
                  Musterija musterija,
                  long vozacId,
                  Vozaci vozac,
                  int brojPredjenihKilometara,
                  LocalDateTime trajanjeVoznje,
                  Status status)
    {
        this.id = id;
        this.datumIVremePoruzbine = datumIVremePoruzbine;
        this.adresaPolaska = adresaPolaska;
        this.adresaDestinacije = adresaDestinacije;
        this.musterijaId = musterijaId;
        this.musterija = musterija;
        this.vozacId = vozacId;
        this.vozac = vozac;
        this.brojPredjenihKilometara = brojPredjenihKilometara;
        this.trajanjeVoznje = trajanjeVoznje;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDatumIVremePoruzbine() {
        return datumIVremePoruzbine;
    }

    public void setDatumIVremePoruzbine(LocalDateTime datumIVremePoruzbine) {
        this.datumIVremePoruzbine = datumIVremePoruzbine;
    }
    public String getAdresaPolaska() {
        return adresaPolaska;
    }

    public void setAdresaPolaska(String adresaPolaska) {
        this.adresaPolaska = adresaPolaska;
    }

    public String getAdresaDestinacije() {
        return adresaDestinacije;
    }

    public void setAdresaDestinacije(String adresaDestinacije) {
        this.adresaDestinacije = adresaDestinacije;
    }

    public long getMusterijaId() {
        return musterijaId;
    }

    public void setMusterija_id(long musterijaId) {
        this.musterijaId = musterijaId;
    }

    public Musterija getMusterija() {
        return musterija;
    }

    public void setMusterija(Musterija musterija) {
        this.musterija = musterija;
    }

    public long getVozacId() {
        return vozacId;
    }

    public void setVozacId(long vozacId) {
        this.vozacId = vozacId;
    }

    public Vozaci getVozac() {
        return vozac;
    }

    public void setVozac(Vozaci vozac) {
        this.vozac = vozac;
    }

    public int getBrojPredjenihKilometara() {
        return brojPredjenihKilometara;
    }

    public void setBrojPredjenihKilometara(int brojPredjenihKilometara) {
        this.brojPredjenihKilometara = brojPredjenihKilometara;
    }

    public LocalDateTime getTrajanjeVoznje() {
        return trajanjeVoznje;
    }

    public void setTrajanjeVoznje(LocalDateTime trajanjeVoznje) {
        this.trajanjeVoznje = trajanjeVoznje;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
