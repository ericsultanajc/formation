package sopra.exemple;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet { // Classe java accessible par une servelet via son url

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = request.getParameter("nom");
		
		response.setContentType("text/html");
		response.getWriter().write("<html>");
		response.getWriter().write("<head>");
		response.getWriter().write("<title>Ma première servlet</title>");
		response.getWriter().write("</head>");
		response.getWriter().write("<body>");
		response.getWriter().write("<h1>Hello</h1>");
		response.getWriter().write("</body>");
		
		response.getWriter().write("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
