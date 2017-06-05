<%@page language="java" contentType="text/html; charset=Windows-31J"%>

<html>
	<head>
		<title>登録結果</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
	</head>
	<body>
        <form method="get" action ="/dbweb/JSP/NewRequest.jsp">

       以下の内容にて登録しました
  	<p>案件番号	<%= request.getAttribute("RequestNumber") %>
	<p>会社名	<%= request.getAttribute("RequestOffice") %>
	<p>案件名	<%= request.getAttribute("RequestName") %>
	<p>入稿日	<%= request.getAttribute("Inday") %>
	<p>納品日	<%= request.getAttribute("Outday") %>
	<p>担当者（営業）<%= request.getAttribute("SalesPerson") %>
	<p>作成者（製造）<%= request.getAttribute("CreatePerson") %>
	<p>更新者	<%= request.getAttribute("EditPerson") %>
	<p>更新者	<%= request.getAttribute("MemoBox") %>
	<p>進行度	<%= request.getAttribute("ProgressNumber") %>
		<p><input type="submit" value="新規作成に戻る">
		</form>
		<form method="get" action ="/dbweb/JSP/MainWindow.jsp">
		<p><input type="submit" value="メイン画面に戻る">
		</form>
	</body>
</html>