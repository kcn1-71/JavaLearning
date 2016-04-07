
public class iSortAgain {
	
	public static void sort(int[] arr){
		
		for (int j = 1; j < arr.length; j++){
			
			int key = arr[j];
			int i = j - 1;
			
			while ( i >= 0 && key < arr[i]){
				arr[i+1]=arr[i];
				i--;
			}
			arr[i+1]=key;
		}
		
	}

	public static void main(String[] args) {
		
		int[] A = new int[] { 2, 4, 1, 5, 3, 7, 9, 34, 3, 7, 8, 5, 4, 3, 9, 9, 6, 6 };
		sort(A);

	}

}
