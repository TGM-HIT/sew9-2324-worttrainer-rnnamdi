package model;

/**
 * Die Klasse {@code WortBildPaar} repräsentiert ein Paar aus einem Wort und einer Bild-URL.
 */
public class WortBildPaar {
    private String wort;
    private String bildUrl;

    /**
     * Erstellt ein neues Wort-Bild-Paar mit dem angegebenen Wort und der Bild-URL.
     *
     * @param wort    Das Wort des Paars.
     * @param bildUrl Die Bild-URL des Paars.
     */

    public WortBildPaar(String wort, String bildUrl){
        this.wort=wort;
        this.bildUrl=bildUrl;
    }

    /**
     * Gibt das Wort des Wort-Bild-Paars zurück.
     *
     * @return Das Wort des Paars.
     */
    public String getWort() {
        return wort;
    }

    /**
     * Gibt die Bild-URL des Wort-Bild-Paars zurück.
     *
     * @return Die Bild-URL des Paars.
     */
    public String getBildUrl() {
        return bildUrl;
    }

    /**
     * Setzt das Wort des Wort-Bild-Paars.
     *
     * @param wort Das zu setzende Wort.
     */
    public void setWort(String wort) {
        this.wort = wort;
    }
    /**
     * Setzt die Bild-URL des Wort-Bild-Paars.
     *
     * @param bildUrl Die zu setzende Bild-URL.
     */
    public void setBildUrl(String bildUrl) {
        this.bildUrl = bildUrl;
    }

    /**
     * Überprüft, ob das Wort-Bild-Paar gültig ist, indem überprüft wird, ob sowohl das Wort als auch die Bild-URL nicht null oder leer sind.
     *
     * @return {@code true}, wenn das Wort-Bild-Paar gültig ist, andernfalls {@code false}.
     */
    public boolean isValid() {
        return wort != null && !wort.isEmpty() && bildUrl != null && !bildUrl.isEmpty();
    }
}
