<%@page language="java" contentType="text/html; charset=Windows-31J"%>

<html>
	<head>
		<title>�o�^����</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
	</head>
	<body>
        <form method="get" action ="/dbweb/JSP/NewRequest.jsp">

       �ȉ��̓��e�ɂēo�^���܂���
  	<p>�Č��ԍ�	<%= request.getAttribute("RequestNumber") %>
	<p>��Ж�	<%= request.getAttribute("RequestOffice") %>
	<p>�Č���	<%= request.getAttribute("RequestName") %>
	<p>���e��	<%= request.getAttribute("Inday") %>
	<p>�[�i��	<%= request.getAttribute("Outday") %>
	<p>�S���ҁi�c�Ɓj<%= request.getAttribute("SalesPerson") %>
	<p>�쐬�ҁi�����j<%= request.getAttribute("CreatePerson") %>
	<p>�X�V��	<%= request.getAttribute("EditPerson") %>
	<p>�X�V��	<%= request.getAttribute("MemoBox") %>
	<p>�i�s�x	<%= request.getAttribute("ProgressNumber") %>
		<p><input type="submit" value="�V�K�쐬�ɖ߂�">
		</form>
		<form method="get" action ="/dbweb/JSP/MainWindow.jsp">
		<p><input type="submit" value="���C����ʂɖ߂�">
		</form>
	</body>
</html>