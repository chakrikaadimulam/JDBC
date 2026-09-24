import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCUpdate {
    public static void main(String[] args) throws Exception {
        Connection con = DBConn.getConn();
        Statement stmt = con.createStatement();
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.println("Enter empid of the employee to update:");
        String empid = sc.nextLine();

        System.out.println("Enter new empname:");
        String empname = sc.nextLine();

        System.out.println("Enter new department:");
        String dept = sc.nextLine();

        System.out.println("Enter new salary:");
        double sal = sc.nextDouble();

        // SQL UPDATE Query
        int i = stmt.executeUpdate("UPDATE emp1 SET name = '" + empname + "', department = '" 
                + dept + "', salary = " + sal + " WHERE id = '" + empid + "'");

        // Output message
        if (i > 0)
            System.out.println("Record updated successfully.");
        else
            System.out.println("Update failed. No employee found with id: " + empid);

        // Closing resources
        stmt.close();
        con.close();
        sc.close();
    }
}