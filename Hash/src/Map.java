import java.util.Arrays;

public class Map {

	int size;
	String[] keys;
	int[] values;

	Map(int size) {

		this.size = size * 10;
		keys = new String[this.size];
		values = new int[this.size];
		Arrays.fill(keys, null);
	}

	private int hash(String s) {
		int hash = 2128456234;
		for (int i = 0; i < s.length(); i++)
			hash = hash * 37 + s.charAt(i);
		return hash;
	}

	private int index(int hash) {
		int ind = Math.abs(hash) % size;
		return ind;
	}

	void add(String key, int value) {
		for (int i = index(hash(key));; i++) {

			if (i == size)
				i = 0;
			if (keys[i] == null) {
				keys[i] = key;
			}
			if (keys[i] == key) {
				values[i] = value;
				return;
			}
		}
	}

	int get(String key) {
		for (int i = index(hash(key));; i++) {
			if (i == size)
				i = 0;
			if (keys[i] == null)
				throw new RuntimeException("No such key!");
			if (keys[i] == key) {
				return values[i];
			}
		}
	}

	public static void main(String[] args) {
		Map m1 = new Map(10);
		m1.add("a1", 21);
		m1.add("a2", 22);
		m1.add("a3", 23);
		m1.add("a4", 24);
		m1.add("a5", 25);
		m1.add("a6", 26);
		m1.add("a7", 27);
		m1.add("a8", 28);
		m1.add("a9", 29);
		m1.add("b1", 31);
		m1.add("b2", 32);
		m1.add("b3", 33);
		m1.add("b4", 34);
		m1.add("b5", 35);
		
		System.out.print(m1.get("a1")+"\n");
		System.out.print(m1.get("a8")+"\n");
		@SuppressWarnings("resource")
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		@SuppressWarnings("unused")
		String x = scanner.nextLine();
	}

}
