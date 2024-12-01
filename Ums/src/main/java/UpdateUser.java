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

public class UpdateUser extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
	Statement stmt=null;
	int id=Integer.parseInt(req.getParameter("id"));
	String name = req.getParameter("name");
	String dept= req.getParameter("dept");
	String role= req.getParameter("role");
	resp.addHeader("Access-Control-Allow-Origin","*");
	try {
	Connection connection = DB_Connector.getDbConnection();
	stmt = connection.createStatement();
	stmt.executeUpdate("update users set name='"+ name+"',dept='"+dept+"',role='"+role+ "'where id=" +id+";");
	JSONObject jo= new JSONObject();
	jo.put("Status","Success");
	out.println(jo.toString());
	}
	catch(Exception e)
	{
		out.println(e);
	}
	
	
	
	//super.doGet(req, resp);
}
}
