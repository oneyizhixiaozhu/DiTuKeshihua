package three;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import two.Get;
import two.TwoBean;
import two.base2date;

/**
 * Servlet implementation class Three
 */
@WebServlet("/Three")
public class Three extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Three() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
		String str[]={"����ʡ","����ʡ","������ʡ","�ӱ�ʡ","ɽ��ʡ","����ʡ","ɽ��ʡ","����ʡ","����ʡ","�㽭ʡ","����ʡ","����ʡ","����ʡ","����ʡ","̨��","����ʡ","����ʡ","����ʡ","�Ĵ�ʡ","����ʡ","�㶫ʡ","����ʡ","�ຣʡ","����������","�½�ά���������","����׳��������","���ɹ�������","���Ļ��������� ","������","�����","�Ϻ���","������","���","����" };
		String str0[]={"����","����","������","�ӱ�","ɽ��","����","ɽ��","����","����","�㽭","����","����","����","����","̨��","����","����","����","�Ĵ�","����","�㶫","����","�ຣ","����","�½�","����","���ɹ�","���� ","����","���","�Ϻ�","����","���","����" };
		String shengfen = arg0.getParameter("shengfen");
		System.out.println("���磺"+shengfen);
		TwoBean tb=new TwoBean();
		Get g=new Get();
		for(int i=0;i<32;i++)
		{
			if(shengfen.equals(str0[i]))
			{
				tb=g.find1("info", base2date.date, str[i]);
			}
		}
		System.out.println(tb.getQuezhen());

		
		Gson gson = new Gson();
		String json = gson.toJson(tb);
		
		try {
			arg1.getWriter().println(json);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			arg1.getWriter().close(); 
		}
		
		/*
		 * map = new HashMap<String, Object>(); map.put("name","�ӱ�");
		 * map.put("value",2400); list.add(map);
		 */

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
