package com.lazic;

import korisnici.Dispeceri;
import korisnici.Musterija;
import korisnici.Vozaci;
import taksiSluzba.TaksiSluzba;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("fs");
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

        }




    }



