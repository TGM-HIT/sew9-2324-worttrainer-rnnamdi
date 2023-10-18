package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;


public class Rechtschreibtrainer {
    private List<WortBildPaar> wortBildPaare;
    private WortBildPaar ausgewähltesPaar;
    private Statistik statistik;

    private boolean abgleich;

    public Rechtschreibtrainer(Statistik st){
        wortBildPaare = new ArrayList<>();
        this.statistik = st;
    }

    public void paarAuswählen(int index) {
        if (index >= 0 && index < wortBildPaare.size()) {
            ausgewähltesPaar = wortBildPaare.get(index);
        } else {
            // Index ist ungültig, handle den Fehler hier
            System.err.println("Ungültiger Index für die Auswahl eines Wort-Bild-Paares.");
        }
    }
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
    public String getAusgewählteBildUrl() {
        if (ausgewähltesPaar != null) {
            return ausgewähltesPaar.getBildUrl();
        } else {
            // Es wurde kein Wort-Bild-Paar ausgewählt.
            return null;
        }
    }

    public String getAktuellesWort() {
        if (ausgewähltesPaar != null) {
            return ausgewähltesPaar.getWort();
        } else {
            // Es wurde kein Wort-Bild-Paar ausgewählt.
            return null;
        }


    }
    public Statistik getStatistik() {
        return statistik;
    }
    public void wortBildPaarHinzufuegen(WortBildPaar wbpp){
        wortBildPaare.add(wbpp);
    }

    public List<WortBildPaar> getWortBildPaare(){
        return wortBildPaare;
    }








}
