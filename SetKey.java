public class SetKey implements Operation {
    private final KeyValueStore keyValueStore;
    String key;
    String value;

    public SetKey(KeyValueStore keyValueStore, String key, String value) {
        this.keyValueStore = keyValueStore;
        this.key = key;
        this.value = value;
    }
    @Override
    public void execute() {
        keyValueStore.setKey(key, value);

    }
    
}