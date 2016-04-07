
public class ShakerSortAgain {

	public static void shSort(int[] a) {

		int left = 0;
		int right = a.length - 1;

		while (left <= right) {

			for (int i = left; i < right; i++) {
				if (a[i] > a[i + 1]) {
					a[i] ^= a[i + 1];
					a[i + 1] ^= a[i];
					a[i] ^= a[i + 1];
				}
			}
			right--;

			for (int i = right; i > left; i--) {
				if (a[i] < a[i - 1]) {
					a[i] ^= a[i - 1];
					a[i - 1] ^= a[i];
					a[i] ^= a[i - 1];
				}
			}
			left++;
		}

	}

	public static void main(String[] args) {
		int[] A = new int[] { 2, 4, 1, 5, 3, 7, 9, 34, 3, 7, 8, 5, 4, 3, 9, 9, 6, 6 };
		shSort(A);
	}

}
