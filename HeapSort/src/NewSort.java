
public class NewSort {

	private static int heapsize;

	private static int left(int i) {
		return i * 2 + 1;
	}

	private static int right(int i) {
		return i * 2 + 2;
	}

	private static void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

	private static void heapify(int[] A, int i) {
		int left = left(i);
		int right = right(i);
		int largest = i;

		if (right < heapsize && A[right] > A[largest]) {
			largest = right;
		}
		if (left < heapsize && A[left] > A[largest]) {
			largest = left;
		}

		if (i != largest) {
			swap(A, largest, i);
			heapify(A, largest);
		}
	}

	private static void buildheap(int[] A) {
		heapsize = A.length;
		for (int i = heapsize / 2 - 1; i >= 0; i--) {
			heapify(A, i);
		}
	}

	public static void sort(int[] A) {
		buildheap(A);
		while (heapsize > 1) {
			swap(A, 0, heapsize - 1);
			heapsize--;
			heapify(A, 0);
		}
	}

	public static void main(String[] args) {
		int[] Arr = new int[] { 3, 2, 1, 5, 4, 7, 8, 8, 9, 6, 6, 1, 1, 5, 5, 5, 4, 4, 7, 8, 8, 66, 4, 4, 2, 2, 1, 4, 6,
				6, 4, 4, 2, 65, 0 };
		sort(Arr);
	}

}
