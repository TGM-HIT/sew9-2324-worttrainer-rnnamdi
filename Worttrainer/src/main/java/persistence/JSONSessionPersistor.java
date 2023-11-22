package persistence;

import model.Rechtschreibtrainer;
import model.WortBildPaar;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Diese Klasse implementiert die {SessionPersistor}-Schnittstelle und ermöglicht das Speichern
 * und Laden von {model.Rechtschreibtrainer}-Sitzungsinformationen in JSON-Dateien.
 */
public class JSONSessionPersistor implements SessionPersistor {

    /**
     * Speichert die aktuelle Sitzung (WortBildPaare und Statistik) in einer JSON-Datei.
     *
     * @param rechtschreibtrainer Die Instanz des Rechtschreibtrainers, von welhcher die Sitzung gespeichert werden soll.
     * @param filePath            Der Dateipfad, unter dem die JSON-Datei gespeichert wird.
     */
    @Override
    public void save(Rechtschreibtrainer rechtschreibtrainer, String filePath) {
        JSONObject json = new JSONObject();

        // Speichere Wort-Bild-Paare
        JSONArray wortBildPaareArray = new JSONArray();
        for (int i = 0; i < rechtschreibtrainer.getWortBildPaare().size(); i++) {
            JSONObject wortBildPaarJson = new JSONObject();
            wortBildPaarJson.put("Wort", rechtschreibtrainer.getWortBildPaare().get(i).getWort());
            wortBildPaarJson.put("BildUrl", rechtschreibtrainer.getWortBildPaare().get(i).getBildUrl());
            wortBildPaareArray.put(wortBildPaarJson);
        }
        json.put("WortBildPaare", wortBildPaareArray);

        // Speichere Statistik
        JSONObject statistikJson = new JSONObject();
        statistikJson.put("Versuche", rechtschreibtrainer.getStatistik().getVersuche());
        statistikJson.put("KorrekteVersuche", rechtschreibtrainer.getStatistik().getKorrekteVersuche());
        statistikJson.put("FalscheVersuche", rechtschreibtrainer.getStatistik().getFalscheVersuche());
        json.put("Statistik", statistikJson);

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(json.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lädt eine zuvor gespeicherte Sitzung (Wort-Bild-Paare und Statistik) aus einer JSON-Datei.
     *
     * @param rechtschreibtrainer Die Instanz des Rechtschreibtrainers, in die Daten eingelesen werden.
     * @param filePath            Der Dateipfad, von dem die JSON-Datei geladen wird.
     */
    @Override
    public void load(Rechtschreibtrainer rechtschreibtrainer, String filePath) {
        try {
            // Lese die Daten aus der JSON-Datei
            FileReader reader = new FileReader(filePath);
            JSONObject json = new JSONObject(reader);

            // Lade Wort-Bild-Paare
            JSONArray wortBildPaareArray = json.getJSONArray("WortBildPaare");
            for (int i = 0; i < wortBildPaareArray.length(); i++) {
                JSONObject wortBildPaarJson = wortBildPaareArray.getJSONObject(i);
                String wort = wortBildPaarJson.getString("Wort");
                String bildUrl = wortBildPaarJson.getString("BildUrl");

                rechtschreibtrainer.wortBildPaarHinzufuegen(new WortBildPaar(wort, bildUrl));
            }

            // Lade Statistik
            JSONObject statistikJson = json.getJSONObject("Statistik");
            int versuche = statistikJson.getInt("Versuche");
            int korrekteVersuche = statistikJson.getInt("KorrekteVersuche");
            int falscheVersuche = statistikJson.getInt("FalscheVersuche");

            rechtschreibtrainer.getStatistik().setVersuche(versuche);
            rechtschreibtrainer.getStatistik().setKorrekteVersuche(korrekteVersuche);
            rechtschreibtrainer.getStatistik().setFalscheVersuche(falscheVersuche);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
