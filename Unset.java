public class Unset implements Operation {
    private final KeyValueStore KeyValueStore;
    String key;
    public Unset(KeyValueStore keyValueStore, String key) {
        this.KeyValueStore = keyValueStore;
        this.key = key;
    }
	@Override
	public void execute() {
		KeyValueStore.unsetKey(key);
		
	}
    
}