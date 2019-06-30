package Algorithm;
import java.util.HashSet;

public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int count = 1;
		char arr[] = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			boolean success = false;
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr[i]) {
					success = false;
					break;
				}

			}
			if(success) {
				count++;
			}
		}

		
		
		
		
		return count;
	}

	public static void main(String[] args) {

		
		
		/*
		 * while (true) {
		 * System.out.println("연속적인 문자중에서 서로 다른 문자의 개수를 셀겁니다  영문으로 문자열을입력하세요"); Scanner
		 * sc = new Scanner(System.in);
		 * 
		 * LengthOfLongestSubstring lengthOfLongestSubstring = new
		 * LengthOfLongestSubstring();
		 * 
		 * System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(sc.
		 * nextLine())); }
		 */
	}
}
