import java.util.concurrent.ConcurrentHashMap;

public class KeyValueStore {
    ConcurrentHashMap<String, String> dataStore; 
    public KeyValueStore() {
        dataStore = new ConcurrentHashMap<>();
    }

    public void unsetKey(String key) {
        dataStore.remove(key);
    }

    public void setKey(String key, String value) {
        dataStore.putIfAbsent(key, value);
    }

    public void getValue(String key) {
        System.out.println(dataStore.getOrDefault(key, null));
    }

    public void exists(String key) {
        System.out.println(dataStore.containsKey(key));
    }

    public void end() {
        System.out.println("Chow");
    }

}