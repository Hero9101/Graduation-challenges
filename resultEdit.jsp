<%@page language="java" contentType="text/html; charset=Windows-31J"%>

<html>
	<head>
		<title>�C������</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
	</head>
	<body>
        <form method="get" action ="/dbweb/NowRequest">

       �ȉ��̓��e�ɂďC�����܂���
  	<p>�Č��ԍ�			<%= request.getAttribute("RequestNumber") %>
	<p>��Ж�			<%= request.getAttribute("RequestOffice") %>
	<p>�Č���			<%= request.getAttribute("RequestName") %>
	<p>���e��			<%= request.getAttribute("Inday") %>
	<p>�[�i��			<%= request.getAttribute("Outday") %>
	<p>�S���ҁi�c�Ɓj	<%= request.getAttribute("SalesPerson") %>
	<p>�쐬�ҁi�����j	<%= request.getAttribute("CreatePerson") %>
	<p>�X�V��			<%= request.getAttribute("EditPerson") %>
	<p>�X�V��			<%= request.getAttribute("MemoBox") %>
	<p>�i�s�x			<%= request.getAttribute("ProgressNumber") %>

		<p><input type="submit" value="�i�s�Č��ꗗ�ɖ߂�">
		</form>
		<form method="get" action ="/dbweb/EndRequest">
		<p><input type="submit" value="�I���Č��ꗗ�ɖ߂�">

		</form>
	</body>
</html>