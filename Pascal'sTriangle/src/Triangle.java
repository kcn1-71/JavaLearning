public class Triangle 
{
	public static long C (long n, long k)
	{
	  if (k == 0 || n == k)
	    return 1;
	  return C(n - 1, k - 1) + C(n - 1, k);
	}
	
	public static void main(String[] args) 
	{
		for (int i=0; i<6; i++)
		{
		
			for (int j=0; j<=i; j++)
			{
				System.out.print(C(i, j) + " ");
			}
			System.out.print("\n");
		}		
	}
}
