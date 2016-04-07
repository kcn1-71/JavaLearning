
public class QuickSortAgain {

	public static void qSort(int[] a, int left, int right){

		int i = left;
		int j = right;
		int p = a[i+(j-i)/2];
		
		while (i<=j){
			
			while (a[i]<p) i++;
			while (a[j]>p) j--;
			if (i<=j){
				int temp = a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}						
		}		
	if (i<right) qSort(a,i,right);
	if (j>left) qSort(a,left,j);		
	}
	
	public static void main(String[] args) {
		int[] Arr = new int[] { 2, 7, 1, 7, 3, 7, 9, 7, 3, 7, 8, 5, 4, 7, 9, 7, 6, 6, 0 };
		qSort(Arr, 0, Arr.length - 1);

	}

}
