package one;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;





/**
 * Servlet implementation class OneServlet
 */
@WebServlet("/OneServlet")
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
    {
    	arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
		String function=arg0.getParameter("method");
		
		if(function.equals("biao"))
		{
			String date=arg0.getParameter("date");
			basedate.date=date;
			List<OneBean> list=Get.getAll("info", "Date", date);
			java.util.Collections.reverse(list);
			arg0.setAttribute("all", list);
			arg0.getRequestDispatcher("One/NewFile.jsp").forward(arg0, arg1);
		}
		
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
