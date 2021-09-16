package taksiSluzba;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import enumi.Pol;
import enumi.Status;
import enumi.TelefonskaOdeljenja;
import enumi.TipPorucivanja;
import enumi.VrstaAutomobila;
import gui.formeZaNarucivanje.NarucivanjeTelefon;
import kolekcije.DoubleLinkedList;
import korisnici.Musterija;
import korisnici.Vozaci;

import korisnici.Dispeceri;

import vozila.Automobil;

import voznje.VoznjaAplikacija;
import voznje.VoznjaTelefon;
import taksiSluzba.TaksiSluzbai;


public class TaksiSluzba {
  
    private DoubleLinkedList<Musterija> musterije;
    private DoubleLinkedList<Dispeceri> dispeceri;
    private DoubleLinkedList<Vozaci> vozaci;
    private DoubleLinkedList<Automobil> vozila;
    private DoubleLinkedList<VoznjaAplikacija> voznje;
    private DoubleLinkedList<VoznjaTelefon> voznjet;
    
    private String pib;
    private String naziv;
    private String adresa;
    private double cijenaStartaVoznje;
    private double cijenaPoKilometru;
    

    
    

    public TaksiSluzba() {
    	

        this.musterije = new DoubleLinkedList<>();
        this.dispeceri = new DoubleLinkedList<>();
        this.vozaci = new DoubleLinkedList<>();
        this.vozila = new DoubleLinkedList<>();
        this.voznje = new DoubleLinkedList<>();
        this.voznjet = new DoubleLinkedList<>();
        
    
        

        ucitajDispecere("dispeceri.txt");
        ucitajMusterije("musterija.txt");
        ucitajVozace("vozaci.txt");
        ucitajVozila("automobil.txt");
        ucitajVoznje("voznje.txt");
        ucitajVoznjet("voznjet.txt");
        ucitajTaksisluzbu("taksisluzba.txt");
        for (Vozaci vozaci:this.getVozaci()
             ) {
            for (Automobil automobil: this.getVozila()
                 ) {
                if (automobil.getIdVozaca()== vozaci.getId()) {
                    vozaci.setAutomobili(automobil);
                    System.out.println("automobil " + automobil.getIdVozaca() + " vozac" + vozaci.getId() );
                }


            }


        }
        
        
        
        
        }
    



  

    public DoubleLinkedList<Musterija> getMusterije() {
        return musterije;
    }

    public void dodajMusteriju(Musterija musterija) {
        this.musterije.add(musterija);
    }


    public DoubleLinkedList<Automobil> pretraga(String model, String proizvodjac, String brojRegistracije, String brojTaksiVozila, String godinaProizvodnje){
        DoubleLinkedList<Automobil> auto = new DoubleLinkedList<Automobil>();
        for (Automobil automobil: vozila
					) {
            if ((model.equals("") || model.equals(automobil.getModel())) &&
                    (proizvodjac.equals("") || proizvodjac.equals(automobil.getProizvodjac())) &&
                    (brojRegistracije.equals("") || brojRegistracije.equals(automobil.getBrojRegistarskeOznake())) &&
                    (brojTaksiVozila.equals("") || Integer.parseInt(brojTaksiVozila) == automobil.getBrojTaksiVozila()) &&
                    (godinaProizvodnje.equals("") || Integer.parseInt(godinaProizvodnje) == automobil.getGodinaProizvodnje())
            ) {
                System.out.println(model + " / " + automobil.getModel());
                System.out.println(proizvodjac + " / " + automobil.getProizvodjac());
                System.out.println(brojRegistracije + " / " + automobil.getBrojRegistarskeOznake());
                System.out.println(brojTaksiVozila + " / " + automobil.getBrojTaksiVozila());
                System.out.println(godinaProizvodnje + " / " + automobil.getGodinaProizvodnje());
                auto.add(automobil);
            }
        }
        return auto;
    }

