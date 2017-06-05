package Websample;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager2 extends DBManager {
	public static int simpleUpdate(String sql)
		throws SQLException{
			Connection con= null;
			Statement  smt = null;
			try{
				con = getConnection();
				smt = con.createStatement();
				return smt.executeUpdate(sql);
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
