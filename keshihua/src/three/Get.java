package three;

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
				
				base b=new base();
				b.setName(str0[i]);
				b.setValue(num[i]+"");
				list.add(b);
			}
			
			
			System.out.println("over");
		
		}
		catch(Exception e)
		{
			
		}
		return list;
	}
	public static List<base1> find(String table,String id,String shengfen)
	{
		List<base1> list=new ArrayList<base1>();
		boolean c;
		String str[]={"����ʡ","����ʡ","������ʡ","�ӱ�ʡ","ɽ��ʡ","����ʡ","ɽ��ʡ","����ʡ","����ʡ","�㽭ʡ","����ʡ","����ʡ","����ʡ","����ʡ","̨��","����ʡ","����ʡ","����ʡ","�Ĵ�ʡ","����ʡ","�㶫ʡ","����ʡ","�ຣʡ","����������","�½�ά���������","����׳��������","���ɹ�������","���Ļ��������� ","������","�����","�Ϻ���","������","���","����" };
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try
		{
			state=conn.createStatement();
			String sql="select * from "+table+" where Date ='"+id+"' and Province = '"+shengfen+"'";
			ResultSet rs=state.executeQuery(sql);
			System.out.println("����");
			while(rs.next())
			{
				if(!(rs.getString(3).equals("")||rs.getString(3)==null)&&!(rs.getString(4).equals("")||rs.getString(4)==null))
				{	System.out.println(rs.getString(4));
					System.out.println(rs.getString(5));
					base1 b=new base1();
					b.setName(rs.getString(4));
					b.setValue(rs.getString(5));
					list.add(b);
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
		return list;
	}
	

}
