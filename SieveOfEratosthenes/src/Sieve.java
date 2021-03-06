import java.util.Arrays;

public class Sieve 
{

	public static void main(String[] args) 
	{
		
		int n = 200;
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		
		for (int i=2; i<Math.sqrt(primes.length); i++)
		{
			if (primes[i])
				for (int j=2; i*j<primes.length; j++)
					primes[i*j]=false;
		}
		
		for (int i=0; i<primes.length; i++)
		{
			if (primes[i])
				System.out.print(i + " ");
		}
	}
}
