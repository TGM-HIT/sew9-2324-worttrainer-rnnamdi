package model;

public class Main {
    public static void main(String[] args) {
        WortBildPaar wbp = new WortBildPaar("Hund","https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_640.jpg");
        Statistik st = new Statistik();
        Rechtschreibtrainer rt = new Rechtschreibtrainer(wbp,st);

        System.out.println(rt.antwortAbgleich("hund"));
        System.out.println(rt.antwortAbgleich("katze"));
        System.out.println(st.getVersuche());
    }

}
