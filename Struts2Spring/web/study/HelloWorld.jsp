<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><s:text name="HelloWorld.message" /></title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#managerType").click(function() {
			$.ajax({
				type : "post",
				url : "/Struts2Spring/study/Test.action",
				dataType : "json",
				success : function(msg) {
					alert(msg);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("Debug : \n" + jqXHR.responseText);
				}
			});
		});
	});
</script>
</head>

<body>
	<h2>
		<s:property value="message" />
	</h2>

	<h3>Languages</h3>
	<ul>
		<li><s:url id="url" action="HelloWorld">
				<s:param name="request_locale">en</s:param>
			</s:url> <s:a href="%{url}">English</s:a></li>
		<li><s:url id="url" action="HelloWorld">
				<s:param name="request_locale">es</s:param>
			</s:url> <s:a href="%{url}">Espanol</s:a></li>
	</ul>
	<button id="managerType">click</button>
</body>
</html>
