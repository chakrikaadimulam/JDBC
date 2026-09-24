// PRESTATEMENT 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
class Employee {
	String id;
	String name;
	String dept;
	double salary;
	public Employee(String id,String name,String dept,double salary) {
		this.id=id;
		this.name=name;
		this.dept=dept;
		this.salary=salary;
	}
}
public class JDBCInsert1{
	public static void main(String[] args) throws Exception{
		Connection con=DBConn.getConn();
		String sql="Insert into emp1(id,name,department,salary) values(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ArrayList<Employee> employees=new ArrayList<>();
		employees.add(new Employee("16","rama1","HR",50000));
		employees.add(new Employee("17","ravi","IT",60000));
		employees.add(new Employee("18","ram","Finance",10000));
		for(Employee emp:employees) {
			PreparedStatement checkStmt= con.prepareStatement("SELECT COUNT(*) FROM emp1 WHERE id=?");
			checkStmt.setString(1,emp.id);
			ResultSet rs=checkStmt.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			checkStmt.close();
			if(count==0) {
				pstmt.setString(1, emp.id);
				pstmt.setString(2, emp.name);
				pstmt.setString(3, emp.dept);
				pstmt.setDouble(4, emp.salary);
				pstmt.addBatch();
				}
			else {
				System.out.println("Employee "+ emp.name +" already exists. skipping insert.");
				}
		}
			int [] results=pstmt.executeBatch();
			for(int i=0;i<results.length;i++) {
				if(results[i]>=0) {
				System.out.println("Employee"+ employees.get(i).name + "inserted succesfully");
				}
			pstmt.close();
			con.close();
			}		
	}
}
