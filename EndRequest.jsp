<%@page contentType="text/html ; charset=Windows-31J"%>
<%@page import ="java.util.List, java.sql.*,Websample.Account"%>

<html>
<head>
<title>終了案件</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/Endstyle.css">
</head>
<body>
<table border ="1" align="center">
<body>
<tr align="center">

<center>
<h1>終了リクエスト(進行度 9～10を表示)
<h3>1 入稿待ち 2 案件登録済み 3 保留案件 4 作業開始 5 作業中(進行度20%)
<h3>6 作業中(進行度50%) 7 作業中(進行度80%) 8 納品待ち
<h3>9 納品済み 10 キャンセル

<form method="get" action ="/dbweb/JSP/MainWindow.jsp">
		<input type="submit" value="Main画面に戻る"></form>
		<form method="get" action ="/dbweb/NowRequest">
		<input type="submit" value="進行案件一覧に戻る">
		</form>
		</center>

<th>修正ボタン
<th>案件番号
<th>会社名
<th>案件名
<th>入稿日
<th>納品日
<th>担当者（営業）
<th>作成者（製造）
<th>更新者
<th>メモ
<th>進行度
<th>削除ボタン

<%
	Connection con = null;
	Statement smt = null;
	try{
		con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1234","sa","");
		smt = con.createStatement();
		List<Account> list = (List<Account>)request.getAttribute("list");
		for(int i = 0; i < list.size(); i++){
			Account account = list.get(i);
			Integer ProgressNumber = Integer.parseInt(account.getProgressNumber());

			if(ProgressNumber >= 9){
%>

	<tr>
	<form action ="../dbweb/EditRequest">
		<td><input type="submit" value=<%=account.getRequestNumber()%> name="Number" %>
	</form>
		<td><%=account.getRequestNumber() %>
		<td><%=account.getRequestOffice() %>
		<td><%=account.getRequestName() %>
		<td><%=account.getInday() %>
		<td><%=account.getOutday() %>
		<td><%=account.getSalesPerson() %>
		<td><%=account.getCreatePerson() %>
		<td><%=account.getEditPerson() %>
		<td><%=account.getMemoBox() %>
		<td><%=account.getProgressNumber() %>
	<form action ="../dbweb/EndRequest">
		<td><input type="submit" value=<%=account.getRequestNumber()%> name="Delete" %>
	</form>
		<%

			}
		}

		%>

<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(smt != null){
			try{smt.close();}catch(SQLException ignore){}
		}
		if(con != null){
			try{con.close();}catch(SQLException ignore){}
		}
	}

%>

</td>
</tr>

</table>
</body>
</html>