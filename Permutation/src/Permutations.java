public class Permutations {

	public static void Permut(String rez, String source) {
		String src = source;
		String rz = rez;
		int ls = source.length();
		if (ls > 0) {
			for (int i = 0; i < ls; i++) {
				rz = rez + source.charAt(i);
				String sub1 = source.substring(0, i);
				String sub2 = source.substring(i + 1, ls);
				src = sub1 + sub2;
				Permut(rz, src);
			}

		} else {
			System.out.print(rez + "\n");
		}

	}

	public static void main(String[] args) {
		String rez = "";
		String source = "123";
		Permut(rez, source);

	}

}
