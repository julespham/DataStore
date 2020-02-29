public class GetValue implements Operation {
    private final KeyValueStore keyValueStore;
    String key;

    public GetValue(KeyValueStore keyValueStore, String key) {
        this.keyValueStore = keyValueStore;
        this.key = key;
    }
    @Override
    public void execute() {
        keyValueStore.getValue(key);
    }
    
}