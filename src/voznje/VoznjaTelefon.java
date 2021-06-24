package voznje;

import enumi.Status;
import enumi.TipPorucivanja;
import korisnici.Musterija;
import korisnici.Vozaci;

import java.time.LocalDateTime;

public class VoznjaTelefon extends Voznja {
    private final TipPorucivanja tipPorucivanja = TipPorucivanja.TELEFONOM;
    public VoznjaTelefon(
            long id, String datumIVremePoruzbine, String adresaPolaska,
            String adresaDestinacije, long musterijaId, Musterija musterija,
            long vozacId, Vozaci vozac, int brojPredjenihKilometara,
            int trajanjeVoznje, Status status, boolean obrisan,int cijena, TipPorucivanja tipPorucivanja
    ){
        super(id, datumIVremePoruzbine, adresaPolaska, adresaDestinacije,
                musterijaId, musterija, vozacId, vozac, brojPredjenihKilometara, trajanjeVoznje, status, obrisan,cijena);

    }

    public TipPorucivanja getTipPorucivanja() {
        return tipPorucivanja;
    }
}
