package moreThreadExercise;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegularExpression {
	public static void main(String args[]) {
		System.out.println("������һ���ַ�����");
		Scanner scan =new Scanner(System.in);
		String input=scan.nextLine();
		String Decimal ="^[-]?[0-9]+\\.?[0-9]+$";
		String Integer ="^\\-{0,1}[0-9]+$";
		
		
		boolean I = Pattern.matches(Integer,input);
		boolean D = Pattern.matches(Decimal, input);
		if(I) {
			System.out.println("����Ϊ����");
			
			}
		else if(D){
			System.out.println("����ΪС��");
			
			}
		else {
			System.out.println("�������");
			
			
		}
		}
	}

