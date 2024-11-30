import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteStudent extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(req, resp);
	try {
	PrintWriter out=resp.getWriter();
	Statement stmt = null;
	String email;
	email= req.getParameter("email");
	resp.addHeader("Access-Control-Allow-Origin","*");
	Connection connection = Db_Connector.getDbConnection();
	stmt = connection.createStatement();
	stmt.executeUpdate("delete from student where email="+email+";");
	JSONObject jo =new JSONObject();
	jo.put("status","success");
	out.println(jo);
}catch(Exception e) {
	
}
}}
