package be.pxl.opgave;

import java.util.Objects;

/* naam: Benneth*/
public abstract class Persoon{
    private String id;
    private String naam;

    public Persoon(String id, String naam) {
        StringBuilder idformat = new StringBuilder(id);
        for (int i = 0; i < idformat.length(); i++) {
            if (!Character.isWhitespace(idformat.charAt(i))){
                if (Character.isLetterOrDigit(i)){
                    idformat.append(i);
                }
            }
        }
        if (idformat.length()>= 3) {
            this.id = idformat.substring(0, 3).toUpperCase();
        } else {
        this.id = idformat.toString().toUpperCase();}
        this.naam = naam;
    }

    public String getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoon persoon = (Persoon) o;
        return Objects.equals(id, persoon.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "[" + this.id +
                "] " + naam;
    }
}

