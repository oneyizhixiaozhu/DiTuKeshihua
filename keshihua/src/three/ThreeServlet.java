package three;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


/**
 * Servlet implementation class ThreeServlet
 */
@WebServlet("/ThreeServlet")
public class ThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThreeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
    {
    	arg1.setContentType("text/html;charset=utf-8");
    	arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
		String date=arg0.getParameter("date");
		base3date.date=date;
        List list=Get.find("info", date);
        arg0.setAttribute("mapDataJson", JSONArray.fromObject(list));
		/*
		 * List<TwoBean> all=Get.find1("info", date); Gson gson = new Gson(); String
		 * json = gson.toJson(all); arg0.setAttribute("message", json);
		 */
		
     
        arg0.getRequestDispatcher("Three/NewFile.jsp").forward(arg0, arg1);
        /*map = new HashMap<String, Object>();
        map.put("name","ºÓ±±");
        map.put("value",2400);
        list.add(map);*/

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
