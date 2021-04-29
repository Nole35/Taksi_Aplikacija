package taksiSluzba;

import java.io.*;
import java.util.ArrayList;

import enumi.Pol;
import enumi.TelefonskaOdeljenja;
import enumi.VrstaAutomobila;
import korisnici.Musterija;
import korisnici.Vozaci;
import korisnici.Dispeceri;

import vozila.Automobil;

import voznje.Voznja;


public class TaksiSluzba {
    private String pib;
    private String naziv;
    private String adresa;
    private double cijenaStartaVoznje;
    private double cijenaPoKilometru;

    private ArrayList<Musterija> musterije;
    private ArrayList<Dispeceri> dispeceri;
    private ArrayList<Vozaci> vozaci;
    private ArrayList<Automobil> vozila;
    private ArrayList<Voznja> voznje;

    public TaksiSluzba() {


        this.musterije = new ArrayList<Musterija>();
        this.dispeceri = new ArrayList<Dispeceri>();
        this.vozaci = new ArrayList<Vozaci>();
        this.vozila = new ArrayList<Automobil>();
        this.voznje = new ArrayList<Voznja>();
        ucitajDispecere("dispeceri.txt");
        ucitajMusterije("musterija.txt");
        ucitajVozace("vozaci.txt");
        ucitajVozila("automobil.txt");
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


    public ArrayList<Musterija> getMusterije() {
        return musterije;
    }

    public void dodajMusteriju(Musterija musterija) {
        this.musterije.add(musterija);
    }

    public void obrisiMusteriju(Musterija musterija) {
        this.musterije.remove(musterija);
    }

    public Musterija nadjiMusteriju(String korisnickoIme) {
        for (Musterija musterija : musterije) {
            if (musterija.getKorisnickoIme().equals(korisnickoIme)) {
                return musterija;
            }
        }
        return null;
    }

    public Musterija loginMusterija(String korisnickoIme, String lozinka) {
        for (Musterija musterija : musterije) {
            if (musterija.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
                    musterija.getLozinka().equals(lozinka) && !musterija.isObrisan()) {
                return musterija;
            }
        }
        return null;
    }

    public ArrayList<Dispeceri> getDispeceri() {
        return dispeceri;
    }

    public void dodajDispecera(Dispeceri dispeceri) {
        this.dispeceri.add(dispeceri);
    }

    public void obrisiDispecera(Dispeceri dispeceri) {
        this.dispeceri.remove(dispeceri);
    }

    public Dispeceri nadjiDispecera(String korisnickoIme) {
        for (Dispeceri dispeceri : dispeceri) {
            if (dispeceri.getKorisnickoIme().equals(korisnickoIme)) {
                return dispeceri;
            }
        }
        return null;
    }

    public Dispeceri loginDispecera(String korisnickoIme, String lozinka) {
        for (Dispeceri dispeceri : dispeceri) {
            if (dispeceri.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
                    dispeceri.getLozinka().equals(lozinka) && !dispeceri.isObrisan()) {
                return dispeceri;
            }
        }
        return null;
    }


    public ArrayList<Vozaci> getVozaci() {
        return vozaci;
    }

    public void dodajVozaca(Vozaci vozaci) {
        this.vozaci.add(vozaci);
    }

    public void obrisiVozaca(Vozaci vozaci) {
        this.vozaci.remove(vozaci);
    }

    public Vozaci nadjiVozaca(String korisnickoIme) {
        for (Vozaci vozaci : vozaci) {
            if (vozaci.getKorisnickoIme().equals(korisnickoIme)) {
                return vozaci;
            }
        }
        return null;
    }

    public Vozaci loginVozaca(String korisnickoIme, String lozinka) {
        for (Vozaci vozaci : vozaci) {
            if (vozaci.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
                    vozaci.getLozinka().equals(lozinka) && !vozaci.isObrisan()) {
                return vozaci;
            }
        }
        return null;
    }

    public ArrayList<Automobil> getVozila() {
        return vozila;
    }

    public void dodajVozilo(Automobil automobil) {
        this.vozila.add(automobil);
    }

    public void obrisiVozilo(Automobil automobil) {
        this.vozila.remove(automobil);
    }
    public ArrayList<Voznja> getVoznje() {
        return voznje;
    }

    public void dodajVoznju(Voznja voznja) {
        this.voznje.add(voznja);
    }

    public void obrisiVoznju(Voznja voznja) {
        this.voznje.remove(voznja);
    }
    public void ucitajDispecere(String imeFajla) {
        try {
            File dispeceriFile = new File("src/fajlovi/" + imeFajla);
            BufferedReader br = new BufferedReader(new FileReader(dispeceriFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] split = line.split("\\|");
                long id = Long.parseLong(split[0]);
                String korinickoIme = split[1];
                String lozinka = split[2];
                String ime = split[3];
                String prezime = split[4];
                String jmbg = split[5];
                String adresa = split[6];
                int polInt = Integer.parseInt(split[7]);
                Pol pol = Pol.values()[polInt];
                String brojTelefona = split[8];
                boolean obrisan = Boolean.parseBoolean(split[9]);
                double plata = Double.parseDouble(split[10]);
                String brTelLinije = split[11];
                int telefonskaOdeljenja = Integer.parseInt(split[12]);
                TelefonskaOdeljenja telefonskaOdeljenja1 = TelefonskaOdeljenja.values()[telefonskaOdeljenja];


                Dispeceri dispecer = new Dispeceri(id, korinickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, obrisan, plata, brTelLinije, telefonskaOdeljenja1);
                dispeceri.add(dispecer);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void snimiDispecere(String imeFajla) {
        try {
            File file = new File("src/fajlovi/" + imeFajla);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String sadrzaj = "";
            for (Dispeceri dispeceri : dispeceri) {
                sadrzaj += dispeceri.getId() + "|" + dispeceri.getKorisnickoIme() + "|" + dispeceri.getLozinka() + "|"
                        + dispeceri.getIme() + "|" + dispeceri.getPrezime() + "|" + dispeceri.getJmbg() + "|" + dispeceri.getAdresa() + "|" + dispeceri.getPol().ordinal() + "|" + dispeceri.getBrojTelefona() + "|" + dispeceri.isObrisan() + "|" + dispeceri.getPlata() + "|" + dispeceri.getBrTelLinije() + "|" + dispeceri.getTelefonskaOdeljenja().ordinal()+ "\n";

            }
            br.write(sadrzaj);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ucitajMusterije(String imeFajla) {
        try {
            File musterijeFile = new File("src/fajlovi/" + imeFajla);
            BufferedReader br = new BufferedReader(new FileReader(musterijeFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] split = line.split("\\|");
                long id = Long.parseLong(split[0]);
                String korinickoIme = split[1];
                String lozinka = split[2];
                String ime = split[3];
                String prezime = split[4];
                String jmbg = split[5];
                String adresa = split[6];
                int polInt = Integer.parseInt(split[7]);
                Pol pol = Pol.values()[polInt];
                String brojTelefona = split[8];
                boolean obrisan = Boolean.parseBoolean(split[9]);



                Musterija musterija = new Musterija(id, korinickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, obrisan);
                musterije.add(musterija);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void snimiMusterije(String imeFajla) {
        try {
            File file = new File("src/fajlovi/" + imeFajla);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String sadrzaj = "";
            for (Musterija musterija : musterije) {
                sadrzaj += musterija.getId() + "|" + musterija.getKorisnickoIme() + "|" + musterija.getLozinka() + "|"
                        + musterija.getIme() + "|" + musterija.getPrezime() + "|" + musterija.getJmbg() + "|" + musterija.getAdresa() + "|" + musterija.getPol().ordinal() + "|" + musterija.getBrojTelefona() + "|" + musterija.isObrisan() +  "\n";
                System.out.println(sadrzaj);
            }
            br.write(sadrzaj);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ucitajVozace(String imeFajla) {
        try {
            File vozaciFile = new File("src/fajlovi/" + imeFajla);
            BufferedReader br = new BufferedReader(new FileReader(vozaciFile));
            String line = null;
            while ((line = br.readLine()) != null) {

                String[] split = line.split("\\|");
                long id = Long.parseLong(split[0]);
                String korinickoIme = split[1];
                String lozinka = split[2];
                String ime = split[3];
                String prezime = split[4];
                String jmbg = split[5];
                String adresa = split[6];
                int polInt = Integer.parseInt(split[7]);
                Pol pol = Pol.values()[polInt];
                String brojTelefona = split[8];
                boolean obrisan = Boolean.parseBoolean(split[9]);
                double plata = Double.parseDouble(split[10]);
                int brojClanskeKarte = Integer.parseInt(split[11]);






                Vozaci vozac = new Vozaci(id, korinickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, obrisan, plata, brojClanskeKarte);
                vozaci.add(vozac);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void snimiVozace(String imeFajla) {
        try {
            File file = new File("src/fajlovi/" + imeFajla);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String sadrzaj = "";
            for (Vozaci vozaci : vozaci) {
                sadrzaj += vozaci.getId() + "|" + vozaci.getKorisnickoIme() + "|" + vozaci.getLozinka() + "|"
                        + vozaci.getIme() + "|" + vozaci.getPrezime() + "|" + vozaci.getJmbg() + "|" + vozaci.getAdresa() + "|" + vozaci.getPol().ordinal() + "|" + vozaci.getBrojTelefona() + "|" + vozaci.isObrisan() + "|" + vozaci.getPlata() + "|" + vozaci.getBrojClanskeKarte() +  "\n";
                System.out.println(sadrzaj);
            }
            br.write(sadrzaj);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ucitajVozila(String imeFajla) {
        try {
            File vozilaFile = new File("src/fajlovi/" + imeFajla);
            BufferedReader br = new BufferedReader(new FileReader(vozilaFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] split = line.split("\\|");
                long id = Long.parseLong(split[0]);
                String model = split[1];
                String proizvodjac = split[2];
                long godinaProizvodnje = Long.parseLong(split[3]);
                String brojRegistarskeOznake = split[4];
                long brojTaksiVozila = Long.parseLong(split[5]);
                int vrstaAutomobila = Integer.parseInt(split[6]);
                VrstaAutomobila vrstaAutomobila1 = VrstaAutomobila.values()[vrstaAutomobila];
                boolean obrisan = Boolean.parseBoolean(split[7]);



                Automobil automobil = new Automobil(id, model, proizvodjac, godinaProizvodnje, brojRegistarskeOznake, brojTaksiVozila, vrstaAutomobila1, obrisan);
                vozila.add(automobil);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void snimiVozila(String imeFajla) {
        try {
            File file = new File("src/fajlovi/" + imeFajla);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String sadrzaj = "";
            for (Automobil automobil : vozila) {
                sadrzaj += automobil.getId() + "|" + automobil.getModel() + "|" + automobil.getProizvodjac() + "|"
                        + automobil.getGodinaProizvodnje() + "|" + automobil.getBrojRegistarskeOznake() + "|" + automobil.getBrojTaksiVozila() + "|" + automobil.getVrstaAutomobila() + "|" + automobil.isObrisan() +  "\n";
                System.out.println(sadrzaj);
            }
            br.write(sadrzaj);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
