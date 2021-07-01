package three;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import two.base2date;

/**
 * Servlet implementation class Province
 */
@WebServlet("/Province")
public class Province extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Province() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
    {
    	arg1.setContentType("text/html;charset=utf-8");
    	arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
		
		
		String str[]={"辽宁省","吉林省","黑龙江省","河北省","山西省","陕西省","山东省","安徽省","江苏省","浙江省","河南省","湖北省","湖南省","江西省","台湾","福建省","云南省","海南省","四川省","贵州省","广东省","甘肃省","青海省","西藏自治区","新疆维吾尔自治区","广西壮族自治区","内蒙古自治区","宁夏回族自治区 ","北京市","天津市","上海市","重庆市","香港","澳门" };
		String str0[]={"辽宁","吉林","黑龙江","河北","山西","陕西","山东","安徽","江苏","浙江","河南","湖北","湖南","江西","台湾","福建","云南","海南","四川","贵州","广东","甘肃","青海","西藏","新疆","广西","内蒙古","宁夏 ","北京","天津","上海","重庆","香港","澳门" };
		
		System.out.println("!!!!!!!");
		String shengfen=arg0.getParameter("shengfen");
		String date=base3date.date;
		String shengfen0=arg0.getParameter("shengfen0");
		System.out.println(shengfen);
		System.out.println(shengfen0);
		
		for(int i=0;i<34;i++)
		{
			if(shengfen.equals(str0[i]))
			{
				shengfen=str[i];
				break;
			}
		}
		
		List<base1> list = Get.find("info", date, shengfen);
		arg0.setAttribute("mapDataJson", JSONArray.fromObject(list));
		arg0.setAttribute("province", shengfen0);
     
        arg0.getRequestDispatcher("Three/NewFile1.jsp").forward(arg0, arg1);
        

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
