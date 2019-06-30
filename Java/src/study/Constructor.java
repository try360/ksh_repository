package study;

class Calculator {

	int a, b;

	public Calculator(int a, int b) {
		this.a = a;
		this.b = b;
	}

	int add() {

		return this.a + this.b;

	}

}

public class Constructor {

	static Calculator calculator = new Calculator(15, 19);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(calculator.add());

	}

}
