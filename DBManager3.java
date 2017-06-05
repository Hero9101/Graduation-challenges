package Websample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import 元WebSample.ResultSetBeanMapping;

public class DBManager3  extends DBManager2{
	public static <T>List<T> simpleFind(String sql , ResultSetBeanMapping<T> mapping)
	throws SQLException{
		Connection con = null;
		Statement smt = null;
				try{
					con = getConnection();
					smt = con.createStatement();
					ResultSet rs = smt.executeQuery(sql);

					List<T>  list = new ArrayList<T>();

					while(rs.next()){
						T bean = mapping.createFromResultSet(rs);
						list.add(bean);
					}
					return list;
				}finally{
					if(smt != null){
						try{smt.close();} catch(SQLException ignore){}
					}
					if(con != null){
						try{con.close();} catch(SQLException ignore){}
					}
				}
	}

}
