package study;

import java.util.ArrayList;

class Test {
	String a;
	String b;

	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + "]";
	}

}

public class CallByReferenceTest2 {

	public static void main(String[] args) {

		Test test1 = new Test();
		test1.a = "김승회";
		Test test2 = test1;
		test2.b="김승회";
		
		System.out.println(test1);
		System.out.println(test2);

	}

}
