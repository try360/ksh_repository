package study;

import java.sql.Time;
import java.util.Scanner;

public class AlamClock {
    //시간 5개 저장할 수 있어야 함
    private Time[] times; //시간 5개를 저장할 수 있는 참조변수
    private Scanner input;  //입력을 받기 위한 Scanner
    private boolean isRun;
    public AlamClock() { //기본 생성자 
        isRun = false;
        times = new Time[5];
        input = new Scanner(System.in);
    }
    /*
     * 기능3. 설정된 알람 수정하기 (시간 수정 : 수정할 시, 분, 초 를 순서대로 입력받아서 수정)
      ex)저장된 시간 : 17시 12분 00초 ,   -2 -10  00   >> 15시 2분 00초 로 변경    
         >>메뉴 출력, 메뉴 입력   등 모두 구현 
     * */
     
    public void setAlarm() {
        //0번 알람에 새로운 알람 설정
        //원래 설정되어 있던 알람들은 번호 하나씩 뒤로 미루기
        //(5개가 넘어갈 경우 가장 오래된 알람하나는 삭제된다.)
        int h,m,s;   //수정할 시,분,초를 저장할 변수
        System.out.println("시간을 입력하세요(0~23)");
        h = input.nextInt();
        System.out.println("분을 입력하세요(0~59)");
        m = input.nextInt();
        System.out.println("초을 입력하세요(0~59)");
        s = input.nextInt();
        arrCopy();  //기존에 저장되어 있던 배열 한 칸씩 뒤로 복사 
        Time t = new Time(h,m,s);  //실제 시간이 저장될 객체 생성
        times[0] = t;  //생성한 객체를 배열의 첫번째 인자에 참조 
    }
    //기존에 있던 저장된 알람중 최근 4개를 유지하기 위해 복사
    private void arrCopy() {  
        for(int i = times.length-2 ;i >=0;i--) {
            times[i+1] = times[i];
        }
    }
     
     
    public void modifyAlarm() {
        //입력받고, 수정
        //수정하고자 하는 시간부터 입력받기
        int number;
        System.out.println("수정하려는 시간 번호를 입력하세요.");
        number = input.nextInt();  //0~4 번까지 입력받기 
         
        if(number > 4 || number < 0) {
            System.out.println("잘못입력하셨습니다.");
            return;   //메서드 즉시종료
        }
        if(times[number] == null) {
            System.out.println("설정되지 않은 번호 입니다.");
            return;
        }
        int h,m,s;   //수정할 시,분,초를 저장할 변수
        System.out.println("수정하려는 시간을 입력하세요(0~23)");
        h = input.nextInt();
        System.out.println("수정하려는 분을 입력하세요(0~59)");
        m = input.nextInt();
        System.out.println("수정하려는 초을 입력하세요(0~59)");
        s = input.nextInt();
        //Time 클래스 객체가 가지는 setTime메서드 이용
        times[number].setTime(h); 
    }//modifyAlarm End
    //설정된 모든 알람출력
    public void showAlarms() {
        System.out.println("설정된 알람 목록입니다.");
        for(int i =0;i<times.length;i++) {
            if(times[i] == null) {
                System.out.print(i+". 시간이 설정되지 않았습니다.\n");
            }else {             
                System.out.print(i+". " + times[i]);
            }
        }
    }   
    //메뉴 출력
    public void showMenu() {
        System.out.println("-------번호를 선택하세요--------");
        System.out.println("1. 알람 입력   2.알람 수정    3. 알람확인    4. 종료");
    }
    //메뉴 입력
    public void selectMenu() {
        int number= input.nextInt();
        switch(number) {
        case 1:
            //입력
            setAlarm();
            break;
        case 2:
            //수정
            modifyAlarm();
            break;
        case 3:
            //출력
            showAlarms();
            break;
        case 4:
            //종료
            isRun = false;
            break;
        default:
            System.out.println("잘못입력하셨습니다.");
            break;
        }
    }
    public void start() {
        isRun = true;
        while(isRun) {
            showMenu();
            selectMenu();
        }
    }
} //AlarmClock Class End