<%@page language="java" contentType="text/html; charset=Windows-31J"%>

<%@page import="java.util.List,Websample.Account"%>
<%@page import="java.util.Date, java.util.ArrayList,java.sql.* , java.sql.PreparedStatement;"%>

<html>
<body>
<head>
<title>�V�K�Č�</title>
</head>
<% request.setCharacterEncoding("Windows-31J"); %>
<h1>	NewRequest</h1>
<link rel="stylesheet" href="..//css/style.css">
<form action ="../NewRequest">
	<p>���ݎ���<br>
	<%= new Date() %>

<%
Connection con = null;
Statement smt = null;
String sql= null ;
try{
	con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1234","sa","");
	smt = con.createStatement();
	sql = "SELECT * FROM ProgressTable";
	ResultSet rs = smt.executeQuery(sql);


%>
<table border="1">
<p>

	<p>�Č��ԍ�			<input type="text" name ="RequestNumber" >
	<p>��Ж�			<input type="text" name ="RequestOffice">
	<p>�Č���			<input type="text" name ="RequestName">
	<p>���e��			<input type="text" name ="Inday" maxlength='8'>
	<p>�[�i��			<input type="text" name ="Outday" maxlength='8'>
	<p>�S���ҁi�c�Ɓj	<input type="text" name ="SalesPerson">
	<p>�쐬�ҁi�����j	<input type="text" name ="CreatePerson">
	<p>�X�V��			<input type="text" name ="EditPerson">
	<p>���̑�����		<textarea type="text" name ="MemoBox" rows="2" cols="20" ></textarea>
	<p>�i�s�x
	<select name="ProgressNumber" >
	<%while(rs.next()){%>
	 <option value="<%=rs.getString("ProgressNumber")%>">
	 <%=rs.getString("ProgressName")%></option>
	 <%
	String ProgressNumber = rs.getString("ProgressNumber");
	String ProgressName = rs.getString("ProgressName");
	}
	 %>	</select>
	 </table>
<%}catch(Exception e) {
	System.out.print(e);
  }finally {
      // �f�[�^�x�[�X�Ƃ̐ڑ����N���[�Y
      try { smt.close(); } catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
  }%>
	<p><input type="submit" value="�V�K�쐬">
</form>

</body>
</html>