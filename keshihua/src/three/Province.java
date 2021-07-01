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
		
		
		String str[]={"����ʡ","����ʡ","������ʡ","�ӱ�ʡ","ɽ��ʡ","����ʡ","ɽ��ʡ","����ʡ","����ʡ","�㽭ʡ","����ʡ","����ʡ","����ʡ","����ʡ","̨��","����ʡ","����ʡ","����ʡ","�Ĵ�ʡ","����ʡ","�㶫ʡ","����ʡ","�ຣʡ","����������","�½�ά���������","����׳��������","���ɹ�������","���Ļ��������� ","������","�����","�Ϻ���","������","���","����" };
		String str0[]={"����","����","������","�ӱ�","ɽ��","����","ɽ��","����","����","�㽭","����","����","����","����","̨��","����","����","����","�Ĵ�","����","�㶫","����","�ຣ","����","�½�","����","���ɹ�","���� ","����","���","�Ϻ�","����","���","����" };
		
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
