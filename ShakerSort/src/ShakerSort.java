
public class ShakerSort {

	public static void ShSort(int[] Arr) {
		int left = 0;
		int right = Arr.length - 1;
		while (left <= right) {

			for (int i = left; i < right; i++) {
				if (Arr[i] > Arr[i + 1]) {
					Arr[i] ^= Arr[i + 1];
					Arr[i + 1] ^= Arr[i];
					Arr[i] ^= Arr[i + 1];
				}
			}
			right--;

			for (int i = right; i > left; i--) {
				if (Arr[i] < Arr[i - 1]) {
					Arr[i] ^= Arr[i - 1];
					Arr[i - 1] ^= Arr[i];
					Arr[i] ^= Arr[i - 1];
				}
			}
			left++;
		}
	}

	public static void main(String[] args) {
		int[] A = new int[] { 2, 4, 1, 5, 3, 7, 9, 34, 3, 7, 8, 5, 4, 3, 9, 9, 6, 6 };
		ShSort(A);
	}
}
