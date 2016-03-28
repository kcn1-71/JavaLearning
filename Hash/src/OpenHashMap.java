import java.util.Arrays;

public class OpenHashMap {

	/* Простая реализация HashMap'а методом открытой адресации для стрингов */
	int size;
	String[] keys;
	int[] values;

	/* Конструктор */
	OpenHashMap(int size) {
		this.size = Math.max(3 * size / 2, size) + 1;
		keys = new String[this.size];
		values = new int[this.size];
		Arrays.fill(keys, null);
	}

	/* Добавляет пару в множество */
	void put(String x, int y) {
		for (int i = index(hash(x));; i++) {
			if (i == size)
				i = 0;
			if (keys[i] == null)
				keys[i] = x;
			if (keys[i] == x) {
				values[i] = y;
				return;
			}
		}
	}

	/* Извлекает значение */
	int get(String x) {
		for (int i = index(hash(x));; i++) {
			if (i == size)
				i = 0;
			if (keys[i] == null)
				throw new RuntimeException("No such key!");
			if (keys[i] == x)
				return values[i];
		}
	}

	/* хэш-функция (для других типов следует изменить) */
	int hash(String x) {
		
		int hash = 2139062143;

		for(int i =0; i<x.length(); i++)
			hash = 37 * hash + x.charAt(i);
		return hash;
	}

	/* возвращает номер головы по значению хэш-функции */
	int index(int hash) {
		return Math.abs(hash) % size;
	}

	public static void main(String[] args) {
		
		OpenHashMap m1 = new OpenHashMap(10);
		m1.put("a1", 21);
		m1.put("a2", 22);
		m1.put("a3", 23);
		m1.put("a4", 24);
		m1.put("a5", 25);
		m1.put("a6", 26);
		m1.put("a7", 27);
		m1.put("a8", 28);
		m1.put("a9", 29);
		m1.put("b1", 31);
		m1.put("b2", 32);
		m1.put("b3", 33);
		m1.put("b4", 34);
		m1.put("b5", 35);


		
		System.out.print(m1.get("a1"));
		System.out.print(m1.get("a8"));

	}

}
