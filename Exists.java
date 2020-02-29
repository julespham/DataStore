public class Exists implements Operation {
    private final KeyValueStore keyValueStore;
    String key;

    public Exists(KeyValueStore keyValueStore, String key) {
        this.keyValueStore = keyValueStore;
        this.key = key;
    }

    @Override
    public void execute() {
        keyValueStore.exists(key);

    }
    
}