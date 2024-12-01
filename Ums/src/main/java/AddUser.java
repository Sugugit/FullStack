import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddUser extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	super.doGet(req, resp);
	
	PrintWriter out= resp.getWriter();
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			pwd=umshash.getHashCode(pwd);
			String dept=req.getParameter("dept");
			String role=req.getParameter("role");

		
			resp.addHeader("Access Control-Allow-Origin","*");
			
	try {
			Connection connection = DB_Connector.getDbConnection();
			PreparedStatement ps=connection.prepareStatement("insert into users(name,password,dept,role) values (?,?,?,?);");
			ps.setString(1, name);
			ps.setString(2, pwd);
			ps.setString(3, dept);
			ps.setString(4, role);
			ps.executeUpdate();
			JSONObject jo= new JSONObject();
			jo.put("Status", "Success");
			jo.put("value","Data inserted Successfully");
			out.println(jo.toString());
			
	}
	catch(Exception e) {
		
	}

}
}
