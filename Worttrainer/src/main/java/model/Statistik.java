package model;

public class Statistik {
    private int versuche;
    private int korrekteVersuche;
    private int falscheVersuche;

    public Statistik(){
        versuche=0;
        korrekteVersuche=0;
        falscheVersuche=0;
    }

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
