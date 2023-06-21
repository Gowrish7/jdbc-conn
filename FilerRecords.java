package demo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FilerRecords {
	public static void main(String args[]) throws IOException {
		String url="jdbc:mysql://localhost:3306/6cs2";
		String user="root",password="root";
		try {
			Connection con=DriverManager.getConnection(url, user, password);
			Statement smt=con.createStatement();
			System.out.print("Enter gender:  ");
			char sex=(char)System.in.read();
			String sql="select * from students where student_gender='"+sex+"'";
			ResultSet rSet =smt.executeQuery(sql);
			while(rSet.next()) {
			System.out.println("Student ID: "+rSet.getInt(1));
			System.out.println("Student Name: "+rSet.getString(2));
			System.out.println("Student marks: "+rSet.getString("students_marks"));
		}
		rSet.close();
		smt.close();
		con.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
