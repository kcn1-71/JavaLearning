public class NumeralSystem {

	public static String Convert(int b1, int b2, String S) {
		String[] splittedS = S.split("\\.");
		String out = "";
		
		//��� ����� �����
		String s1 = splittedS[0];
		int N = 0;
		for (int i = 0; i < s1.length(); i++) {
			N = N * b1 + Character.getNumericValue(s1.charAt(i));
		}

		if (N == 0) {
			out = "0";
		} else {

			int r1 = 1;
			int[] d1 = new int[50];
			while (N != 0) {
				d1[r1] = N % b2;
				N = N / b2;
				r1 = r1 + 1;
			}

			for (int i = r1 - 1; i >= 1; i--) {
				out = out + (char) ('0' + d1[i]);
			}

		}
		//��� ������� �����
		String s2 = splittedS[1];
		int K = 2; //�� 2 �����
		double Nf = 0;
		if (s2.length() == 0) {
			out += ".0";
		} else {
			out += ".";
			for(int i=s2.length()-1; i >= 1; i--)
			{
				Nf = (Character.getNumericValue(s2.charAt(i)) + Nf) / b1;
			}
			
			int k2 = 1;
			while ((Nf != 0)&&(k2 < K))
			{				
				out+=(char)('0'+((int)(Nf * b2)));
				Nf = (double)(Nf * b2)-(int)(Nf * b2);	
			}		  			  
		}

		return out;
	}

	public static void main(String[] args) {

		System.out.print(Convert(10, 2, "20.11"));

	}

}
