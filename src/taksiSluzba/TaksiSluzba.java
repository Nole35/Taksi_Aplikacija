package taksiSluzba;

import java.io.*;
import java.util.ArrayList;

import enumi.Pol;
import enumi.TelefonskaOdeljenja;
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
                System.out.println(sadrzaj);
            }
            br.write(sadrzaj);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }








}


