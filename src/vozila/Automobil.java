package vozila;
import enumi.VrstaAutomobila;

public class Automobil{
        private long id;
        private String model;
        private String proizvodjac;
        private long godinaProizvodnje;
        private String brojRegistarskeOznake;
        private long brojTaksiVozila;
        private VrstaAutomobila vrstaAutomobila;

    public int getIdVozaca() {
        return idVozaca;
    }

    public void setIdVozaca(int idVozaca) {
        this.idVozaca = idVozaca;
    }

    private boolean obrisan;
        private int idVozaca;

        public Automobil() {
            this.id = 0;
            this.model = "";
            this.proizvodjac = "";
            this.godinaProizvodnje = 0;
            this.brojRegistarskeOznake = "";
            this.brojTaksiVozila = 0;
            this.vrstaAutomobila = VrstaAutomobila.PutnickiAutomobil;
            this.obrisan = false;
            this.idVozaca = 0;
        }
        public Automobil(long id, String model, String proizvodjac, long godinaProizvodnje, String brojRegistarskeOznake, long brojTaksiVozila, VrstaAutomobila vrstaAutomobila, boolean obrisan, int idVozaca) {
            this.id = id;
            this.model = model;
            this.proizvodjac = proizvodjac;
            this.godinaProizvodnje = godinaProizvodnje;
            this.brojRegistarskeOznake = brojRegistarskeOznake;
            this.brojTaksiVozila = brojTaksiVozila;
            this.vrstaAutomobila = vrstaAutomobila;
            this.obrisan = obrisan;
            this.idVozaca = idVozaca;
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

        public long getGodinaProizvodnje() {
            return godinaProizvodnje;
        }

        public void setGodinaProizvodnje(long godinaProizvodnje) {
            this.godinaProizvodnje = godinaProizvodnje;
        }

        public String getBrojRegistarskeOznake() {
            return brojRegistarskeOznake;
        }

        public void setBrojRegistarskeOznake(String brojRegistarskeOznake) {
            this.brojRegistarskeOznake = brojRegistarskeOznake;
        }

        public long getBrojTaksiVozila() {
            return brojTaksiVozila;
        }

        public void setBrojTaksiVozila(long brojTaksiVozila) {
            this.brojTaksiVozila = brojTaksiVozila;
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
            return "Automobil{" +
                    "id=" + id +
                    ", model='" + model + '\'' +
                    ", proizvodjac='" + proizvodjac + '\'' +
                    ", godina_proizvodnje=" + godinaProizvodnje +
                    ", broj_registarske_oznake='" + brojRegistarskeOznake + '\'' +
                    ", broj_taksi_vozila=" + brojTaksiVozila +
                    ", vrstaAutomobila=" + vrstaAutomobila +
                    ", obrisan=" + obrisan +
                    ", idVozaca =" + idVozaca +
                    '}';
        }
    }



