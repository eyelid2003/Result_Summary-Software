//package sheet;
import java.sql.*;
public class ConFile 
{
	Connection c;
	Statement s;
	ConFile()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","root");
	        s=c.createStatement();
		}
		catch(Exception ex)
		{
			System.out.print(ex);
		}
		
	}
}