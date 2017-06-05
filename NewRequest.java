package Websample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewRequest extends HttpServlet{
	public void doGet(HttpServletRequest request , HttpServletResponse response)
	throws ServletException , IOException{
		try{
			response.setContentType("text/html; charset=Windows-31J");
			request.setCharacterEncoding("Windows-31J");
			Connection con = DBManager.getConnection();
			Statement smt = con.createStatement();

			//NewRequestよりデータの受け取り
			String RequestNumber = request.getParameter("RequestNumber");
			String RequestOffice = request.getParameter("RequestOffice");
			String RequestName = request.getParameter("RequestName");
			String Inday = request.getParameter("Inday");
			String Outday = request.getParameter("Outday");
			String SalesPerson = request.getParameter("SalesPerson");
			String CreatePerson = request.getParameter("CreatePerson");
			String EditPerson = request.getParameter("EditPerson");
			String MemoBox = request.getParameter("MemoBox");

			//ProgressNumberとProgressNameの取得
			String ProgressNumber = request.getParameter("ProgressNumber");

			String sql = "INSERT INTO JobManagement(RequestNumber,RequestOffice,RequestName, Inday, Outday,SalesPerson,CreatePerson,EditPerson,MemoBox,ProgressNumber) "
								+"VALUES("+RequestNumber+",'"+RequestOffice+"','"+RequestName+"' ,'"+Inday+"','"+Outday+"','"+SalesPerson+"','"+CreatePerson+"','"+EditPerson+"','"+MemoBox+"','"+ProgressNumber+"')";
			System.out.println(sql);
					int count = smt.executeUpdate("INSERT INTO JobManagement(RequestNumber,RequestOffice,RequestName, Inday, Outday,SalesPerson,CreatePerson,EditPerson,MemoBox,ProgressNumber) "
							+"VALUES("+RequestNumber+",'"+RequestOffice+"','"+RequestName+"' ,'"+Inday+ "','"+Outday+"','"+SalesPerson+"','"+CreatePerson+"','"+EditPerson+"','"+MemoBox+"','"+ProgressNumber+"')");
			System.out.println("update count : " +count);

			//result.jspにデータを渡す
			request.setAttribute("RequestNumber", RequestNumber);
			request.setAttribute("RequestOffice", RequestOffice);
			request.setAttribute("RequestName", RequestName);
			request.setAttribute("Inday", Inday);
			request.setAttribute("Outday", Outday);
			request.setAttribute("SalesPerson", SalesPerson);
			request.setAttribute("CreatePerson", CreatePerson);
			request.setAttribute("EditPerson", EditPerson);
			request.setAttribute("MemoBox", MemoBox);
			request.setAttribute("ProgressNumber", ProgressNumber);

			//request.setAttribute("ProgressName", ProgressName);
			getServletConfig().getServletContext().getRequestDispatcher("/JSP/result.jsp").forward(request,response);
			smt.close();
			con.close();
		}catch(SQLException e){
			response.setContentType("text/html; charset=Windows-31J");
			request.setCharacterEncoding("Windows-31J");
			PrintWriter out = response.getWriter();
			out.println("案件番号が既存のものを使用されているか、エラーが発生しております。");
			System.out.println(e);

		}
		}
	}
