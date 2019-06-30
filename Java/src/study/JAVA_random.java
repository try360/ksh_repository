package study;

public class JAVA_random {

	public static void main(String[] args) {

		// int num = (int) (Math.random() * 11);

		int count = 0;
		while (count == 11) {
			for (int i = 1; i <= 11; i++) {

				i = (int) (Math.random() * 11);

			}

			count++;
		}

	}

}
