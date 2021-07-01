package two;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBUtil;
import one.OneBean;
import one.base;

public class Get {
	public static List find(String table,String id)
	{
		List list =new ArrayList();
		boolean c;
		String str[]={"����ʡ","����ʡ","������ʡ","�ӱ�ʡ","ɽ��ʡ","����ʡ","ɽ��ʡ","����ʡ","����ʡ","�㽭ʡ","����ʡ","����ʡ","����ʡ","����ʡ","̨��","����ʡ","����ʡ","����ʡ","�Ĵ�ʡ","����ʡ","�㶫ʡ","����ʡ","�ຣʡ","����������","�½�ά���������","����׳��������","���ɹ�������","���Ļ��������� ","������","�����","�Ϻ���","������","���","����" };
		String str0[]={"����","����","������","�ӱ�","ɽ��","����","ɽ��","����","����","�㽭","����","����","����","����","̨��","����","����","����","�Ĵ�","����","�㶫","����","�ຣ","����","�½�","����","���ɹ�","���� ","����","���","�Ϻ�","����","���","����" };
		int num[]=new int[34];
		for(int i=0;i<34;i++)
		{
			num[i]=0;
		}
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try
		{
			state=conn.createStatement();
			String sql="select * from "+table+" where Date ='"+id+"'";
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				
				if(!(rs.getString(3).equals("")||rs.getString(3)==null)&&(rs.getString(4).equals("")||rs.getString(4)==null))
				{
					
					for(int i=0;i<34;i++)
					{
						if(str[i].equals(rs.getString(3)))
						{
							
							int s=Integer.parseInt(rs.getString(5));
							num[i]+=s;
							
						}
					}
				}
			}
			rs.close();
			state.close();
			conn.close();
			
			for(int i=0;i<34;i++)
			{
				Map<String, Object> map = new HashMap<String, Object>();
		        map.put("name",str0[i]);
		        map.put("value",num[i]);
		        list.add(map);
			}
			
			
			System.out.println("over");
			System.out.println(1);
		
		}
		catch(Exception e)
		{
			
		}
		return list;
	}
	
	
	public TwoBean  find1(String table,String id,String shengfen)
	{
		TwoBean tb=new TwoBean();
		tb.setQuezhen("0");
		tb.setYisi("0");
		tb.setZhiyu("0");
		tb.setSiwang("0");
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try
		{
			state=conn.createStatement();
			String sql="select * from "+table+" where Date ='"+id+"' and Province ='"+shengfen+"'";
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				if(!(rs.getString(3).equals("")||rs.getString(3)==null)&&(rs.getString(4).equals("")||rs.getString(4)==null))
				{
					tb.setQuezhen(rs.getString(5));
					tb.setYisi(rs.getString(6));
					tb.setZhiyu(rs.getString(7));
					tb.setSiwang(rs.getString(8));
				}
			}
			rs.close();
			state.close();
			conn.close();
			System.out.println("over");
		
		}
		catch(Exception e)
		{
			
		}
		return tb;
	}
	
	
	
	

}
