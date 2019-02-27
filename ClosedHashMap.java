package app;

public class ClosedHashMap {
	
	private KeyValuePair[] arr;
	private int ARR_SIZE = 19;
	
	public ClosedHashMap() {
		this.arr = new KeyValuePair[ARR_SIZE];
	}
	
	public void put(int key, String value) {
		KeyValuePair kvp = new KeyValuePair(key, value);
		System.out.println("Insert new pair: " + kvp);
		int hash = hash(key);
		System.out.println("hash: " + hash);
		
		//empty slot
		if(arr[hash] == null) {
			System.out.println("n: " + key + " to index " + hash);
			arr[hash] = kvp;
		} else {
			System.out.println("index " + hash + " already has a value");
			//not empty slot
			int i = 1;
			int newHash = 0;
			boolean succeeded = false;
			while(!succeeded) {
				newHash = hash+(i*i);
				System.out.println("new hash: " + newHash);
				if(newHash >= ARR_SIZE) {
					System.out.println("couldn't fit value " + value);
					return;
				}
				if(arr[newHash] == null) {
					arr[newHash] = kvp;
					succeeded = true;
					System.out.println("n " + key + " to index " + newHash);
				}
				i++;
			}
		}
	}
	
	private int hash(int n) {
		return (n % ARR_SIZE);
	}
	
	public String get(int n) {
		System.out.println("Getting value for key: " + n);
		int hash = hash(n);
		System.out.println("hash: " + hash);
		KeyValuePair kvp = arr[hash];
		if(kvp == null) {
			System.out.println("key doesn't exist");
			return null;
		}
		
		//wrong key
		if(kvp.getKey() != n) {
			System.out.println("wrong pair");
			int i = 1;
			int newHash = 0;
			boolean succeeded = false;
			while(!succeeded) {
				newHash = hash+(i*i);
				System.out.println("new hash: " + newHash);
				if(newHash >= ARR_SIZE) {
					System.out.println("key doesn't exist");
					return null;
				}
				kvp = arr[newHash];
				if(kvp.getKey() == n) {
					return kvp.getData();
				}
				i++;
			}
			
		} else {
			//right key
			return kvp.getData();
		}
		return null;
	}
	
	public void print() {
		System.out.println("-----------");
		int j = 0;
		for(KeyValuePair i : arr) {
			if(i != null) {
				System.out.println("" + i + " index: " + j);
			}
			j++;
		}
		System.out.println("-----------");
	}
	
}
