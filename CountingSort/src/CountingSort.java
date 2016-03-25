
public class CountingSort {

	public static void CSort(int[] Arr) {

		int[] Count = new int[10];

		for (int i = 0; i < Arr.length; i++) {
			Count[Arr[i]] += 1;
		}
		int b = 0;
		for (int j = 0; j < Count.length; j++) {
			for (int i = 0; i < Count[j]; i++) {
				Arr[b] = j;
				b = b + 1;
			}
		}
	}

	public static int[] CSortStable(int[] Arr) {
		int[] Count = new int[10]; // на самом деле не 10 а max(Arr)
		int[] Out = new int[Arr.length];

		for (int i = 0; i < Arr.length; i++) {
			Count[Arr[i]] += 1;
		}
		for (int j = 1; j < Count.length - 1; j++) {
			Count[j] = Count[j] + Count[j - 1];
		}
		for (int i = Arr.length - 1; i >= 0; i--) {
			Count[Arr[i]] = Count[Arr[i]] - 1;
			Out[Count[Arr[i]]] = Arr[i];
		}
		return Out;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 3, 2, 2, 1, 1, 2, 2, 3, 3, 2, 1, 1, 2, 3 };
		CSortStable(A);
		
		
	}

}
