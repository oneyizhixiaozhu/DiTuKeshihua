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
		String str[]={"辽宁省","吉林省","黑龙江省","河北省","山西省","陕西省","山东省","安徽省","江苏省","浙江省","河南省","湖北省","湖南省","江西省","台湾","福建省","云南省","海南省","四川省","贵州省","广东省","甘肃省","青海省","西藏自治区","新疆维吾尔自治区","广西壮族自治区","内蒙古自治区","宁夏回族自治区 ","北京市","天津市","上海市","重庆市","香港","澳门" };
		String str0[]={"辽宁","吉林","黑龙江","河北","山西","陕西","山东","安徽","江苏","浙江","河南","湖北","湖南","江西","台湾","福建","云南","海南","四川","贵州","广东","甘肃","青海","西藏","新疆","广西","内蒙古","宁夏 ","北京","天津","上海","重庆","香港","澳门" };
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
