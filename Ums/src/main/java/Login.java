import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	super.doGet(req, resp);
	String r_uname=req.getParameter("name");
	String r_pwd=req.getParameter("pwd");
	r_pwd=umshash.getHashCode(r_pwd);
	HttpSession session=req.getSession();
	resp.addHeader("Access-Control-Allow-Origin","*");
	PrintWriter out=resp.getWriter();
	Boolean loggedin=false;
	Statement stmt=null;
	try {
		Connection con=DB_Connector.getDbConnection();
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from users");
		while(rs.next()) {
			String uname=rs.getString("name");
			String pwd=rs.getString("password");
			out.println(umshash.getHashCode(uname));
			if(r_uname.equals(uname) && r_pwd.equals(pwd)) {
				session.setAttribute("name", uname);
			
				JSONObject jo= new JSONObject();
				jo.put("Status", "Success");
				jo.put("name", uname);
				out.println(jo.toString());
				loggedin=true;
				break;
			}
			
		}
		if(loggedin == false) {
			JSONObject jo=new JSONObject();
			jo.put("Status","Failed");
			out.println(jo.toString());
		}
	}
	catch(Exception e) {
		
		out.println(e);
	}

}
}
