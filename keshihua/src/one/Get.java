package one;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;



public class Get {
	public static List<base> find(String table,String id)
	{
		List<base> list=new ArrayList<base>();
		boolean c;
		String str[]={"����ʡ","����ʡ","������ʡ","�ӱ�ʡ","ɽ��ʡ","����ʡ","ɽ��ʡ","����ʡ","����ʡ","�㽭ʡ","����ʡ","����ʡ","����ʡ","����ʡ","̨��","����ʡ","����ʡ","����ʡ","�Ĵ�ʡ","����ʡ","�㶫ʡ","����ʡ","�ຣʡ","����������","�½�ά���������","����׳��������","���ɹ�������","���Ļ��������� ","������","�����","�Ϻ���","������","���","����" };

		int num[]=new int[34];
		for(int i=0;i<34;i++)
		{
			num[i]=0;
			System.out.println(str[i]);
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
							System.out.println(rs.getString(5));
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
				
				base b=new base();
				b.setShengfen(str[i]);
				b.setRenshu(num[i]+"");
				list.add(b);
			}
			
			
			System.out.println("over");
		
		}
		catch(Exception e)
		{
			
		}
		return list;
	}
	public static List<OneBean> getAll(String table,String name,String value)
	{
		List<OneBean> list=new ArrayList<OneBean>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		String sql="select * from "+table+" where "+name+" ='"+value+"'";
		try
		{
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			while(rs.next())
			{
				if(!(rs.getString(3).equals("")||rs.getString(3)==null))
				{
					OneBean ob=new OneBean();
					ob.setShengfen(rs.getString(3));
					if(rs.getString(4).equals("")||rs.getString(4)==null)
					{
						ob.setChengshi("");
					}
					else
					{
						ob.setChengshi(rs.getString(4));
					}
					ob.setQuezhen(rs.getString(5));
					ob.setYisi(rs.getString(6));
					ob.setZhiyu(rs.getString(7));
					ob.setSiwang(rs.getString(8));
					list.add(ob);
				}
			}
			rs.close();
			state.close();
			conn.close();
		}
		catch(Exception e)
		{
			
		}
		
		if(list!=null) {
			
			return list;
		}else {
			
			return null;
		}
	}

}
