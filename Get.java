public class Get implements Operation {
    private final KeyValueStore keyValueStore;
    String key;

    public Get(KeyValueStore keyValueStore, String key) {
        this.keyValueStore = keyValueStore;
        this.key = key;
    }
    @Override
    public void execute() {
        keyValueStore.get(key);
    }
    
}