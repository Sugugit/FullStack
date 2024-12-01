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

	public class Readuser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);

		
		PrintWriter out =resp.getWriter();
		resp.addHeader("Access-Control_Allow_Origin","*");
		try {
			Connection con=DB_Connector.getDbConnection();
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery("select id,name,dept,role from users");
			JSONArray row =new JSONArray();
			while(rs.next()) {
				
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String dept=rs.getString("dept");
					String role=rs.getString("role");

					JSONObject jo = new JSONObject();
					jo.put("id", id);
					jo.put("name", name);
					jo.put("dept", dept);
					jo.put("role", role);
					row.put(jo);
					
				}
			out.println(row);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}


	}



