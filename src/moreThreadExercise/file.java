package moreThreadExercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class file {
	public static void main(String args[]) {
		try {
		int read=0;
		File inf =new File("C:/test/ʵ��.txt");
		if(inf.exists()) {
			InputStream inpf =new FileInputStream(inf);
			OutputStream outf =new FileOutputStream("C:/fire/test.txt");
			byte[] buffer =new byte[500];
			while((read=inpf.read(buffer))!=-1) {
				outf.write(buffer, 0, read);
				System.out.print("���Ƴɹ�");
			}
				inpf.close();
			}
		
		}
		catch(Exception e){
			System.out.println("�����ļ�����");
			
		}
	}

}
