<%@page contentType="text/html ; charset=Windows-31J"%>
<%@page import ="java.util.List,java.sql.*,Websample.Account"%>

<html>
<head>
	<title>�i�s�Č�</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/Nowstyle.css">
</head>
<body>
<table border ="1" align="center">

<tr align="center">

<center>
<h1>�i�s�����N�G�X�g(�i�s�x 1�`8��\��)</h1>
<h3>1 ���e�҂� 2 �Č��o�^�ς� 3 �ۗ��Č� 4 ��ƊJ�n 5 ��ƒ�(�i�s�x20%)</h3>
<h3>6 ��ƒ�(�i�s�x50%) 7 ��ƒ�(�i�s�x80%) 8 �[�i�҂�</h3>
<h3>9 �[�i�ς� 10 �L�����Z��</h3>

<form method="get" action ="/dbweb/JSP/MainWindow.jsp">
		<input type="submit" value="Main��ʂɖ߂�">
		</form>
		<form method="get" action ="/dbweb/EndRequest">
		<input type="submit" value="�I���Č��ꗗ�ɖ߂�">
		</form>
</center>


<th>�C���{�^��
<th>�Č��ԍ�
<th>��Ж�
<th>�Č���
<th>���e��
<th>�[�i��
<th>�S���ҁi�c�Ɓj
<th>�쐬�ҁi�����j
<th>�X�V��
<th>����
<th>�i�s�x
<th>�폜�{�^��

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
		if(ProgressNumber <= 8){
%>

	<tr>
	<form action ="../dbweb/EditRequest">
		<td><input type="submit" value=<%=account.getRequestNumber()%> name="Number" >
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
		<form action ="../dbweb/NowRequest">
		<td><input type="submit" value=<%=account.getRequestNumber()%> name="Delete" >
		</form>
<%
		}
	}
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