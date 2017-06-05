package Websample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mondai extends HttpServlet{
	public void doGet(HttpServletRequest request , HttpServletResponse response)
	throws ServletException , IOException{
		try{
			Connection con = DBManager.getConnection();
			Statement smt = con.createStatement();
			//echoよりデータの受け取り
			String ID = request.getParameter("ID");
			String Name = request.getParameter("Name");
			String Money = request.getParameter("Money");

		   //sqlにデータ入力
			String sql = "INSERT INTO account(ID,NAME,MONEY) "+"VALUES("+ID+",'"+Name+"',"+Money+")";
			System.out.println(sql);
					int count = smt.executeUpdate("INSERT INTO account(ID,NAME,MONEY) "+"VALUES("+ID+",'"+Name+"',"+Money+")");
			System.out.println("update count : " +count);
					ResultSet rs = smt.executeQuery("select * from account");
			//データの出力
			PrintWriter out = response.getWriter();
			while(rs.next()){
				out.println("ID="+rs.getInt("ID")+" ,TITLE="+rs.getString( "Name")+" ,PRICE="+rs.getInt( "Money"));
			}

			smt.close();
			con.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		}
	}
