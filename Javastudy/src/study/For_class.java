package study;

import java.util.ArrayList;
import java.util.Scanner;

class C {

	String num;
	String name;

	@Override
	public String toString() {
		return "C [num=" + num + ", name=" + name + "]";
	}

}

public class For_class {
	public static void main(String[] args) {
		System.out.println("출력할 횟수를 입력하세요  ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		ArrayList<C> list = new ArrayList<C>();

		C c = new C();
		c.name = "teddy";

		System.out.println("\n\n");
		for (int i = 0; i < input; i++) {
			for (int j = 0; j < input; j++) {

				C c1 = new C();
				//c1 = c;
				c1.name = c.name ;
				c1.num = Integer.toString(i) + Integer.toString(j);
				list.add(c1);
			}
		}

		/*
		 * for (C cc : list) { System.out.println(cc); }
		 */
		System.out.println(list.toString());

	}
}
