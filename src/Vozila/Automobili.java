package Vozila;
import enumi.VrstaAutomobila;


public class Automobili {
    private long id;
    private String model;
    private String proizvodjac;
    private long godina_proizvodnje;
    private String broj_registarske_oznake;
    private long broj_taksi_vozila;
    private VrstaAutomobila vrstaAutomobila;
    private boolean obrisan;

    public Automobili() {
        this.id = 0;
        this.model = "";
        this.proizvodjac = "";
        this.godina_proizvodnje = 0;
        this.broj_registarske_oznake = "";
        this.broj_taksi_vozila = 0;
        this.vrstaAutomobila = VrstaAutomobila.Putnicki_Automobil;
        this.obrisan = false;
    }
    public Automobili(long id, String model, String proizvodjac, long godina_proizvodnje, String broj_registarske_oznake, long broj_taksi_vozila, VrstaAutomobila vrstaAutomobila, boolean obrisan) {
        super();
        this.id = id;
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.godina_proizvodnje = godina_proizvodnje;
        this.broj_registarske_oznake = broj_registarske_oznake;
        this.broj_taksi_vozila = broj_taksi_vozila;
        this.vrstaAutomobila = vrstaAutomobila;
        this.obrisan = obrisan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public long getGodina_proizvodnje() {
        return godina_proizvodnje;
    }

    public void setGodina_proizvodnje(long godina_proizvodnje) {
        this.godina_proizvodnje = godina_proizvodnje;
    }

    public String getBroj_registarske_oznake() {
        return broj_registarske_oznake;
    }

    public void setBroj_registarske_oznake(String broj_registarske_oznake) {
        this.broj_registarske_oznake = broj_registarske_oznake;
    }

    public long getBroj_taksi_vozila() {
        return broj_taksi_vozila;
    }

    public void setBroj_taksi_vozila(long broj_taksi_vozila) {
        this.broj_taksi_vozila = broj_taksi_vozila;
    }

    public VrstaAutomobila getVrstaAutomobila() {
        return vrstaAutomobila;
    }

    public void setVrstaAutomobila(VrstaAutomobila vrstaAutomobila) {
        this.vrstaAutomobila = vrstaAutomobila;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    @Override
    public String toString() {
        return "Automobili{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", proizvodjac='" + proizvodjac + '\'' +
                ", godina_proizvodnje=" + godina_proizvodnje +
                ", broj_registarske_oznake='" + broj_registarske_oznake + '\'' +
                ", broj_taksi_vozila=" + broj_taksi_vozila +
                ", vrstaAutomobila=" + vrstaAutomobila +
                ", obrisan=" + obrisan +
                '}';
    }
}
