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
import javax.servlet.http.HttpSession;

public class resultEdit extends HttpServlet{
	public void doGet(HttpServletRequest request , HttpServletResponse response)
	throws ServletException , IOException{
		try{
			response.setContentType("text/html; charset=Windows-31J");
			request.setCharacterEncoding("Windows-31J");
			Connection con = DBManager.getConnection();
			Statement smt = con.createStatement();


			//EditRequestより新データの受け取り
			Integer newRequestNumber = Integer.parseInt(request.getParameter("newRequestNumber"));
			String newRequestOffice = request.getParameter("newRequestOffice");
			String newRequestName = request.getParameter("newRequestName");
			String newInday = request.getParameter("newInday");
			String newOutday = request.getParameter("newOutday");
			String newSalesPerson = request.getParameter("newSalesPerson");
			String newCreatePerson = request.getParameter("newCreatePerson");
			String newEditPerson = request.getParameter("newEditPerson");
			String newMemoBox = request.getParameter("newMemoBox");
			String newProgressNumber = request.getParameter("newProgressNumber");

			//EditRequestより旧データの受け取り
			HttpSession newDate = request.getSession();
			Integer oldRequestNumber = (Integer) newDate.getAttribute("oldRequestNumber");
			String oldRequestOffice = (String) newDate.getAttribute("oldRequestOffice");
			String oldRequestName = (String) newDate.getAttribute("oldRequestName");
			String oldInday = (String) newDate.getAttribute("oldInday");
			String oldOutday = (String) newDate.getAttribute("oldOutday");
			String oldSalesPerson = (String) newDate.getAttribute("oldSalesPerson");
			String oldCreatePerson = (String) newDate.getAttribute("oldCreatePerson");
			String oldEditPerson = (String) newDate.getAttribute("oldEditPerson");
			String oldMemoBox = (String) newDate.getAttribute("oldMemoBox");
			String oldProgressNumber  = (String) newDate.getAttribute("oldProgressNumber");

			System.out.println("old="+oldProgressNumber);
			System.out.println("new =" +newProgressNumber);

			//jspに投げるデータの定義
				int RequestNumber;
				String RequestOffice;
				String RequestName;
				String Inday;
				String Outday;
				String SalesPerson;
				String CreatePerson;
				String EditPerson;
				String MemoBox;
				String ProgressNumber;

			//新旧データの比較
			if(newRequestNumber.equals(oldRequestNumber)){
				RequestNumber = oldRequestNumber;
			}else{
				RequestNumber = newRequestNumber;
			}

			if(newRequestOffice.equals(oldRequestOffice)){
				RequestOffice = oldRequestOffice;
			}else{
				RequestOffice = newRequestOffice;
			}

			if(newRequestName.equals(oldRequestName)){
				RequestName = oldRequestName;
			}else{
				RequestName = newRequestName;
			}

			if(newInday.equals(oldInday)){
				Inday = oldInday;
			}else{
				Inday = newInday;
			}

			if(newOutday.equals(oldOutday)){
				Outday = oldOutday;
			}else{
				Outday = newOutday;
			}

			if(newSalesPerson.equals(oldSalesPerson)){
				SalesPerson = oldSalesPerson;
			}else{
				SalesPerson = newSalesPerson;
			}

			if(newCreatePerson.equals(oldCreatePerson)){
				CreatePerson = oldCreatePerson;
			}else{
				CreatePerson = newCreatePerson;
			}

			if(newEditPerson.equals(oldEditPerson)){
				EditPerson = oldEditPerson;
			}else{
				EditPerson = newEditPerson;
			}

			if(newMemoBox.equals(oldMemoBox)){
				MemoBox = oldMemoBox;
			}else{
				MemoBox = newMemoBox;
			}
			if(newProgressNumber.equals(oldProgressNumber)){
				ProgressNumber = oldProgressNumber;
			}else{
				ProgressNumber = newProgressNumber;
			}
			String sql = ("Update JobManagement set RequestOffice = '"+RequestOffice +
							"', RequestName ='" + RequestName +
							"', Inday = '" +Inday+
								"', Outday = '" +Outday+
									"', SalesPerson = '" +SalesPerson+
										"', CreatePerson = '" +CreatePerson+
											"', EditPerson = '" +EditPerson+
												"', MemoBox = '" +MemoBox+
													"', ProgressNumber = '"+ProgressNumber+
														"' where RequestNumber = " +RequestNumber);
			System.out.println(sql);
			int count = smt.executeUpdate("Update JobManagement set RequestOffice = '"+RequestOffice +
															"', RequestName ='" + RequestName +
															"', Inday = '" +Inday+
															"', Outday = '" +Outday+
															"', SalesPerson = '" +SalesPerson+
															"', CreatePerson = '" +CreatePerson+
															 "', EditPerson = '" +EditPerson+
															"', MemoBox = '" +MemoBox+
															"', ProgressNumber = '"+ProgressNumber+
															"' where RequestNumber = " +RequestNumber);

			System.out.println("update count : " +count);


			//resultEdit.jspにデータを渡す
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
			System.out.println("今回のresultEdit="+RequestNumber);

			getServletConfig().getServletContext().getRequestDispatcher("/JSP/resultEdit.jsp").forward(request,response);

			smt.close();
			con.close();
		}catch(SQLException e){
			response.setContentType("text/html; charset=Windows-31J");
			request.setCharacterEncoding("Windows-31J");
			PrintWriter out = response.getWriter();
			out.println(e);
		}

		}
		}

