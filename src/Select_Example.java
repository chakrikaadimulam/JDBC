import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class Select_Example {
	public static void main(String[] args) throws Exception{
		Connection con=DBConn.getConn();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from emp1");
		System.out.println("ID\tName\t\tDepartment\tSalary");
		System.out.println("-------------------------------------");
		while(rs.next()) {
			String id=rs.getString("id");
			String name=rs.getString("department");
			String dept=rs.getString("department");
			double salary=rs.getDouble("Salary");
			System.out.println(id+"\t"+name+"\t\t"+dept+"\t\t"+salary);
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
