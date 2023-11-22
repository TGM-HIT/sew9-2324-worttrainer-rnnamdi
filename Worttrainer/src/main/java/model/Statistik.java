package model;

/**
 * Die Klasse {@code Statistik} repräsentiert die Statistik für den Rechtschreibtrainer.
 */

public class Statistik {
    private int versuche;
    private int korrekteVersuche;
    private int falscheVersuche;

    /**
     * Erstellt eine neue Instanz der Klasse {@code Statistik} mit initialen Werten für Versuche, korrekte und falsche Versuche.
     */
    public Statistik(){
        versuche=0;
        korrekteVersuche=0;
        falscheVersuche=0;
    }

    /**
     * Registriert einen Versuch in der Statistik basierend auf dem Ergebnis.
     *
     * @param isCorrect Gibt an, ob der Versuch korrekt war.
     */

    public void versuchRecord(boolean isCorrect) {
        versuche++;
        if (isCorrect) {
            korrekteVersuche++;
        } else {
            falscheVersuche++;
        }
    }

    public int getVersuche() {
        return versuche;
    }

    public int getKorrekteVersuche() {
        return korrekteVersuche;
    }

    public int getFalscheVersuche() {
        return falscheVersuche;
    }

    public void setVersuche(int versuche) {
        this.versuche=versuche;
    }

    public void setKorrekteVersuche(int korrekteVersuche) {
        this.korrekteVersuche=korrekteVersuche;
    }

    public void setFalscheVersuche(int falscheVersuche) {
        this.falscheVersuche=falscheVersuche;
    }
}
