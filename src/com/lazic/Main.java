package com.lazic;

import korisnici.Dispeceri;
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

    }

}
