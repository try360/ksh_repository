package study;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class StandardIOEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   PrintStream ps = null;
   FileOutputStream fos = null;
   try {
	   fos = new FileOutputStream("text.txt");
	   ps = new PrintStream(fos);
	   System.setOut(ps);   // System.out 의 출력대상을 test.txt파일로 로 바꿈
	   
	   
   }catch(FileNotFoundException e){
	   System.err.println("file not found");
   }
   System.out.println("성공?");
   System.out.println();
	}

}
