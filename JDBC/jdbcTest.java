package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcTest {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		String uname = "root";
		String password = "Hotwings88$";
		String query = "SELECT * FROM books";
        String url = "jdbc:mysql://localhost:3306/myleddy";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, uname, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                 System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8));
                }
            con.close();
        }catch (SQLException e){
            e.printStackTrace() ;
        }
	}

}