    public DoubleLinkedList<Vozaci> pretraga1(String ime, String prezime, String plata, String model){
        DoubleLinkedList<Vozaci> vozacc = new DoubleLinkedList<Vozaci>();
        for (Vozaci vozac: vozaci
        ) {
            if ((ime.equals("") || ime.equals(vozac.getIme())) &&
                    (prezime.equals("") || prezime.equals(vozac.getPrezime())) &&
                    (plata.equals("") || Double.parseDouble(plata) == vozac.getPlata())

            ) {
                System.out.println(ime + " / " + vozac.getIme());
                System.out.println(prezime + " / " + vozac.getPrezime());
                System.out.println(plata + " / " + vozac.getPlata());
                System.out.println(model + " / " + vozac.getAutomobil().getModel());


                vozacc.add(vozac);
            }
        }
        return vozacc;
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

    public DoubleLinkedList<Dispeceri> getDispeceri() {
        return dispeceri;
    }

    public void dodajDispecera(Dispeceri dispeceri) {
        this.dispeceri.add(dispeceri);
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


    public DoubleLinkedList<Vozaci> getVozaci() {
        return vozaci;
    }

    public void dodajVozaca(Vozaci vozaci) {
        this.vozaci.add(vozaci);
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

    public DoubleLinkedList<Automobil> getVozila() {
        return vozila;
    }

    public void dodajVozilo(Automobil automobil) {
        this.vozila.add(automobil);
    }
    public Automobil nadjiAutomobil(String brojRegistarskeOznake) {
        Automobil automobil1 = null;
    	for (Automobil automobil : vozila) {
            if (automobil.getBrojRegistarskeOznake().equals(brojRegistarskeOznake)) {
            	
            	
                 automobil1 = automobil;
            }}
    	System. out. println("Vraceni automobil " + automobil1 );
    	return automobil1;
           
        
    }
    

    public void obrisiVozilo(Automobil automobil) {
        this.vozila.remove(automobil);
    }
    public DoubleLinkedList<VoznjaAplikacija> getVoznje() {
        return voznje;
    }
 

    public void dodajVoznju(VoznjaAplikacija voznja) {
        this.voznje.add(voznja);
    }

  
    public DoubleLinkedList<VoznjaTelefon> getVoznjet() {
        return voznjet;
    }
    
      
        public void dodajVoznjut(VoznjaTelefon voznjat) {
            this.voznjet.add(voznjat);
        }


        public void obrisiVoznjut(VoznjaTelefon voznjat) {
            this.voznjet.remove(voznjat);
            
    }
        public VoznjaTelefon nadjiVoznjut(String adresaDestinacije) {
            for (VoznjaTelefon voznjat : voznjet) {
                if (voznjat.getAdresaDestinacije().equals(adresaDestinacije)) {
                    return voznjat;
                }
            }
            return null;
        }
        
        public VoznjaAplikacija nadjiVoznjua(String adresaDestinacije) {
            for (VoznjaAplikacija voznja : voznje) {
                if (voznja.getAdresaDestinacije().equals(adresaDestinacije)) {
                    return voznja;
                }
            }
            return null;
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
                double prosjecnaOcjena = Double.parseDouble(split[12]);






                Vozaci vozac = new Vozaci(id, korinickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, obrisan, plata, brojClanskeKarte,prosjecnaOcjena);
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
                        + vozaci.getIme() + "|" + vozaci.getPrezime() + "|" + vozaci.getJmbg() + "|" + vozaci.getAdresa() + "|" + vozaci.getPol().ordinal() + "|" + vozaci.getBrojTelefona() + "|" + vozaci.isObrisan() + "|" + vozaci.getPlata() + "|" + vozaci.getBrojClanskeKarte() + "|" + vozaci.getProsjecnaOcjena() +  "\n";
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
                int idVozaca = Integer.parseInt(split[8]);



                Automobil automobil = new Automobil(id, model, proizvodjac, godinaProizvodnje, brojRegistarskeOznake, brojTaksiVozila, vrstaAutomobila1, obrisan,idVozaca);
              this.vozila.add(automobil);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void snimiVozila(String imeFajla) {
        try {
        	PrintWriter writer = new PrintWriter("src/fajlovi/" + imeFajla);
        	writer.print("");
        	
        	writer.close();
            File file = new File("src/fajlovi/" + imeFajla);
            BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
            
            String sadrzaj = "";
            for (Automobil automobil : vozila) {
                sadrzaj += automobil.getId() + "|" + automobil.getModel() + "|" + automobil.getProizvodjac() + "|"
                        + automobil.getGodinaProizvodnje() + "|" + automobil.getBrojRegistarskeOznake() + "|" + automobil.getBrojTaksiVozila() + "|" + automobil.getVrstaAutomobila().ordinal() + "|" + automobil.isObrisan() + "|"+ automobil.getIdVozaca() +   "\n";
               
            }
            br.write(sadrzaj);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   

    public void ucitajVoznje(String imeFajla) {
        try {
            File voznjeFile = new File("src/fajlovi/" + imeFajla);
            BufferedReader br = new BufferedReader(new FileReader(voznjeFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] split = line.split("\\|");
                long id = Long.parseLong(split[0]);
                String datumIVremePoruzbine = split[1];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime ldt = LocalDateTime.parse(datumIVremePoruzbine,formatter);
                String adresaPolaska = split[2];
                String adresaDestinacije = split[3];
                long musterijaId = Long.parseLong(split[4]);
                long vozacId = Long.parseLong(split[5]);
                int brojPredjenihKilometara = Integer.parseInt(split[6]);
                int trajanjeVoznje = Integer.parseInt(split[7]);
                int statusInt = Integer.parseInt(split[8]);
                Status status = Status.values()[statusInt];
                boolean obrisan = Boolean.parseBoolean(split[9]);
                TipPorucivanja tipPorucivanja = TipPorucivanja.valueOf(split[10]);
                String napomena = split[11];
                int cijena = Integer.parseInt(split[12]);
                boolean ocjenjena = Boolean.parseBoolean(split[13]);
                boolean petFriendly = Boolean.parseBoolean(split[14]);


                VoznjaAplikacija voznja = new VoznjaAplikacija(id, ldt, adresaPolaska, adresaDestinacije, musterijaId, null, vozacId, null, brojPredjenihKilometara, trajanjeVoznje, status, obrisan,cijena,ocjenjena, tipPorucivanja,napomena, petFriendly) {
                };
                voznje.add(voznja);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void snimiVoznje(String imeFajla) {
        try {
            File file = new File("src/fajlovi/" + imeFajla);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String sadrzaj = "";
            for (VoznjaAplikacija voznja : voznje) {
                sadrzaj += voznja.getId() + "|" + voznja.getDatumIVremePoruzbine() + "|" + voznja.getAdresaPolaska() + "|" + voznja.getAdresaDestinacije() + "|"
                        + voznja.getMusterijaId() + "|" + voznja.getVozacId() + "|"  + voznja.getBrojPredjenihKilometara() + "|" + voznja.getTrajanjeVoznje() + "|" + voznja.getStatus().ordinal() + "|" + voznja.isObrisan() + "|" + voznja.getTipPorucivanja() +  "|" + voznja.getNapomena() + "|" + voznja.getCijena() + "\n";
                System.out.println(sadrzaj);
            }
            br.write(sadrzaj);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ucitajVoznjet(String imeFajla) {
        try {
            File voznjetFile = new File("src/fajlovi/" + imeFajla);
            BufferedReader br = new BufferedReader(new FileReader(voznjetFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] split = line.split("\\|");
                long id = Long.parseLong(split[0]);
                String datumIVremePoruzbine = split[1];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime ldt = LocalDateTime.parse(datumIVremePoruzbine,formatter);
                String adresaPolaska = split[2];
                String adresaDestinacije = split[3];
                long musterijaId = Long.parseLong(split[4]);
                long vozacId = Long.parseLong(split[5]);
                int brojPredjenihKilometara = Integer.parseInt(split[6]);
                int trajanjeVoznje = Integer.parseInt(split[7]);
                int statusInt = Integer.parseInt(split[8]);
                Status status = Status.values()[statusInt];
                boolean obrisan = Boolean.parseBoolean(split[9]);
                TipPorucivanja tipPorucivanja = TipPorucivanja.valueOf(split[10]);
                int cijena = Integer.parseInt(split[11]);
                boolean ocjenjena = Boolean.parseBoolean(split[12]);


                VoznjaTelefon voznjat = new VoznjaTelefon(id, ldt, adresaPolaska, adresaDestinacije, musterijaId, null, vozacId, null, brojPredjenihKilometara, trajanjeVoznje, status, obrisan,cijena,ocjenjena, tipPorucivanja) {
                };
                voznjet.add(voznjat);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void snimiVoznjet(String imeFajla) {
        try {
            File file = new File("src/fajlovi/" + imeFajla);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String sadrzaj = "";
            for (VoznjaTelefon voznjat : voznjet) {
                sadrzaj += voznjat.getId() + "|" + voznjat.getDatumIVremePoruzbine() + "|" + voznjat.getAdresaPolaska() + "|" + voznjat.getAdresaDestinacije() + "|"
                        + voznjat.getMusterijaId() + "|" + voznjat.getVozacId() + "|"  + voznjat.getBrojPredjenihKilometara() + "|" + voznjat.getTrajanjeVoznje() + "|" + voznjat.getStatus().ordinal() + "|" + voznjat.isObrisan() + "|" + voznjat.getTipPorucivanja()+"|" + voznjat.getCijena() +"\n";
                System.out.println(sadrzaj);
            }
            br.write(sadrzaj);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


 


    public void obrisiVozaca(Vozaci vozacZaBrisanje) {
        vozacZaBrisanje.setObrisan(true);

        for(Vozaci vozaci : vozaci) {
            if(vozaci.getId() == vozacZaBrisanje.getId()) {
                vozaci.setObrisan(true);
                break;
            }
        }
    }

    public void izmjeniVozaca(long id, Vozaci vozacZaIzmjenu) {

        if(vozacZaIzmjenu.getId() != id)
            return;


           for (Vozaci vozac: vozaci
           ) {

               if (vozac.getId() == id) {

                   vozaci.getElement(vozac).setElement(vozacZaIzmjenu);
                   break;
               }
           }}






    public void obrisiVoznjeTelefon(VoznjaTelefon voznjaTelefonZaBrisanje) {
        voznjaTelefonZaBrisanje.setObrisan(true);

        for(VoznjaTelefon voznjaTelefon : voznjet) {
            if(voznjaTelefon.getId() == voznjaTelefonZaBrisanje.getId()) {
                voznjaTelefon.setObrisan(true);
                break;
            }
        }
    }

    public void izmjeniVoznjaTelefon(long id, VoznjaTelefon voznjaTelefonZaIzmjenu) {

        if(voznjaTelefonZaIzmjenu.getId() != id)
            return;

        for(VoznjaTelefon voznjaTelefon: voznjet) {
            if(voznjaTelefon.getId() == id) {

                voznjet.getElement(voznjaTelefon).setElement(voznjaTelefonZaIzmjenu);
                break;
            }

        }
    }
    
    
    public void obrisiDispecera(Dispeceri dispecerZaBrisanje) {
        dispecerZaBrisanje.setObrisan(true);

        for(Dispeceri dispeceri : dispeceri) {
            if(dispeceri.getId() == dispecerZaBrisanje.getId()) {
                dispeceri.setObrisan(true);
                break;
            }
        }
    }

    public void izmjeniDispecera(long id, Dispeceri dispecerZaIzmjenu) {

        if(dispecerZaIzmjenu.getId() != id)
            return;

        for(Dispeceri dispecer: dispeceri) {
            if(dispecer.getId() == id)
                dispeceri.getElement(dispecer).setElement(dispecerZaIzmjenu);
        }
    }

    public void obrisiMusteriju(Musterija musterijaZaBrisanje) {
        musterijaZaBrisanje.setObrisan(true);

        for(Musterija musterija : musterije) {
            if(musterija.getId() == musterijaZaBrisanje.getId()) {
                musterija.setObrisan(true);
                break;
            }
        }
    }

    public void izmjeniMusteriju(long id, Musterija musterijaZaIzmjenu) {

        if(musterijaZaIzmjenu.getId() != id)
            return;

        for(Musterija musterija: musterije) {
            if(musterija.getId() == id)
                musterije.getElement(musterija).setElement(musterijaZaIzmjenu);
        }
    }
    
    
    public void obrisiAutomobil(Automobil automobilZaBrisanje) {
        automobilZaBrisanje.setObrisan(true);

        for(Automobil automobil : vozila) {
            if(automobil.getId() == automobilZaBrisanje.getId()) {
                automobil.setObrisan(true);
                break;
            }
        }
    }

    public void izmjeniAutomobil(long id, Automobil automobilZaIzmjenu) {

        if(automobilZaIzmjenu.getId() != id)
            return;

        for(Automobil automobil: vozila) {
            if(automobil.getId() == id)
                vozila.getElement(automobil).setElement(automobilZaIzmjenu);
        }
    }


 public void obrisiVoznjeAplikacija(VoznjaAplikacija voznjaAplikacijaZaBrisanje) {
        voznjaAplikacijaZaBrisanje.setObrisan(true);

        for(VoznjaAplikacija voznjaAplikacija : voznje) {
            if(voznjaAplikacija.getId() == voznjaAplikacijaZaBrisanje.getId()) {
                voznjaAplikacija.setObrisan(true);
                break;
            }
        }
    }

    public void izmjeniVoznjaAplikacija(long id, VoznjaAplikacija voznjaAplikacijaZaIzmjenu) {

        if(voznjaAplikacijaZaIzmjenu.getId() != id)
            return;

        for(VoznjaAplikacija voznjaAplikacija: voznje) {
            if(voznjaAplikacija.getId() == id)
                voznje.getElement(voznjaAplikacija).setElement(voznjaAplikacijaZaIzmjenu);
            break;
        }
    }
    public void ucitajTaksisluzbu(String imeFajla) {
        try {
            File taksisluzbaFile = new File("src/fajlovi/" + imeFajla);
            BufferedReader br = new BufferedReader(new FileReader(taksisluzbaFile));
            String line = null;
            while ((line = br.readLine()) != null) {

                String[] split = line.split("\\|");
                
                String pib = split[0];
                String naziv = split[1];
                String adresa = split[2];
                double cijenaStartaVoznje = Double.parseDouble(split[3]);
                double cijenaPoKilometru = Double.parseDouble(split[4]);
                
                
                this.setPib(pib);
                this.setNaziv(naziv);
                this.setAdresa(adresa);
                this.setCijenaStartaVoznje(cijenaStartaVoznje);
                this.setCijenaPoKilometru(cijenaPoKilometru);


            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void snimiTaksiSluzbu(String imeFajla) {
        try {
            File file = new File("src/fajlovi/" + imeFajla);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String sadrzaj = "";
           
                sadrzaj += getPib() + "|" + getNaziv() + "|" + getAdresa() + "|" + getCijenaStartaVoznje() + "|" + getCijenaPoKilometru() + "\n";
                System.out.println(sadrzaj);
            
            br.write(sadrzaj);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public ArrayList<Automobil> sviNeobrisaniAutomobili() {
		ArrayList<Automobil> neobrisani = new ArrayList<Automobil>();
		for (Automobil automobil : vozila) {
			if(!automobil.isObrisan()) {
				neobrisani.add(automobil);
			}
		}
		return neobrisani;
	}
    
    public DoubleLinkedList<Vozaci> sviNeobrisaniVozaci() {
        DoubleLinkedList<Vozaci> neobrisani = new DoubleLinkedList<Vozaci>();
		for (Vozaci vozaci : vozaci) {
			if(!vozaci.isObrisan()) {
				neobrisani.add(vozaci);
			}
		}
		return neobrisani;
	}
    public ArrayList<VoznjaAplikacija> sveNeobrisaneVoznjeA() {
  		ArrayList<VoznjaAplikacija> neobrisani = new ArrayList<VoznjaAplikacija>();
  		for (VoznjaAplikacija voznja : voznje) {
  			if(!voznja.isObrisan() ) {
  				neobrisani.add(voznja);
  			}
  		}
  		return neobrisani;
  	}
    public ArrayList<VoznjaTelefon> sveNeobrisaneVoznjeT() {
  		ArrayList<VoznjaTelefon> neobrisani = new ArrayList<VoznjaTelefon>();
  		for (VoznjaTelefon voznjat : voznjet) {
  			if(!voznjat.isObrisan() ) {
  				neobrisani.add(voznjat);
  			}
  		}
  		return neobrisani;
  	}
    public DoubleLinkedList<String> sveZavrseneTelefon() {
        DoubleLinkedList<String> neobrisani = new DoubleLinkedList<String>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (VoznjaTelefon voznjat : voznjet) {
            if(!voznjat.isObrisan() && voznjat.getStatus().equals(Status.ZAVRSENA)) {
                String datum = voznjat.getDatumIVremePoruzbine().format(formatter);
                neobrisani.add(datum);
            }
        }
        return neobrisani;
    }
    public DoubleLinkedList<String> sveZavrseneAplikacija() {
        DoubleLinkedList<String> neobrisani = new DoubleLinkedList<String>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (VoznjaAplikacija voznjat : voznje) {
            if(!voznjat.isObrisan() && voznjat.getStatus().equals(Status.ZAVRSENA)) {
                String datum = voznjat.getDatumIVremePoruzbine().format(formatter);
                neobrisani.add(datum);
            }
        }
        return neobrisani;
    }
    public DoubleLinkedList<VoznjaTelefon> sveZavrseneTelefon1() {
        DoubleLinkedList<VoznjaTelefon> neobrisani = new DoubleLinkedList<VoznjaTelefon>();
        for (VoznjaTelefon voznjat : voznjet) {
            if(!voznjat.isObrisan() && voznjat.getStatus().equals(Status.ZAVRSENA)) {
                neobrisani.add(voznjat);
            }
        }
        return neobrisani;
    }
    public DoubleLinkedList<VoznjaAplikacija> sveZavrseneAplikacija1() {
        DoubleLinkedList<VoznjaAplikacija> neobrisani = new DoubleLinkedList<VoznjaAplikacija>();
        for (VoznjaAplikacija voznjat : voznje) {
            if(!voznjat.isObrisan() && voznjat.getStatus().equals(Status.ZAVRSENA)) {
                neobrisani.add(voznjat);
            }
        }
        return neobrisani;
    }
    public ArrayList<VoznjaTelefon> sveNeobrisaneVoznjeDodTel() {
  		ArrayList<VoznjaTelefon> neobrisani = new ArrayList<VoznjaTelefon>();
  		for (VoznjaTelefon voznjat : voznjet) {
  			if(!voznjat.isObrisan() && voznjat.getStatus().equals(Status.DODELJENA)) {
  				neobrisani.add(voznjat);
  			}
  		}
  		return neobrisani;
  	}
    public ArrayList<VoznjaAplikacija> sveNeobrisaneVoznjeNaCekApl() {
  		ArrayList<VoznjaAplikacija> neobrisani = new ArrayList<VoznjaAplikacija>();
  		for (VoznjaAplikacija voznja : voznje) {
  			if(!voznja.isObrisan() && voznja.getStatus().equals(Status.KREIRANA_NA_CEKANJU)) {
  				neobrisani.add(voznja);
  			}
  		}
  		return neobrisani;
  	}
    public ArrayList<VoznjaTelefon> sveNeobrisaneVoznjeDodTelT() {
  		ArrayList<VoznjaTelefon> neobrisani = new ArrayList<VoznjaTelefon>();
  		for (VoznjaTelefon voznjat : voznjet) {
  			if(!voznjat.isObrisan() && voznjat.getStatus().equals(Status.KREIRANA)) {
  				neobrisani.add(voznjat);
  			}
  		}
  		return neobrisani;
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
    


	//binarna

    public int pronadjiVozacaBinarySearch(DoubleLinkedList<Vozaci> array, int target){ // Ukloniti static
        return binarySearchVozaca(array, target, 0, array.size());
    }

    public int binarySearchVozaca(DoubleLinkedList<Vozaci> array, int target, int low, int high){ // Ukloniti static

        if(low > high){
            return 0;
        }
        int mid = (low + high) / 2;

        if (array.getElement(mid).getId() == target){
            return mid;
        } else if (array.getElement(mid).getId() > target){
            return  binarySearchVozaca(array, target, low, mid-1);
        } else {
            return binarySearchVozaca(array, target, mid + 1, high);
        }
    }

    public  int pronadjiAutomobilBinarySearch(DoubleLinkedList<Automobil> array, int target){ // Ukloniti static
        return binarySearchAutomobil(array, target, 0, array.size());
    }

    public  int binarySearchAutomobil(DoubleLinkedList<Automobil> array, int target, int low, int high){ // Ukloniti static

        if(low > high){
            return 0;
        }
        int mid = (low + high) / 2;

        if (array.getElement(mid).getId() == target){
            return mid;
        } else if (array.getElement(mid).getId() > target){
            return  binarySearchAutomobil(array, target, low, mid-1);
        } else {
            return binarySearchAutomobil(array, target, mid + 1, high);
        }
    }
    public boolean nadjiDatum(String datum){
        for(VoznjaAplikacija voznja : voznje){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            if(voznja.getDatumIVremePoruzbine().format(formatter).equals(datum)){
                return true;
            }
        }
        for(VoznjaTelefon voznja : voznjet){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            if(voznja.getDatumIVremePoruzbine().format(formatter).equals(datum)){
                return true;
            }
        }
        return false;
    }
    public DoubleLinkedList<Integer> nadjiVoznjuNarucenuPrekoTelefonaPoDatumu(String datum){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DoubleLinkedList<Integer> ukupanBrojLista = new DoubleLinkedList<>();
        for(VoznjaTelefon voznja : voznjet){
            if(voznja.getDatumIVremePoruzbine().format(formatter).equals(datum) && (voznja.getStatus().equals(Status.ZAVRSENA))){
                ukupanBrojLista.add((int) voznja.getId());
            }
        }
        return ukupanBrojLista;
    }
    public DoubleLinkedList<Integer> nadjiVoznjuNarucenuPrekoAplikacijePoDatumu(String datum){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DoubleLinkedList<Integer> ukupanBrojLista = new DoubleLinkedList<>();
        for(VoznjaAplikacija voznja : voznje){
            if(voznja.getDatumIVremePoruzbine().format(formatter).equals(datum) && (voznja.getStatus().equals(Status.ZAVRSENA))){
                ukupanBrojLista.add((int) voznja.getId());
            }
        }
        return ukupanBrojLista;
    }
    public double ukupnoTrajanjeVoznjiTelefoni(int id){
        double trajanjeVoznje = 0;
        for(VoznjaTelefon voznjePrekoTelefona : voznjet){
            if(voznjePrekoTelefona.getId() == id && (voznjePrekoTelefona.getStatus().equals(Status.ZAVRSENA))){
                trajanjeVoznje = voznjePrekoTelefona.getTrajanjeVoznje();
            }
        }
        return trajanjeVoznje;
    }

    public double ukupnoTrajanjeVoznjiAplikacija(int id){
        double trajanjeVoznje = 0;
        for(VoznjaAplikacija voznjePrekoAplikacije : voznje){
            if(voznjePrekoAplikacije.getId() == id && (voznjePrekoAplikacije.getStatus().equals(Status.ZAVRSENA))){
                trajanjeVoznje = voznjePrekoAplikacije.getTrajanjeVoznje();
            }
        }
        return trajanjeVoznje;
    }

    public double ukupnaKilometrazaTelefoni(int id){
        double kilometraza = 0;
        for(VoznjaTelefon voznjePrekoTelefona : voznjet){
            if(voznjePrekoTelefona.getId() == id && (voznjePrekoTelefona.getStatus().equals(Status.ZAVRSENA))){
                kilometraza = voznjePrekoTelefona.getBrojPredjenihKilometara();
            }
        }
        return kilometraza;
    }

    public double ukupnaKilometrazaAplikacija(int id){
        double kilometraza = 0;
        for(VoznjaAplikacija voznjePrekoAplikacije : voznje){
            if(voznjePrekoAplikacije.getId() == id && (voznjePrekoAplikacije.getStatus().equals(Status.ZAVRSENA))){
                kilometraza = voznjePrekoAplikacije.getBrojPredjenihKilometara();
            }
        }
        return kilometraza;
    }

    public double ukupnaZaradaTelefoni(int id){
        double rezultat = 0;
        for(VoznjaTelefon voznja : voznjet){
            if(voznja.getId() == id && (voznja.getStatus().equals(Status.ZAVRSENA))){
                rezultat += voznja.getCijena();
            }
        }
        return rezultat;
    }

    public double ukupnaZaradaAplikacija(int id){
        double rezultat = 0;
        for(VoznjaAplikacija voznja : voznje){
            if(voznja.getId() == id && (voznja.getStatus().equals(Status.ZAVRSENA))){
                rezultat += voznja.getCijena();
            }
        }
        return rezultat;
    }

    public DoubleLinkedList<String> listaKorisnickihImenaVozaca(int id){
        DoubleLinkedList<String> vozaci = new DoubleLinkedList<>();
        for(VoznjaTelefon voznjePrekoTelefona : voznjet){
            if(voznjePrekoTelefona.getId() == id && (voznjePrekoTelefona.getStatus().equals(Status.ZAVRSENA))) {
                String vozacKorisnickoIme = voznjePrekoTelefona.getVozac().getKorisnickoIme();
                vozaci.add(vozacKorisnickoIme);
            }
        }
        for(VoznjaAplikacija voznjePrekoAplikacije : voznje){
            if(voznjePrekoAplikacije.getId() == id && (voznjePrekoAplikacije.getStatus().equals(Status.ZAVRSENA))) {
                String vozacKorisnickoIme = voznjePrekoAplikacije.getVozac().getKorisnickoIme();
                vozaci.add(vozacKorisnickoIme);
            }
        }
        return vozaci;
    }



}

