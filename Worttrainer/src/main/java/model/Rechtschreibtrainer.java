package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/**
 * Die Klasse {@code Rechtschreibtrainer} repräsentiert den Rechtschreibtrainer mit Wort-Bild-Paaren und Statistik.
 */
public class Rechtschreibtrainer {
    private List<WortBildPaar> wortBildPaare;
    private WortBildPaar ausgewähltesPaar;
    private Statistik statistik;

    private boolean abgleich;

    /**
     * Erstellt einen neuen Rechtschreibtrainer mit der angegebenen Statistik.
     *
     * @param st Die Statistik für den Rechtschreibtrainer.
     */
    public Rechtschreibtrainer(Statistik st){
        wortBildPaare = new ArrayList<>();
        this.statistik = st;
    }

    /**
     * Wählt ein Paar aus.
     *
     * @param index Index des Paares.
     */
    public void paarAuswählen(int index) {
        if (index >= 0 && index < wortBildPaare.size()) {
            ausgewähltesPaar = wortBildPaare.get(index);
        } else {
            // Index ist ungültig, handle den Fehler hier
            System.err.println("Ungültiger Index für die Auswahl eines Wort-Bild-Paares.");
        }
    }

    /**
     * Wählt ein zufälliges Paar aus.
     *
     */
    public void selectRandomPair() {
        if (wortBildPaare.isEmpty()) {
            // Die Liste ist leer, es gibt keine Paare zum Auswählen.
            return;
        }

        // Einen zufälligen Index auswählen
        Random random = new Random();
        int randomIndex = random.nextInt(wortBildPaare.size());

        // Das zufällige Wort-Bild-Paar auswählen und in selectedPair speichern
        ausgewähltesPaar = wortBildPaare.get(randomIndex);
    }
    /**
     * Vergleicht das eingegebene Wort mit dem eigentlichen Wort des Paares.
     *
     * @param antwort eingegeben Wort des Benutzers.
     * @return richtig oder falsch
     */

    public boolean antwortAbgleich(String antwort) {
        abgleich=false;
        for(WortBildPaar wbp:wortBildPaare) {
            String korrektesWort = wbp.getWort();

            // Vergleichen Sie die Benutzerantwort (ignoriere Groß-/Kleinschreibung)


            if (antwort.equalsIgnoreCase(korrektesWort)) {
                abgleich = true;
                break;
            }


        }
        // Aktualisieren Sie die Statistiken basierend auf dem Ergebnis
        if (abgleich) {
            statistik.versuchRecord(true);
        } else {
            statistik.versuchRecord(false);
        }
        return abgleich;

    }
    /**
     * Url des Paares
     * @return Url des aares
     */
    public String getAusgewählteBildUrl() {
        if (ausgewähltesPaar != null) {
            return ausgewähltesPaar.getBildUrl();
        } else {
            // Es wurde kein Wort-Bild-Paar ausgewählt.
            return null;
        }
    }

    /**
     * Aktuelles Wort
     *
     * @return Wort des Paares.
     */
    public String getAktuellesWort() {
        if (ausgewähltesPaar != null) {
            return ausgewähltesPaar.getWort();
        } else {
            // Es wurde kein Wort-Bild-Paar ausgewählt.
            return null;
        }


    }
    /**
     * Wählt ein Paar aus.
     *
     * @return Statistik.
     */
    public Statistik getStatistik() {
        return statistik;
    }

    /**
     * Fügt ein Paar hinzu
     *
     * @param wbpp Das Paar das hinzugefügt wird.
     */
    public void wortBildPaarHinzufuegen(WortBildPaar wbpp){
        wortBildPaare.add(wbpp);
    }

    /**
     * Holst die Paare.
     *
     * @retun Paare.
     */
    public List<WortBildPaar> getWortBildPaare(){
        return wortBildPaare;
    }








}
