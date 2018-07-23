// Setting environment variable temporary=> export CLASSPATH=/home/student/3238/mysql-connector-java-5.1.46.jar:$CLASSPATH




import java.sql.*;  

public class jdbc
{  
	public static void main(String args[])
	{  
		try
		{  
			Class.forName("com.mysql.jdbc.Driver"); //registration of MySQL driver

			Connection con = DriverManager.getConnection("jdbc:mysql://10.10.15.202/test","te3238","te3238");

			PreparedStatement ps = con.prepareStatement("INSERT INTO Catogery VALUES(?,?,?)");  //creates a stateent object

			ps.setString(1,"2");
			ps.setString(2,"Nitin");
			ps.setString(3,"None");
			int i = ps.executeUpdate();
			System.out.println(i);

			con.close();
			  
		}catch(Exception e)
		{ 
			System.out.println(e);
		}  
			  
	}  
}  