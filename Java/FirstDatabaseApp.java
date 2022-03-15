
package fisrstdatabaseapp;

/**
 *
 * @author user
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstDatabaseApp 
{
	public FirstDatabaseApp() 
	{}
	 public static void main(String[] args) {
		try 
		{ 
		 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		}
		catch(Exception e)
		{
			
		}
		 try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grades", "root","bebomahy@273");
			Statement stmt = con.createStatement() ; 
			String queryString = new String("select * from students");
			ResultSet rs = stmt.executeQuery(queryString) ;
		  while(rs.next()) {
			System.out.println(rs.getString(1)+" " + rs.getString(2)+" "+rs.getString(3)); 
			} 
		
		con.setAutoCommit( false ); 
		PreparedStatement pst= con.prepareStatement( " insert into students (student_id,student_name,tel)values (?,?,?);" ); 
		// 3.Adding the calling statement batches 
		pst.setInt(1,504); 
		pst.setString(2 ," Mahy"); 
		pst.setString(3 ," Mohsen "); 
		pst.addBatch(); 
		int[] updateCounts= pst.executeBatch();
                 
		con.commit();
		
	    queryString = "DELETE FROM students " + "WHERE student_id = 500";
		stmt.executeUpdate(queryString);
		System.out.println("deleted");
                queryString = new String("select * from students");
		 rs = stmt.executeQuery(queryString) ;
		
		queryString = "UPDATE students " + "SET student_name = 'mmmm' WHERE student_id in (1, 501)";
		stmt.executeUpdate(queryString);
		System.out.println("updated");
                queryString = new String("select * from students");
		 rs = stmt.executeQuery(queryString) ;

		
		stmt.close();
		con.close(); 
			} 
			catch(SQLException ex)
			{ 
			ex.printStackTrace();
			}
	}
}

 
