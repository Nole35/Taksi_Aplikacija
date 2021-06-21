package com.lazic;



import gui.Prijava;
import korisnici.Dispeceri;
import korisnici.Musterija;
import korisnici.Vozaci;

import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import vozila.Automobil;
import voznje.Voznja;

public class Main {

   

        
        public static String VOZACI_FAJL = "vozaci.txt";
    	public static String MUSTERIJE_FAJL = "musterija.txt";
    	public static String DISPECERI_FAJL = "dispeceri.txt";
    	public static String VOZILA_FAJL = "automobil.txt";
    	public static String VOZNJET_FAJL = "voznjet.txt";
    	public static String VOZNJEA_FAJL = "voznje.txt";
    	
    	
    	
    	
    	
    	
    	public static void main(String[] args) {
    		 TaksiSluzba taksiSluzba = new TaksiSluzba();
    	     TaksiSluzbai taksiSluzbai = new TaksiSluzbai();
    	     
    	
    		taksiSluzba.ucitajVozace(VOZACI_FAJL);
    		taksiSluzba.ucitajMusterije(MUSTERIJE_FAJL);
    		taksiSluzba.ucitajDispecere(DISPECERI_FAJL);
    		taksiSluzba.ucitajVozila(VOZILA_FAJL);
			taksiSluzba.ucitajVoznje(VOZNJEA_FAJL);
			taksiSluzba.ucitajVoznjet(VOZNJET_FAJL);

                
     
                
        
        
        Prijava p = new Prijava (taksiSluzba,taksiSluzbai);
        p.setVisible(true);
        
        
        
        

		
        
    }

        }
    








