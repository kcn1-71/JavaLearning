
public class MyQSort {

	public static void qSort(int[] A, int left, int right) {
		int i = left, j = right;
		int p = A[i + (j - i) / 2];
		
		while (i <= j) {
			while (A[i] < p)
				i++;
			while (p < A[j])
				j--;
			if (i <= j) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i++;
				j--;
			}
		}
		if (left < j)
			qSort(A, left, j);
		if (i < right)
			qSort(A, i, right);
	}

	public static void main(String[] args) {
		int[] Arr = new int[] { 2, 7, 1, 7, 3, 7, 9, 7, 3, 7, 8, 5, 4, 7, 9, 7, 6, 6, 0 };
		qSort(Arr, 0, Arr.length - 1);
	}

}
