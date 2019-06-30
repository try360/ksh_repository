package Algorithm;
import java.util.Scanner;

public class Reverse_Integer {
	public static void reverse() {

		System.out.println("숫자를 입력하세요ㅔ . 입력한 숫자는 배치를 반대로 합니다");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		int pop = 0;

		while (x != 0) {
			pop = x % 10;

			x /= 10;

			pop *= 10;

		}
		System.out.println(pop);
	}

	public static void main(String[] args) {

	}
}
