<%@page language="java" contentType="text/html; charset=Windows-31J"%>
<%@page import="java.util.List, java.sql.*,Websample.Account" %>

<html>
	<head>
		<title>�C�����</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
	</head>
	<form method ="get" action ="../dbweb/resultEdit">

	<body>
	<Table border="1">
<%
	Connection con = null;
	Statement smt = null;
	try{
		con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1234","sa","");
		smt = con.createStatement();
			List<Account> list=(List<Account>)request.getAttribute("list");
			String sql = "SELECT * FROM ProgressTable";
			ResultSet rs = smt.executeQuery(sql);
	for(int i= 0; i<list.size();i++){
		Account account = list.get(i);

	int oldRequestNumber = account.getRequestNumber();
	String oldRequestOffice = account.getRequestOffice();
	String oldRequestName = account.getRequestName();
	String oldInday = account.getInday();
	String oldOutday = account.getOutday();
	String oldSalesPerson = account.getSalesPerson();
	String oldCreatePerson = account.getCreatePerson();
	String oldEditPerson = account.getEditPerson();
	String oldMemoBox = account.getMemoBox();
	String oldProgressNumber = account.getProgressNumber();

	StringBuffer buf = new StringBuffer();

%>
	<tr>
	<td>
	<p>�Č��ԍ�<input type="text" name ="newRequestNumber" Value="<%=oldRequestNumber%>">
	<p>��Ж�<input type="text" name ="newRequestOffice" value="<%=oldRequestOffice%>">
	<p>�Č���<input type="text" name ="newRequestName" value="<%=oldRequestName%>">
	<p>���e��<input type="text" name ="newInday" value="<%=oldInday%>"maxlength='8'>
	<p>�[�i��<input type="text" name ="newOutday" value="<%=oldOutday%>"maxlength='8'>
	<p>�S���ҁi�c�Ɓj<input type="text" name ="newSalesPerson" value="<%=oldSalesPerson%>">
	<p>�쐬�ҁi�����j<input type="text" name ="newCreatePerson" value="<%=oldCreatePerson%>">
	<p>�X�V��<input type="text" name ="newEditPerson" value="<%=oldEditPerson%>">
	<p>���̑�����<textarea name ="newMemoBox" value="<%=oldMemoBox%>" rows="2" cols="20"><%=oldMemoBox%></textarea>
		<p>�i�s�x

	<select name="newProgressNumber" >
	<%while(rs.next()){%>
	 <option value="<%=rs.getString("ProgressNumber")%>"><%=rs.getString("ProgressName")%></option>

	 <%
	}

	 %>
	</select>

<%
	System.out.println("Edit oldProgressNumber= "+oldProgressNumber);


/*
String sql ="UPDATE PUBLIC.JOBMANAGEMENT SET REQUESTOFFICE = '"+RequestOffice+"' where RequestNumber =  "+RequestNumber ;
System.out.println(sql);
*/
	HttpSession newDate = request.getSession();
	newDate.setAttribute("oldRequestNumber" ,oldRequestNumber);
	newDate.setAttribute("oldRequestOffice" ,oldRequestOffice);
	newDate.setAttribute("oldRequestName" ,oldRequestName);
	newDate.setAttribute("oldInday" ,oldInday);
	newDate.setAttribute("oldOutday" ,oldOutday);
	newDate.setAttribute("oldSalesPerson" ,oldSalesPerson);
	newDate.setAttribute("oldCreatePerson" ,oldCreatePerson);
	newDate.setAttribute("oldEditPerson" ,oldEditPerson);
	newDate.setAttribute("oldMemoBox" ,oldMemoBox);
	newDate.setAttribute("oldProgressNumber" ,oldProgressNumber);
	System.out.println("Edit Request RequestNumber="+oldRequestNumber);
	getServletConfig().getServletContext().getRequestDispatcher("resultEdit").forward(request,response);

	%>
<%
	smt.close();
	con.close();
	}
	try { smt.close(); } catch (Exception e) {}
    try { con.close(); } catch (Exception e) {}
	}catch(Exception e){
		e.printStackTrace();
	}
%>
	<p><INPUT type=submit value='���M'/>
		</Table>
		</form>
		<!--
		<form method ="get" action ="../dbweb/JSP/DeleteRequest.jsp">
		<p><INPUT type=submit name="Delete" value='���̈Č��̍폜'/>
		-->
		<%
		/*
		if(Delete == 1){
			String DeleteSQL = "Delete From JobManagement where RequestNumber = " +Integer.parseInt(oldRequestNumber) ;
			ResuletSet Deleters = smt.executeQuery(DeleteSQL);

		*/
		%>

		</form>
	</body>
</html>