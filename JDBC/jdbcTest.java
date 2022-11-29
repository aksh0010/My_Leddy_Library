import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcTest {

	public static void main(String[] args) throws SQLException{
		BookType book1 = new BookType();
		// TODO Auto-generated method stub
		String uname = "root";
		String password = "Hotwings88$";
		String query = "SELECT * FROM books";
        String url = "jdbc:mysql://localhost:3306/test_schema";
		
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
                 System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3)+ " " + rs.getString(4) + " " + rs.getString(5) +" " + rs.getString(6)+ " " + rs.getString(7));
                }
            con.close();
        }catch (SQLException e){
            e.printStackTrace() ;
        }


        //now allow the user to enter a book to be added to the database 
        //and then display the updated database
        //first get the user input
        book1.SetISBN(1234562326);
        book1.SetName("TEMP");
        book1.SetAuthor("meep");
        book1.SetPrice(9.99);
        book1.SetPublisher("meep");
        book1.SetYear(2012);
        book1.SetUnit(0);
//        book1.setAvailability(true);
        book1.SetCategory("science");  
        
        int available ;
        
        if (book1.available()) {
        	available = 1;
        }else {
        	available = 0;
        }
        
        String insertQuery = "INSERT INTO books (isbn, name, author, price, publisher, year, total_units, available, Booktype) VALUES ('" + book1.getISBN() + "', '" + book1.getName() + "', '" 
         + book1.getAuthor() + "', '" + book1.getPrice() + "', '" + book1.getPublisher() + "', '" + book1.getYear() + "', '" + book1.getUnit() +  "', '" + available + "', '" + book1.getCategory() +"' )";
        try{
            Connection con = DriverManager.getConnection(url, uname, password);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(insertQuery);
            con.close();
        }catch (SQLException e){
            e.printStackTrace() ;
        }
      

	}

}
