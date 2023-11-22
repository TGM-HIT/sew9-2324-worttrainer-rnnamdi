package gui;

import model.Rechtschreibtrainer;
import model.WortBildPaar;
import persistence.SessionPersistor;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
/**
 * Die Klasse {@code WorttrainerGUI} stellt die grafische Benutzeroberfläche für den Rechtschreibtrainer bereit.
 * Sie ermöglicht die Interaktion mit dem Benutzer, um Wort-Bild-Paare zu überprüfen und Statistiken anzuzeigen.
 */
public class WorttrainerGUI {
    private Rechtschreibtrainer rt;
    private SessionPersistor pt;

    /**
     * Erstellt eine neue Instanz der Klasse {@code WorttrainerGUI}.
     *
     * @param rt       Der Rechtschreibtrainer, der von der GUI verwendet wird.
     * @param pt für das Speichern und Laden von Sitzungsdaten verwendet wird.
     */
    public WorttrainerGUI(Rechtschreibtrainer rt , SessionPersistor pt){
        this.rt=rt;
        this.pt=pt;
    }

    /**
     * Führt den Bildabgleich für jedes Wort-Bild-Paar durch und ermöglicht dem Benutzer die Eingabe von Antworten.
     * Aktualisiert die Statistik nach jedem Abgleich.
     */
    public void bildAbgleich(){
        for (WortBildPaar wortBildPaar : rt.getWortBildPaare()) {
            URL url = null;
            try {
                url = new URL(wortBildPaar.getBildUrl());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            ImageIcon bildIcon = new ImageIcon(url);

            JLabel bildLabel = new JLabel(bildIcon);
            bildLabel.setSize(new Dimension(30, 20));
            bildLabel.setIcon(bildIcon);

            String antwort = JOptionPane.showInputDialog(null, bildLabel, "GIb ein Wort ein", JOptionPane.QUESTION_MESSAGE);
            rt.antwortAbgleich(antwort);
            statistikAnzeigen();
        }
    }
    /**
     * Zeigt die Statistik in einem separaten Fenster an.
     */
    public void statistikAnzeigen(){
        JFrame frame = new JFrame("Statistik");

        JOptionPane.showMessageDialog(null,"Statistik: \n Insgesamt:"+rt.getStatistik().getVersuche()+"\n Korrekt: "+rt.getStatistik().getKorrekteVersuche()+"\n Falsch: "+rt.getStatistik().getFalscheVersuche());

    }

}
