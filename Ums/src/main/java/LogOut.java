import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogOut extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(req, resp);
	try {
		PrintWriter out=resp.getWriter();

	HttpSession session =req.getSession(true);
	session.invalidate();
	JSONObject jo= new JSONObject();
	jo.put("Status", "Logged Out");
	out.println(jo.toString());

}catch(Exception e) {
	e.printStackTrace();
}
	
}
}

