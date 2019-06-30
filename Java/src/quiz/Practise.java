package quiz;

import java.util.Scanner;

class P1 {

	P1() {
		for (;;) {
			System.out.println(" 첫번쨰 숫자 입력사ㅔ요");
			Scanner s1 = new Scanner(System.in);
			int a = s1.nextInt();

			Scanner s2 = new Scanner(System.in);
			System.out.println(" 두번째 숫자 입력사ㅔ요");
			int b = s2.nextInt();

			int c = 0;
			int area = 1000;
			int d;
			if (a != b) {

				b = a * b;

			} else if (a == b) {
				c = area - ((area * (5 / 100)) * (b - 2));
				d = (int) (area * 0.5);
			}

			System.out.println(c);

		}

	}

}

public class Practise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
