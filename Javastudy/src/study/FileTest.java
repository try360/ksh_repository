package study;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {

		try {
			BufferdOutputStreamEx1 bos = new BufferdOutputStreamEx1();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

class BufferdOutputStreamEx1 {

	public BufferdOutputStreamEx1() throws FileNotFoundException {
		
		FileOutputStream fos = new FileOutputStream("123.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos, 5);

		for (int i = '1'; i <= '9'; i++) {
			try {
				bos.write(i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}