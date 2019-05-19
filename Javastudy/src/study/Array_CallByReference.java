package study;

public class Array_CallByReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int arr1[] = {1,2,3,4,5};
    int arr2[] = arr1;
    
    arr1[1] = 1;
    
    
    
    System.out.println(arr1[1]);
    System.out.println(arr2[1]);
    
    
    System.out.println(arr1);
    System.out.println(arr2);
		
		
	}

}
