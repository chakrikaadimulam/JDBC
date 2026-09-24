import java.sql.*;

public class JDBCInsert2 {
	public static void main(String args[]) {
	int count = 0;
	try {
		Connection con = DBConn.getConn();
		CallableStatement cs = con.prepareCall("{call GetEmployee()}");
		ResultSet rs = cs.executeQuery();
		
		while (rs.next()) {
		System.out.println("name : " + rs.getString("name"));
		System.out.println("department : " + rs.getString("department"));
		System.out.println("salary : " + rs.getString("salary"));
		count++;
		System.out.println("total employees: " + count);
		}
	rs.close();
	cs.close();
	con.close();
	} catch (Exception e) {
	System.out.println("Database error");
	e.printStackTrace();
	}
	}
}