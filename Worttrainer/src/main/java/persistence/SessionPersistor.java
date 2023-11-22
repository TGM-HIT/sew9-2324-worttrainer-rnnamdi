package persistence;

import model.Rechtschreibtrainer;

public interface SessionPersistor {
    void save(Rechtschreibtrainer rechtschreibtrainer, String filePath);
    void load(Rechtschreibtrainer rechtschreibtrainer, String filePath);
}
