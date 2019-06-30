package quiz;

import java.util.Scanner;

public class Tojise {

	public Tojise() {

		int A = 0;
		double year = 0;

		System.out.println(" 보유 기간을 입력하세요 ");
		Scanner sc_n = new Scanner(System.in);
		int n = sc_n.nextInt();

		int result = 0;

		System.out.println(" 토지 면적을 입력하세요 ");
		Scanner sc1 = new Scanner(System.in);
		int area = sc1.nextInt();

		System.out.println(" 건물이 있는 토지입니까? ");
		Scanner sc2 = new Scanner(System.in);
		String answer = sc2.next();

		if (answer.equals("아니오") || answer.equals("ㄴ") || answer.equals("n") || answer.equals("N")) {
			System.out.println(" 건물이 없는 토지세입니다. ");
			if (area <= 1000) {
				A = 1800;
			} else if (area > 1000 && area <= 2500) {
				A = 2000;
			} else {
				A = 3000;
			}
		} else if (answer.equals("네") || answer.equals("ㅇ") || answer.equals("y") || answer.equals("Y")) {
			System.out.println(" 건물이 있는 토지세입니다 . ");
			if (area <= 1000) {
				A = 3600;
			} else if (area > 1000 && area <= 2500) {
				A = 4000;
			} else {
				A = 6000;
			}
		} else {
			System.out.println(" 대답 똑바로 해라 ");
		}
		System.out.println(" 토지 보유기간은  ?  :  " + n);
		System.out.println("  제곱 m 당 세액은   :  " + A);

		if (n < 3) {
			year = A - A;
		} else if (n >= 3 && n < 12) {
			year = A - (A * 5.0/100 * (n - 2.0));
		} else if (n >= 12) {
			year = A - (A / 2);
		}
		System.out.println(" 할인률은  ?   :  " + 5.0/100 * (n - 2.0) );
		System.out.println(" 연토지세는? : " + year);
		System.out.println("지방 교육세   : " + year * 0.3);
	}

	public static void main(String[] args) {
		for (;;) {
			Tojise t = new Tojise();
			System.out.println("\n");
		}
	}
}
