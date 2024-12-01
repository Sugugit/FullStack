import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionFilter implements Filter {
@Override
public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
		throws IOException, ServletException {
	// TODO Auto-generated method stub
	try {
	HttpServletRequest req=(HttpServletRequest)arg0;
	HttpServletResponse res=(HttpServletResponse)arg1;
	HttpSession session=req.getSession(true);
	String name=(String)session.getAttribute("name");
	if(name.equals(null) ) {
		RequestDispatcher rd=req.getRequestDispatcher("/login");
		rd.forward(req, res);
	}
	else {
		arg2.doFilter(arg0,arg1);
	}
}catch(Exception e) {
	e.printStackTrace();
}
}}
