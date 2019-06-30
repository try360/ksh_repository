package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(Arrays.toString(arr));
		System.out.println(arr.toString()); // 결과 봐
	}

}

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> arrayList = new ArrayList<String>(2);
		arrayList.add("첫번쨰 삽입");
		arrayList.add("두번쨰 삽입");
		arrayList.add("세번쨰 삽입");

		System.out.println("arrayList 크기   :  " + arrayList.toString());
		
	}

}
