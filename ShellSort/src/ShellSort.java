
public class ShellSort {

	public static void sort_shell(int[] a) {
		int i, j, k, h, m = 0, b = a.length;
		int[] d = { 1, 4, 10, 23, 57, 145, 356, 911, 1968, 4711};
		while (d[m] < b)
			++m;
		
		while (--m >= 0) {
			k = d[m];
			for (i = k; i < b; i++) { // k-сортировка
				j = i;
				h = a[i];
				while ((j >= k) && (a[j - k] > h)) {
					a[j] = a[j - k];
					j -= k;
				}
				a[j] = h;
			}
		}
	}

	public static void main(String[] args) {
		int[] A = new int[] { 2, 4, 1, 5, 3, 7, 9, 34, 3, 7, 8, 5, 4, 3, 9, 9, 6, 6 };
		sort_shell(A);

	}

}
