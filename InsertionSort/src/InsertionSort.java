
public class InsertionSort {

	public static void InsSort(int[] Arr) {
		for (int j = 1; j < Arr.length; j++) {
			int key = Arr[j];
			int i = j - 1;
			while (i >= 0 && Arr[i] > key) {
				Arr[i + 1] = Arr[i];
				i--;
			}
			Arr[i + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] A = new int[] { 2, 4, 1, 5, 3, 7, 9, 34, 3, 7, 8, 5, 4, 3, 9, 9, 6, 6 };
		InsSort(A);
	}

}
