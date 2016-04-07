
public class ShellSortAgain {

	public static void sort_shell(int[] a) {

		int i, j, key, gap, ls = a.length, m = 0;

		int[] d = { 1, 4, 10, 23, 57, 145, 356, 911, 1968, 4711 };

		while (d[m] < ls)
			++m;

		while (--m >= 0) {
			gap = d[m];

			for (i = gap; i < ls; i++) {
				j = i;
				key = a[j];
				while (j >= gap && key < a[j - gap]) {
					a[j] = a[j - gap];
					j -= gap;
				}
				a[j]=key;
			}

		}
	}

	public static void main(String[] args) {

		int[] A = new int[] { 2, 4, 1, 5, 3, 7, 9, 34, 3, 7, 8, 5, 4, 3, 9, 9, 6, 6 };
		sort_shell(A);

	}

}
