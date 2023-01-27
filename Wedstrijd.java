package be.pxl.opgave;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/* naam: Benneth */
public class Wedstrijd implements DatumVergelijkbaar{
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
    private LocalDateTime wedstrijdDatum;
    private Team team1;
    private Team team2;
    private Scheidsrechter scheidsrechter;
    private int scoreTeam1;
    private int scoreTeam2;

    public Wedstrijd(Team team1, Team team2, Scheidsrechter scheidsrechter, int dag, int maand, int jaar, int uur, int minuut) {
        this.team1 = team1;
        this.team2 = team2;
        this.scheidsrechter = scheidsrechter;
        wedstrijdDatum = LocalDateTime.of(jaar,maand,dag,uur,minuut);
    }
    public boolean spelerIdKomtVoor(String spelerId){
        if(team1 != null && team2 != null){
        if (team1.spelerIdKomtVoor(spelerId) || team2.spelerIdKomtVoor(spelerId)){
            return true;
        }}
        return false;
    }

    @Override
    public long berekenAantalMinutenNa(LocalDateTime localDateTime) {
        long aantalminuten = ChronoUnit.MINUTES.between(wedstrijdDatum,localDateTime);
        return aantalminuten;
    }

    public LocalDateTime getWedstrijdDatum() {
        return wedstrijdDatum;
    }

    public void setScore(int scoreTeam1, int scoreTeam2){
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
    }

    @Override
    public String toString() {
        if (berekenAantalMinutenNa(LocalDateTime.now()) > 0) {
            return "Team 1\n" +
                    team1 +
                    "Team 2\n" + team2 +
                    wedstrijdDatum.format(FORMAT) + "\n"
                    + scheidsrechter +
                    "\nScore " + scoreTeam1 +
                    " " + scoreTeam2;
        }
        return "Team 1\n" +
                team1 + "\n" +
                "Team 2\n" + team2 +
                wedstrijdDatum.format(FORMAT) + "\n"
                + scheidsrechter;
    }
}

