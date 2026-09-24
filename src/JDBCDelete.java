import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
public class JDBCDelete {
	public static void main(String[] args) throws Exception{
		Connection con=DBConn.getConn();
		Statement stmt=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter empid to delete:");
		String empId=sc.nextLine();
		int rowsAffected=stmt.executeUpdate("delete from emp1 where id =' " +empId+" ' ");
		if(rowsAffected>0) {
			System.out.println("Record deleted Successfully");
		}
		else {
			System.out.println("Employee Id not found");
		}
		sc.close();
		stmt.close();
		con.close();
	}
}
