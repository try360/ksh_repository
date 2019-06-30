package study;

//클래스 밖에다 선얹
enum man_info{
	NAME, HEIGHT, WEIGHT
}

public class EnumerationTEST {

	// 클래스 안에다 선언
	enum Week {
		SUN, MON, TUE, WEN, THUR, FRI, SAT
	}

	public Week week;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Week type : Week.values()) {
			System.out.println(type);
		}
ㅏ,k,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,k,k,,,,,,,,,,,,,,
	}

}
