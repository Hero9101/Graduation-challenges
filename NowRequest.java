package Websample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowRequest 	extends HttpServlet{
	public void doGet(HttpServletRequest request , HttpServletResponse response)
		throws ServletException , IOException{

		String sql = "select * from JobManagement";

		Connection con = null;
		Statement smt = null;
		try{
			con = DBManager.getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			List<Account> list = new ArrayList<Account>();
			String Delete = (String)request.getParameter("Delete");
			if(	Delete != null){
				int DeleteSQL = smt.executeUpdate("Delete From JobManagement where RequestNumber = " + Delete ) ;
			}
			while(rs.next()){
					Account account = new Account();
					account.setRequestNumber(rs.getInt("RequestNumber"));
					account.setRequestOffice(rs.getString("RequestOffice"));
					account.setRequestName(rs.getString("RequestName"));
					account.setInday(rs.getString("Inday"));
					account.setOutday(rs.getString("Outday"));
					account.setSalesPerson(rs.getString("SalesPerson"));
					account.setCreatePerson(rs.getString("CreatePerson"));
					account.setEditPerson(rs.getString("EditPerson"));
					account.setMemoBox(rs.getString("MemoBox"));
					account.setProgressNumber(rs.getString("ProgressNumber"));
					list.add(account);
			}
			request.setAttribute("list",list);
		}catch(SQLException e){
			throw new ServletException (e);
		}finally{
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}
			}
		}

		request.getRequestDispatcher("/JSP/NowRequest.jsp").forward(request,response);
	}

}
