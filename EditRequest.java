package Websample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class EditRequest extends HttpServlet {
	public void doGet(HttpServletRequest request , HttpServletResponse response)
	throws ServletException , IOException{


			Connection con = null;
			Statement smt = null;

			try{
				response.setContentType("text/html; charset=Windows-31J");
				request.setCharacterEncoding("Windows-31J");
				con = DBManager.getConnection();
				smt = con.createStatement();

				String Number = request.getParameter("Number");
				String sql = " select * from JobManagement " + "where RequestNumber = "+Number+"; ";
				System.out.println("SQL =" + sql);
				List<Account> list = new ArrayList<Account>();
				ResultSet rs = smt.executeQuery(sql );



				if(rs.next()){
					Account account = new Account();
					/*
					System.out.println("RequestNumber="+rs.getInt("RequestNumber")+" ,TITLE="+rs.getString("RequestOffice")+" ,PRICE="+rs.getString( "RequestName")
									+ rs.getString("Inday") + rs.getString("Outday") + rs.getString("SalesPerson") + rs.getString("CreatePerson") +rs.getString("MemoBox") );
					*/
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
				//進捗のインポート

				request.setAttribute("list",list);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/EditRequest.jsp");
                System.out.println(dispatcher);
                System.out.println(request);
                System.out.println(response);
                dispatcher.forward(request, response);

				smt.close();
				con.close();

			}catch(SQLException e){
			throw new ServletException(e);
			}
			}
		}



