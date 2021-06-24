package voznje;


import enumi.Status;
import enumi.TipPorucivanja;
import korisnici.Musterija;
import korisnici.Vozaci;

import java.time.LocalDateTime;

public class VoznjaAplikacija extends Voznja {
	
    private String napomena;
    private final TipPorucivanja tipPorucivanja = TipPorucivanja.APLIKACIJOM;
    
    
   
    public VoznjaAplikacija(
            long id,
            String datumIVremePoruzbine,
            String adresaPolaska,
            String adresaDestinacije,
            long musterijaId,
            Musterija musterija,
            long vozacId,
            Vozaci vozac,
            int brojPredjenihKilometara,
            int trajanjeVoznje,
            Status status,
            boolean obrisan,
            int cijena,
            TipPorucivanja tipPorucivanja,
            String napomena
    )
    {
        super(id, datumIVremePoruzbine, adresaPolaska, adresaDestinacije,
                musterijaId, musterija, vozacId, vozac,
                brojPredjenihKilometara, trajanjeVoznje, status, obrisan,cijena);
        this.napomena = napomena;

    }

    public TipPorucivanja getTipPorucivanja() {
        return tipPorucivanja;
    }
   

    public String getNapomena() {
        return napomena;
    }
    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    
}
