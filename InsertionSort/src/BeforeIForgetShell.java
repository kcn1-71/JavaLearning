
public class BeforeIForgetShell {

	public static void ShellsSort(int[] a) {

		int[] gapsArr = { 1, 4, 10, 23 };
		int m = 0, j, i, key, gap;

		while (gapsArr[m] < a.length)
			m++;

		while (--m >= 0) {

			gap = gapsArr[m];
			for (i = gap; i < a.length; i++) {
				j = i;
				key = a[j];
				while (j >= gap && a[j - gap] > key) {
					a[j] = a[j - gap];
					j -= gap;
				}
				a[j] = key;
			}
		}
	}

	public static void main(String[] args) {
		int[] A = new int[] { 2, 4, 1, 5, 3, 7, 9, 34, 3, 7, 8, 5, 4, 3, 9, 9, 6, 6 };
		ShellsSort(A);
	}
}
