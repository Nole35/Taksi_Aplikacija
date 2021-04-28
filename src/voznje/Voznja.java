package voznje;

import enumi.Status;
import korisnici.Musterija;
import korisnici.Vozaci;

import java.time.LocalDateTime;


public abstract class Voznja {
    private long id;
    private LocalDateTime datumIVremePoruzbine;
    private String adresaPolaska;
    private String adresaDestinacije;
    private long musterija_id;
    private Musterija musterija;
    private long vozac_id;
    private Vozaci vozac;
    private int broj_predjenih_kilometara;
    private LocalDateTime trajanje_voznje;
    private Status status;

    public Voznja (){
        this.id = 0;
        this.datum_i_vreme_poruzbine = null;
        this.adresaPolaska = "";
        this.adresa_destinacije = "";
        this.musterija_id = 0;
        this.vozac_id = 0;
        this.broj_predjenih_kilometara = 0;
        this.trajanje_voznje = null;
        this.status = Status.KREIRANA;

    }



    public Voznja(long id, LocalDateTime datum_i_vreme_poruzbine, String adresa_polaska, String adresa_destinacije, long musterija_id, Musterija musterija, long vozac_id, Vozaci vozac, int broj_predjenih_kilometara, LocalDateTime trajanje_voznje, Status status) {
        this.id = id;
        this.datum_i_vreme_poruzbine = datum_i_vreme_poruzbine;
        this.adresaPolaska = adresa_polaska;
        this.adresa_destinacije = adresa_destinacije;
        this.musterija_id = musterija_id;
        this.musterija = musterija;
        this.vozac_id = vozac_id;
        this.vozac = vozac;
        this.broj_predjenih_kilometara = broj_predjenih_kilometara;
        this.trajanje_voznje = trajanje_voznje;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDatum_i_vreme_poruzbine() {
        return datum_i_vreme_poruzbine;
    }

    public void setDatum_i_vreme_poruzbine(LocalDateTime datum_i_vreme_poruzbine) {
        this.datum_i_vreme_poruzbine = datum_i_vreme_poruzbine;
    }

    public String getAdresaPolaska() {
        return adresaPolaska;
    }

    public void setAdresaPolaska(String adresaPolaska) {
        this.adresaPolaska = adresaPolaska;
    }

    public String getAdresa_destinacije() {
        return adresa_destinacije;
    }

    public void setAdresa_destinacije(String adresa_destinacije) {
        this.adresa_destinacije = adresa_destinacije;
    }

    public long getMusterija_id() {
        return musterija_id;
    }

    public void setMusterija_id(long musterija_id) {
        this.musterija_id = musterija_id;
    }

    public Musterija getMusterija() {
        return musterija;
    }

    public void setMusterija(Musterija musterija) {
        this.musterija = musterija;
    }

    public long getVozac_id() {
        return vozac_id;
    }

    public void setVozac_id(long vozac_id) {
        this.vozac_id = vozac_id;
    }

    public Vozaci getVozac() {
        return vozac;
    }

    public void setVozac(Vozaci vozac) {
        this.vozac = vozac;
    }

    public int getBroj_predjenih_kilometara() {
        return broj_predjenih_kilometara;
    }

    public void setBroj_predjenih_kilometara(int broj_predjenih_kilometara) {
        this.broj_predjenih_kilometara = broj_predjenih_kilometara;
    }

    public LocalDateTime getTrajanje_voznje() {
        return trajanje_voznje;
    }

    public void setTrajanje_voznje(LocalDateTime trajanje_voznje) {
        this.trajanje_voznje = trajanje_voznje;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
