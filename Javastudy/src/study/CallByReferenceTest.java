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

class B {
	String c;
	String d;

}