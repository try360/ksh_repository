package study;

import java.util.Arrays;

class Array1 {

	public Array1() {
		int arr[] = { 1, 2, 3, 4, 5 };

		for (int index : arr) {
			System.out.println(index);
		}
	}

}

class Array2 {

	public Array2() {
		int arr[] = {1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(arr));
		System.out.println(arr.toString()); // 결과 봐
	}

}

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Array2 a = new Array2();
	}

}
