
public class MyQSort {

	public static void QSort(int[] A, int left, int right) {
		if (left >= right)
			return;
		int i = left, j = right;
		int p = i - (i - j) / 2;
		while (i < j) {
			while ((A[i] <= A[p]) && (i < p)) {
				i++;
			}
			while ((A[p] <= A[j]) && (j > p)) {
				j--;
			}
			if (i < j) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				if (i == p)
					p = j;
				else if (j == p)
					p = i;

			}
		}
		QSort(A, left, p);
		QSort(A, p + 1, right);
	}

	public static void main(String[] args) {
		int[] Arr = new int[] { 2, 4, 1, 5, 3, 7, 9, 7, 3, 7, 8, 5, 4, 3, 9, 9, 6, 6 };
		QSort(Arr, 0, Arr.length - 1);
	}

}
