package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class customerServlet
 */
@WebServlet("/sendInfo")
public class customerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<table border='2'>");
		out.print("<thead><th>parameter-Name</th>");
		out.print("<th>parameter-Value</th></thead>");
		Enumeration<String> ens=request.getHeaderNames();
		
		while(ens.hasMoreElements())
		{
			String headerName=ens.nextElement();
			String headerValue=request.getHeader(headerName);
			out.println("<tr>");
			out.println("<td>"+headerName+"</td>");
			out.println("<td>"+headerValue+"</td>");
			out.println("</tr>");
			
	}
		out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Enumeration<String> en=request.getParameterNames();
		String customerName=null;
		String email=null;
		String address=null;
		long phone=0;
		
		while(en.hasMoreElements())
		{
			String paramName=en.nextElement();
			if(paramName.equalsIgnoreCase("t1"))
			{
				customerName=request.getParameter(paramName);
			}
			else if (paramName.equalsIgnoreCase("t2"))
			{
				email =request.getParameter(paramName);
				
			}
			else if (paramName.equalsIgnoreCase("t3"))
			{
				address=request.getParameter(paramName);
			}
			else if (paramName.equalsIgnoreCase("t4"))
			{
				String ph=request.getParameter(paramName);
				phone=Long.parseLong(ph);
			}
		}
			out.println("<p><font color='red'>"+customerName+"<br>");
			out.println("<p><font color='green'>"+email+"<br>");
			out.println("<p><font color='blue'>"+phone+"<br>");
			out.println("<p><font color='orange'>"+address+"<br>");
			
		}
	}

