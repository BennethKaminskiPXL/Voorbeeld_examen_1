package be.pxl.opgave;

import java.text.Format;
import java.time.LocalDateTime;

/* naam: Benneth */
public class Toernooi {
    private Wedstrijd[] wedstrijden;
    private static final int MAX_AANTAL_WEDSTRIJDEN = 10;

    public Toernooi(){
        wedstrijden = new Wedstrijd[MAX_AANTAL_WEDSTRIJDEN];
    }

    public void voegWedstrijdToe(Wedstrijd wedstrijd){
        boolean leeg = false;
        for (int i = 0; i < wedstrijden.length; i++) {
            if (wedstrijden[i] == null){
                wedstrijden[i] = wedstrijd;
                leeg = true;
                break;
            }
        }
        if (!leeg){
            System.out.println("Geen ruimte meer voor wedstrijden");
        }
    }
    public LocalDateTime zoekDatumVolgendeWedstrijdVan(String spelerid) {
        LocalDateTime datumvolgende;
        for (Wedstrijd wedstrijd :
                wedstrijden) {
            if (wedstrijd != null && wedstrijd.spelerIdKomtVoor(spelerid)){
                datumvolgende = wedstrijd.getWedstrijdDatum();
                return datumvolgende;
            }
        }
        return null;
    }
}

