package storage;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private static final List<String> storage = new ArrayList<>();

    public synchronized String get(int index) {
        return storage.get(index);
    }

    public synchronized void add(String data) {
        storage.add(data);
    }

    public void addAll(List<String> data) {
        storage.addAll(data);
    }

    public List<String> getAll() {
        return storage;
    }
}
