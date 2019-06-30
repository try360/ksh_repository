package Algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class josephers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(" please input the number of person");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // number of person
		while (1 <= N && N <= 5000) {
			N = sc.nextInt(); // number of person
			break;
		}

		System.out.println(" romove order of person");
		Scanner sc2 = new Scanner(System.in);
		int K = sc2.nextInt();
		while (1 <= K && K <= 5000) {
			K = sc2.nextInt(); // number of person
			break;
		}

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		System.out.println("사람들 배치  :  " + list);
		
		List<Integer> addList = new ArrayList<Integer>();
		
		while(list.isEmpty())
if(K<N)			
		for(int i = 0 ;)	
		list.remove(K);
				
				
		else if(N<K)
		break
		
		

	}

}
