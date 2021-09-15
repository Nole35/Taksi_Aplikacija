package aisp;

import korisnici.Vozaci;
import korisnici.Musterija;
import korisnici.Dispeceri;
import vozila.Automobil;
import kolekcije.DoubleLinkedList;

public class BinarnaPretraga {
    public Vozaci pronadjiVozacaBinarySearch(DoubleLinkedList<Vozaci> array, long target){ // Ukloniti static
        return binarySearchVozaca(array, target, 0, array.size());
    }

    public  Vozaci binarySearchVozaca(DoubleLinkedList<Vozaci> array, long target, long low, long high){ // Ukloniti static

        if(low > high){
            return null;
        }
        long mid = (low + high) / 2;

        if (array.getElement(mid).getId() == target){
            return array.getElement(mid);
        } else if (array.getElement(mid).getId() > target){
            return  binarySearchVozaca(array, target, low, mid-1);
        } else {
            return binarySearchVozaca(array, target, mid + 1, high);
        }
    }


    public  Automobil pronadjiAutomobilBinarySearch(DoubleLinkedList<Automobil> array, int target){ // Ukloniti static
        return binarySearchAutomobil(array, target, 0, array.size());
    }

    public  Automobil binarySearchAutomobil(DoubleLinkedList<Automobil> array, int target, int low, int high){ // Ukloniti static

        if(low > high){
            return null;
        }
        int mid = (low + high) / 2;

        if (array.getElement(mid).getId() == target){
            return array.getElement(mid);
        } else if (array.getElement(mid).getId() > target){
            return  binarySearchAutomobil(array, target, low, mid-1);
        } else {
            return binarySearchAutomobil(array, target, mid + 1, high);
        }
    }


}
