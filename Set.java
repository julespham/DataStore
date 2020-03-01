public class Set implements Operation {
    private final KeyValueStore keyValueStore;
    String key;
    String value;

    public Set(KeyValueStore keyValueStore, String key, String value) {
        this.keyValueStore = keyValueStore;
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {
        keyValueStore.set(key, value);
    }
}