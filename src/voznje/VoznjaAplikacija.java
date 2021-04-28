package voznje;


import enumi.Status;
import enumi.TipPorucivanja;
import korisnici.Musterija;
import korisnici.Vozaci;

import java.time.LocalDateTime;

public class VoznjaAplikacija extends Voznja {
    private final TipPorucivanja tipPorucivanja = TipPorucivanja.APLIKACIJOM;
    public VoznjaAplikacija(
            long id, LocalDateTime datum_i_vreme_poruzbine, String adresa_polaska, String adresa_destinacije, long musterija_id, Musterija musterija, long vozac_id, Vozaci vozac, int broj_predjenih_kilometara, LocalDateTime trajanje_voznje, Status status, TipPorucivanja tipPorucivanja
    ){
        super(id, datum_i_vreme_poruzbine, adresa_polaska, adresa_destinacije, musterija_id, musterija, vozac_id, vozac, broj_predjenih_kilometara, trajanje_voznje, status);

    }

    public TipPorucivanja getTipPorucivanja() {
        return tipPorucivanja;
    }
}
