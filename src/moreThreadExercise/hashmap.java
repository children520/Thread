package moreThreadExercise;

import java.io.IOException;
import java.util.*;

public class hashmap {
	public static void main(String[] args) throws IOException{
	HashMap<String,String> map=new HashMap<String,String>();
	map.put(country.GetCountry("china"),country.GetPopulation("14.05��"));
	map.put(country.GetCountry("india"),country.GetPopulation("13.04��"));
	map.put(country.GetCountry("Amercia"),country.GetPopulation("3.23��"));
	map.put(country.GetCountry("Indonesia"),country.GetPopulation("2.58��"));
	map.put(country.GetCountry("Brazil"),country.GetPopulation("2.05��"));
	map.put(country.GetCountry("Bangladesh"),country.GetPopulation("1.65��"));
	map.put(country.GetCountry("Russia"),country.GetPopulation("1.46��"));
	map.put(country.GetCountry("Japan"),country.GetPopulation("1.27��"));
	System.out.println(map);
	System.out.println("�����ϣ���������������в�ѯ");
	StringBuffer c= new StringBuffer();
	do {
		Scanner scanner=new Scanner(System.in);
		c=new StringBuffer();
		c.append(scanner.nextLine());
		String sc =c.toString();
		if(map.get(sc)!=null)
			System.out.println(map.get(sc));
		System.out.println("��������������в�ѯ��������q�˳�");
	}while(!("q".equals(c.toString())));
	
	System.out.println("exit");

	
	}
	}

