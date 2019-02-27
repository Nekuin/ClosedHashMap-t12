package app;

public class KeyValuePair {
	
	private int key;
	private String data;
	
	public KeyValuePair(int key, String data) {
		this.key = key;
		this.data = data;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public String getData() {
		return this.data;
	}
	
	@Override
	public String toString() {
		return "Key: " + key + " value: " + data;
	}
}
