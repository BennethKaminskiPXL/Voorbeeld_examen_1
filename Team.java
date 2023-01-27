package be.pxl.opgave;

import java.util.ArrayList;
import java.util.Arrays;

/* naam: Benneth */
public class Team {
    private Sport sport;
    private Speler[] spelers;

    public Team(Sport sport) {
        this.sport = sport;
        this.spelers = new Speler[sport.getAantalSpelers()];
    }

    public void voegSpelerToe(Speler speler){
        if (speler.getSport() == this.sport
            && !spelerKomtVoor(speler)
            && vindVrijePositie()!= -1){
            spelers[vindVrijePositie()]=speler;
        }
        else {
            System.out.println("FOUTIEVE INGAVE");
        }
    }
    public  boolean spelerKomtVoor(Speler speler){
        for (Speler teamspeler :
               spelers ) {
        if (teamspeler != null && speler.getId().equals(teamspeler.getId())){
                            return true;
            }
        }
        return false;
    }
    public int vindVrijePositie(){
        for (int i = 0; i < spelers.length; i++) {
            if (spelers[i] == null){
                return i;
            }
        } return -1;
    }
    public boolean spelerIdKomtVoor(String spelerid) {
        return spelerKomtVoor(new Speler(spelerid));

    }

    @Override
    public String toString() {
        if (vindVrijePositie() != -1){
            return "Onvolledig team";
        }
        StringBuilder teambouwer = new StringBuilder();
        for (Speler teamspeler :
                spelers) {
            teambouwer.append(teamspeler.toString());
            teambouwer.append("\n");
        }
        return teambouwer.toString();
    }
}

