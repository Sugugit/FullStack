import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteUser extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(req, resp);
	
	PrintWriter out=resp.getWriter();
	Statement stmt = null;
	int id=Integer.parseInt(req.getParameter("id"));
	resp.addHeader("Access-Control-Allow-Origin","*");
	try {
	Connection connection = DB_Connector.getDbConnection();
	stmt = connection.createStatement();
	stmt.executeUpdate("delete from users where id="+id+";");
	JSONObject jo =new JSONObject();
	jo.put("Status","Deleted");
	out.println(jo.toString());
}catch(Exception e) {
	out.print(e);
}
}}
