package be.pxl.opgave;

import java.util.ArrayList;
import java.util.Arrays;

/* naam: Benneth */
public class Team {
    private Sport sport;
    private Speler[] spelers;

    public Team(Sport sport) {
        this.sport = sport;
        spelers = new Speler[sport.getAantalSpelers()];
    }

    public void voegSpelerToe(Speler speler){
        if (spelerKomtVoor(speler)){
            System.out.println("Foutieve Ingave");}
            else if (vindVrijePositie() == -1){
                System.out.println("Foutieve Ingave");
            } else {
                spelers[vindVrijePositie()] = speler;
            }
    }
    public  boolean spelerKomtVoor(Speler speler){
        for (Speler teamspeler :
               spelers ) {
        if (teamspeler != null){
            if (teamspeler.equals(speler)){
                return true;
            }}
        } return false;
    }
    public int vindVrijePositie(){
        for (int i = 0; i < spelers.length; i++) {
            if (spelers[i] == null){
                return i;
            }
        } return -1;
    }
    public boolean spelerIdKomtVoor(String spelerid) {
        Speler nieuwespeler = new Speler(spelerid);
        for (Speler teamspelers :
                spelers) {
            if (teamspelers != null){
            if (nieuwespeler.equals(teamspelers)) {
                return true;
            }}
        } return false;
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

