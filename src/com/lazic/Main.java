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

   

 
    	
    	
    	
    	
    	
    	
    	public static void main(String[] args) {
    		 TaksiSluzba taksiSluzba = new TaksiSluzba();
    	     TaksiSluzbai taksiSluzbai = new TaksiSluzbai();
    	     System.out.println("Autombili");
    	     for (Automobil automobil:taksiSluzba.sviNeobrisaniAutomobili()
    				 ) {
    	    	
    	    	 
    				System.out.println(automobil);
    				 
    				

    			}
    	     System.out.println(" kraj Autombili");
    	     
    	
    		

                
     
                
        
        
        Prijava p = new Prijava (taksiSluzba,taksiSluzbai);
        p.setVisible(true);
        
        
        
        

		
        
    }

        }
    








