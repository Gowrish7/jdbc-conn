package demo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadingDBData {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/6cs2";
		String user= "root",password="root";
		try {
			Connection con=DriverManager.getConnection(url, user, password);
			Statement smt=con.createStatement();
			String sql ="select * from students where student_gender='f'";
			ResultSet rSet= smt.executeQuery(sql);
			while(rSet.next()) {
				System.out.println("Student ID: "+rSet.getInt(1));
				System.out.println("Student Name: "+rSet.getString(2));
				//System.out.println("Student gender: "+rSet.getString(3));
				System.out.println("Student marks: "+rSet.getString("students_marks"));
				if(rSet.getString("student_gender").equalsIgnoreCase("f"))
					System.out.println("Gender   :Female");
				else 
					System.out.println("Gender   : Male");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

