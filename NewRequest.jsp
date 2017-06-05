<%@page language="java" contentType="text/html; charset=Windows-31J"%>

<%@page import="java.util.List,Websample.Account"%>
<%@page import="java.util.Date, java.util.ArrayList,java.sql.* , java.sql.PreparedStatement;"%>

<html>
<body>
<head>
<title>新規案件</title>
</head>
<% request.setCharacterEncoding("Windows-31J"); %>
<h1>	NewRequest</h1>
<link rel="stylesheet" href="..//css/style.css">
<form action ="../NewRequest">
	<p>現在時刻<br>
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

	<p>案件番号			<input type="text" name ="RequestNumber" >
	<p>会社名			<input type="text" name ="RequestOffice">
	<p>案件名			<input type="text" name ="RequestName">
	<p>入稿日			<input type="text" name ="Inday" maxlength='8'>
	<p>納品日			<input type="text" name ="Outday" maxlength='8'>
	<p>担当者（営業）	<input type="text" name ="SalesPerson">
	<p>作成者（製造）	<input type="text" name ="CreatePerson">
	<p>更新者			<input type="text" name ="EditPerson">
	<p>その他メモ		<textarea type="text" name ="MemoBox" rows="2" cols="20" ></textarea>
	<p>進行度
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
      // データベースとの接続をクローズ
      try { smt.close(); } catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
  }%>
	<p><input type="submit" value="新規作成">
</form>

</body>
</html>