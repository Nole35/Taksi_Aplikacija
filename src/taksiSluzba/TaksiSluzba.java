package taksiSluzba;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import enumi.Pol;
import enumi.Status;
import enumi.TelefonskaOdeljenja;
import enumi.TipPorucivanja;
import enumi.VrstaAutomobila;
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
                String adresaPolaska = split[2];
                String adresaDestinacije = split[3];
                long musterijaId = Long.parseLong(split[4]);
                long vozacId = Long.parseLong(split[5]);
                int brojPredjenihKilometara = Integer.parseInt(split[6]);
                int trajanjeVoznje = Integer.parseInt(split[7]);
                int statusInt = Integer.parseInt(split[8]);
                Status status = Status.values()[statusInt];
                boolean obrisan = Boolean.parseBoolean(split[9]);
                TipPorucivanja tipPorucivanja = TipPorucivanja.APLIKACIJOM;
                String napomena = split[11];
                int cijena = Integer.parseInt(split[12]);
                boolean ocjenjena = Boolean.parseBoolean(split[13]);
                boolean petFriendly = Boolean.parseBoolean(split[14]);


                VoznjaAplikacija voznja = new VoznjaAplikacija(id, datumIVremePoruzbine, adresaPolaska, adresaDestinacije, musterijaId, null, vozacId, null, brojPredjenihKilometara, trajanjeVoznje, status, obrisan,cijena,ocjenjena, tipPorucivanja,napomena, petFriendly) {
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
                String adresaPolaska = split[2];
                String adresaDestinacije = split[3];
                long musterijaId = Long.parseLong(split[4]);
                long vozacId = Long.parseLong(split[5]);
                int brojPredjenihKilometara = Integer.parseInt(split[6]);
                int trajanjeVoznje = Integer.parseInt(split[7]);
                int statusInt = Integer.parseInt(split[8]);
                Status status = Status.values()[statusInt];
                boolean obrisan = Boolean.parseBoolean(split[9]);
                TipPorucivanja tipPorucivanja = TipPorucivanja.TELEFONOM;
                int cijena = Integer.parseInt(split[11]);
                boolean ocjenjena = Boolean.parseBoolean(split[12]);


                VoznjaTelefon voznjat = new VoznjaTelefon(id, datumIVremePoruzbine, adresaPolaska, adresaDestinacije, musterijaId, null, vozacId, null, brojPredjenihKilometara, trajanjeVoznje, status, obrisan,cijena,ocjenjena, tipPorucivanja) {
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
    
    public ArrayList<Vozaci> sviNeobrisaniVozaci() {
		ArrayList<Vozaci> neobrisani = new ArrayList<Vozaci>();
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
    





}

