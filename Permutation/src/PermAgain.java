
public class PermAgain {

	public static void perm(String rez, String source) {

		String sr = source;
		String rz = rez;
		int ls = source.length();

		if (ls > 0) {
			for (int i = 0; i < ls; i++) {

				rz =rez + source.charAt(i);
				sr = source.substring(0, i) + source.substring(i+1, ls);
				perm(rz, sr);

			}
		} else {
			System.out.print(rez + "\n");
		}
	}

	public static void main(String[] args) {
		String rez = "";
		String source = "123";
		perm(rez, source);
	}

}
