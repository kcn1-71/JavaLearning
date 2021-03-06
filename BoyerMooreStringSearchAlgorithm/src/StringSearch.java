import java.util.*;

public class StringSearch {

	public static Map<Character, Integer> ArrayOfShifts = new Hashtable<Character, Integer>();

	public static void ShiftOrganization(String S) {
		for (int i = S.length() - 2; i >= 0; i--) {
			if (!ArrayOfShifts.containsKey(S.charAt(i))) {
				ArrayOfShifts.put(S.charAt(i), S.length() - i - 1);
			}
		}
	}

	public static int ABM(String Main, String S) {
		
		for (int i = 0; i < Main.length() - S.length() + 1; i++){
			boolean flag = true;
			int j = S.length() - 1;
			while(j>=0 && flag == true)
			{
				
				if (Main.charAt(i + j)!= S.charAt(j)) 
				{
					flag = false;
					if (!ArrayOfShifts.containsKey(Main.charAt(i+j))) i+=S.length()-1;
					else i+=ArrayOfShifts.get(Main.charAt(i+j))-1;
				}
				j--;
			}
			if (flag) return i;
		}      
		return -1;
	}

	public static void main(String[] args) {

		String text = "0123456789";
		String S = "6789";
		
		ShiftOrganization(S);
		System.out.print(ABM(text,S));
	}

}
