public class End implements Operation {
    private final KeyValueStore keyValueStore;

    public End(KeyValueStore keyValueStore) {
        this.keyValueStore = keyValueStore;
    }

    @Override
    public void execute() {
        keyValueStore.end();

    }
    
}