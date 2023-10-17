package model;

public class WortBildPaar {
    private String wort;
    private String bildUrl;

    public WortBildPaar(String wort, String bildUrl){
        this.wort=wort;
        this.bildUrl=bildUrl;
    }
    public String getWort() {
        return wort;
    }

    public String getBildUrl() {
        return bildUrl;
    }

    public void setWort(String wort) {
        this.wort = wort;
    }

    public void setBildUrl(String bildUrl) {
        this.bildUrl = bildUrl;
    }

    public boolean isValid() {
        return wort != null && !wort.isEmpty() && bildUrl != null && !bildUrl.isEmpty();
    }
}
