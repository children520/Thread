package moreThreadExercise;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class MySql {
	public  static void main(String args[]) {
		Connection con;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username="root";
		String password="123456";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
			if(!con.isClosed())
				System.out.println("�������ݿ�ɹ�");
			Statement statement =con.createStatement();
			String sql ="select * from student";
			ResultSet rs=statement.executeQuery(sql);
			System.out.println("-----------");
			System.out.println("ִ�в�ѯ��������ѯ�������");
			System.out.println("------------");
			String Name =null;
			String No=null;
			int Sex;
			sql="select * from student where Name ='����'";
			ResultSet es=statement.executeQuery(sql);
			if(es.next()) { 
				System.out.println("Name      "+"No            "+"Sex         ");
				 //sql = "insert into student(Name,No,Sex) values('����','2017010101','Ů')";
				Name=es.getString(1);
				No=es.getString(2);
				Sex=es.getInt(3);
				System.out.println(Name+"\t"+No+"\t"+Sex);
				}
			else {
				System.out.println("û������������");
				System.out.println("�������������ݲ��������ݿ�");
				sql = "insert into student(Name,No,Sex) values('����','2017010101','1')";
				statement.executeUpdate(sql);
				System.out.println("����ɹ�");
				
					
			}
			rs.close();
			con.close();
			statement.close();
			
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("sorry.can't find the driver");
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			System.out.println("");
		}
	}
	
}
	
