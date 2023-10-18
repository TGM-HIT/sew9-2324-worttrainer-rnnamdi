package gui;

import model.Rechtschreibtrainer;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class WorttrainerGUI {
    private Rechtschreibtrainer rt;

    public WorttrainerGUI(Rechtschreibtrainer rt){
        this.rt=rt;
    }

    public void bildAbgleich() throws MalformedURLException {
        URL url = new URL(rt.getAusgewählteBildUrl());
        ImageIcon bildIcon = new ImageIcon(url);

        JLabel bildLabel = new JLabel(bildIcon);
        bildLabel.setSize(new Dimension(30,20));
        bildLabel.setIcon(bildIcon);

        String antwort = JOptionPane.showInputDialog(null,bildLabel,"GIb ein Wort ein",JOptionPane.QUESTION_MESSAGE);
        rt.antwortAbgleich(antwort);
    }
    public void statistikAnzeigen(){
        JFrame frame = new JFrame("Statistik");

        JOptionPane.showMessageDialog(null,"Statistik: \n Insgesamt:"+rt.getStatistik().getVersuche()+"\n Korrekt: "+rt.getStatistik().getKorrekteVersuche()+"\n Falsch: "+rt.getStatistik().getFalscheVersuche());

    }

}
