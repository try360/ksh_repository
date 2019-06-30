package Algorithm;
import java.util.Scanner;

public class Empty_bottle {

	static int remain(int remain) {
		return remain / 4 + remain % 4;

	}

	static int eatable(int remain) {
		return remain / 4;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(" 구입할 병수를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		int result_remain = num;
		int eatable_result = num;
		int roop = 2;

		for (int i = 0; i < roop; i++) {
			eatable_result += eatable(result_remain);
			result_remain = remain(result_remain);
		}

		System.out.println("먹을 수 있는 음료 갯수" + eatable_result + "    남는 병의 개수  :    " + result_remain);

	}

}
