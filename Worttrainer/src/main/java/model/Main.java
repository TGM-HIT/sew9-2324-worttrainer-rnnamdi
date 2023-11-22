package model;

import gui.WorttrainerGUI;
import persistence.JSONSessionPersistor;

/**
 * Die Hauptklasse für das Rechtschreibtrainer-Programm. Startet die Anwendung und führt den Bildabgleich durch.
 */
public class Main {
    public static void main(String[] args) {
        WortBildPaar wbp = new WortBildPaar("Hund","https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_640.jpg");
        WortBildPaar wbp2 = new WortBildPaar("Katze", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Hauskatze_langhaar.jpg/1200px-Hauskatze_langhaar.jpg");
        WortBildPaar wbp3 = new WortBildPaar("Schlange", "https://media.os.fressnapf.com/cms/2020/05/Ratgeber-Terra-Schlange_blau_1200x527.jpg");
        JSONSessionPersistor jpt = new JSONSessionPersistor();


        Statistik st = new Statistik();
        Rechtschreibtrainer rt = new Rechtschreibtrainer(st);

        rt.wortBildPaarHinzufuegen(wbp);
        rt.wortBildPaarHinzufuegen(wbp2);
        rt.wortBildPaarHinzufuegen(wbp3);

        WorttrainerGUI wt = new WorttrainerGUI(rt,jpt);
            wt.bildAbgleich();

            jpt.save(rt, "persistenz.json");

        System.out.println(st.getVersuche());
    }

}
