package aisp;
import kolekcije.DoubleLinkedList;

public class Aukcija {private int idVoznje;
    private DoubleLinkedList<Ponuda> ponudeZaVoznju = new DoubleLinkedList<Ponuda>();

    public Aukcija(int idVoznje, Ponuda ponuda){
        this.idVoznje = idVoznje;
    }

    public int getIdVoznje() {
        return idVoznje;
    }

    public void setIdVoznje(int idVoznje) {
        this.idVoznje = idVoznje;
    }


    public DoubleLinkedList<Ponuda> getPonudeZaVoznju() {
        return ponudeZaVoznju;
    }

    public void setPonudeZaVoznju(DoubleLinkedList<Ponuda> ponudeZaVoznju) {
        this.ponudeZaVoznju = ponudeZaVoznju;
    }

    public void dodajPonuduUListu(Ponuda ponuda){
        this.ponudeZaVoznju.add(ponuda);
    }
}
