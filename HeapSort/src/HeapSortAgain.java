
public class HeapSortAgain {

	static int size;

	private static int left(int i) {
		return (i * 2) + 1;
	}

	private static int right(int i) {
		return (i * 2) + 2;
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private static void heapify(int[] arr, int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;

		if (l < size && arr[l] > arr[largest])
			largest = l;
		if (r < size && arr[r] > arr[largest])
			largest = r;
		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, largest);
		}
	}
	
	private static void formTree(int[] arr){
		size = arr.length;
		for (int i = size/2+1; i>=0; i--){
			heapify(arr, i);
		}
	}

	public static void hSort(int[] arr){
		formTree(arr);
		while (size>0){
			swap(arr, 0, size-1);
			size--;
			heapify(arr,0);
		}
		
	}


	public static void main(String[] args) {

		int[] Arr = new int[] { 2, 7, 1, 7, 3, 7, 9, 7, 3, 7, 8, 5, 4, 7, 9, 7, 6, 6, 0 };
		hSort(Arr);
			}

}
