package study;

import java.util.ArrayList;

class A {
	String a;
	String b;

	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + "]";
	}

}

class B {
	String c;
	String d;

}

class Test {
	String a;
	String b;

	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + "]";
	}

}

class CallByReferenceTest2 {

	public CallByReferenceTest2() {

		Test test1 = new Test();
		test1.a = "김승회";
		Test test2 = test1;
		test2.b = "김승회";

		System.out.println(test1);
		System.out.println(test2);

	}
}

public class CallByReferenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A a = new A();
		a.a = "MELONG";

		ArrayList<A> list = new ArrayList<A>();
		for (int i = 0; i < 5; i++) {

			A a1 = new A();
			a1 = a;

			a1.b = Integer.toString(i);
			list.add(a1);

		}
		System.out.println(list.toString());
	}
}
