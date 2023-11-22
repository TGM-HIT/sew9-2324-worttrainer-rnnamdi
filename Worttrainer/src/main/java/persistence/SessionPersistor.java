package persistence;

import model.Rechtschreibtrainer;

/**
 * Das {@code SessionPersistor}-Interface definiert Methoden zum Speichern und Laden von Sitzungsinformationen für einen {@link Rechtschreibtrainer}.
 */
public interface SessionPersistor {

    /**
     * Speichert die Sitzungsinformationen des übergebenen Rechtschreibtrainers in einer Datei.
     *
     * @param rechtschreibtrainer Die Instanz des Rechtschreibtrainers, dessen Sitzungsinformationen gespeichert werden sollen.
     * @param filePath            Der Dateipfad, unter dem die Sitzungsinformationen gespeichert werden sollen.
     */
    void save(Rechtschreibtrainer rechtschreibtrainer, String filePath);

    /**
     * Lädt zuvor gespeicherte Sitzungsinformationen in einen Rechtschreibtrainer.
     *
     * @param rechtschreibtrainer Die Instanz des Rechtschreibtrainers, in die die geladenen Sitzungsinformationen eingelesen werden sollen.
     * @param filePath            Der Dateipfad, von dem die Sitzungsinformationen geladen werden sollen.
     */
    void load(Rechtschreibtrainer rechtschreibtrainer, String filePath);
}
