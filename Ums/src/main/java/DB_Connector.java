import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connector {
	public static Connection getDbConnection()
	{
		Connection con=null;
		String url="jdbc:postgresql://localhost:5432/ums";
		String user="postgres";
		String pwd="postgres";
		
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url,user,pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
