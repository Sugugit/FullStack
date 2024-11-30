import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import org.json.JSONObject;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginFilter implements Filter{
@Override
public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
		throws IOException, ServletException {
	// TODO Auto-generated method stub
	HttpServletRequest req=(HttpServletRequest)arg0;
	PrintWriter out =arg1.getWriter();
	HttpSession session = req.getSession(false);

	String url=req.getContextPath()+"/login";

	boolean loggedin = true;
	boolean loginRequet = true;
	
	if(loggedin || loginRequet) {
		arg2.doFilter(arg0, arg1);
	}
	else {
		JSONObject jo = new JSONObject();
		jo.put("status","fail");
		out.println(jo.toString());
	}
	
}
}
