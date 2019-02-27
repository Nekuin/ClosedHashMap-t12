package app;

public class ClosedHashMain {

	public static void main(String[] args) {
		ClosedHashMap map = new ClosedHashMap();
		
		map.put(5, "viis");
		map.put(204, "204");
		map.put(1, "yks");
		map.put(2, "kaks");
		map.put(14, "14");
		map.print();
		
		System.out.println("get: " + map.get(5));
		System.out.println("");
		System.out.println("get: " + map.get(14));
		System.out.println("");
		System.out.println("get: " + map.get(0));
	}

}
