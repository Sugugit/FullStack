import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ReadStudent extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(req, resp);

	
	PrintWriter out =resp.getWriter();
	try {
		Connection con=Db_Connector.getDbConnection();
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery("select * from student");
		JSONArray row =new JSONArray();
		while(rs.next()) {
			
				JSONObject jo = new JSONObject();
				jo.put("name", rs.getString("name"));
				jo.put("email", rs.getString("email"));

				row.put(jo);
				
			}
		out.println(row);
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}


}

