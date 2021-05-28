package com.lazic;

import gui.Prijava;

import korisnici.Dispeceri;
import korisnici.Musterija;
import korisnici.Vozaci;
import taksiSluzba.TaksiSluzba;
import vozila.Automobil;
import voznje.Voznja;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TaksiSluzba taksiSluzba = new TaksiSluzba();
        for (Dispeceri dispecer: taksiSluzba.getDispeceri()
             ) {
            System.out.println(dispecer.getIme());

        }
        taksiSluzba.snimiDispecere("dispeceri.txt");
        for (Musterija musterija : taksiSluzba.getMusterije()
        ) {
            System.out.println(musterija.getIme());

        }
        taksiSluzba.snimiMusterije("musterija.txt");
        for (Vozaci vozac: taksiSluzba.getVozaci()
             ) {
            System.out.println(vozac.getIme());

        }
        taksiSluzba.snimiVozace("vozaci.txt");
        for (Automobil automobil : taksiSluzba.getVozila()
        ) {
            System.out.println(automobil.getModel());

        }
        taksiSluzba.snimiVozila("automobil.txt");

         for (Voznja voznja : taksiSluzba.getVoznje()
        ) {
            System.out.println(voznja.getId());

        }
        taksiSluzba.snimiVoznje("voznje.txt");
        
        
        
        
        Prijava p = new Prijava();
		p.setVisible(true);
		
        
    

        }
    




    }



