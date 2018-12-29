package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/info")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
				
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<head><title>info</title><head>");
		out.print("<body>");
		
		String uri = request.getRequestURI();
		String url = request.getRequestURL().toString();
		String localaddr = request.getLocalAddr();
		String remoteaddr = request.getRemoteAddr();
		String contextpath = request.getContextPath();
		
		out.print("uri : " + uri + "<br>");
		out.print("url : " + url + "<br>");
		out.print("localaddr : " + localaddr + "<br>");
		out.print("remoteaddr : " + remoteaddr + "<br>");
		out.print("contextpath : " + contextpath + "<br>");
		out.print("</body>");
		out.print("</html>");
	}

}
