import java.util.Arrays;

public class BinarySearch {

	double[] array;

	BinarySearch(double[] array) {
		this.array = array;
	}

	int search(double s) {
		int i = -1;
		if (this.array != null) {

			int left = 0, right = this.array.length, mid;

			while (left < right) {
				mid = (left + right) >>> 1;
				if (s == this.array[mid]) {
					i = mid;
					break;
				} else {
					if (s > this.array[mid]) {
						left = mid;
					} else {
						right = mid;
					}
				}
			}
		}
		return i;
	}

	public static void main(String[] args) {
		BinarySearch a = new BinarySearch(new double[] { 2, 4, 1, 5, 3, 7, 9, 34, 3, 7, 8, 5, 4, 3, 9, 9, 6, 6 });
		System.out.println(Arrays.toString(a.array));
		System.out.println(a.search(1));
	}

}
