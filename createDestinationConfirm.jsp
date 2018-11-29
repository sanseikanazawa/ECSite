<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/create.css">
<link rel="stylesheet" href="./css/settlementconfirm.css" >
<title>宛先情報確認</title>
</head>
<body>
<s:include value="header.jsp"/>
<div class="contents">
<div class="title">宛先情報確認画面</div>
	<p>以下の内容で登録します</p>
<div class="create">
<s:form action="CreateDestinationCompleteAction">
<table class="list-table">
<tr>
	<th scope="row">
		<s:label value="姓"/>
	</th>
	<td>
		<s:property value="familyName"/>
		<s:hidden name="familyName" value="%{familyName}"/>
	</td>
</tr>
<tr>
	<th scope="row">
		<s:label value="名"/>
	</th>
	<td>
		<s:property value="firstName"/>
		<s:hidden name="firstName" value="%{firstName}"/>
	</td>
</tr>
<tr>
	<th scope="row">
		<s:label value="姓ふりがな"/>
	</th>
	<td>
		<s:property value="familyNameKana"/>
		<s:hidden name="familyNameKana" value="%{familyNameKana}"/>
	</td>
</tr>
<tr>
	<th scope="row">
		<s:label value="名ふりがな"/>
	</th>
	<td>
		<s:property value="firstNameKana"/>
		<s:hidden name="firstNameKana" value="%{firstNameKana}"/>
	</td>
</tr>
<tr>
	<th scope="row">
		<s:label value="性別"/>
	</th>
		<s:if test="%{sex==0}">
			<td>男</td>
		</s:if>
		<s:else>
			<td>女</td>
		</s:else>
		<s:hidden name="sex" value="%{sex}"/>
</tr>
<tr>
	<th scope="row">
		<s:label value="住所"/>
	</th>
	<td>
		<s:property value="userAddress"/>
		<s:hidden name="userAddress" value="%{userAddress}"/>
	</td>
</tr>
<tr>
	<th scope="row">
		<s:label value="電話番号"/>
	</th>
	<td>
		<s:property value="telNumber"/>
		<s:hidden name="telNumber" value="%{telNumber}"/>
	</td>
</tr>
<tr>
	<th scope="row">
		<s:label value="メールアドレス"/>
	</th>
	<td>
		<s:property value="email"/>
		<s:hidden name="email" value="%{email}"/>
	</td>
</tr>
</table>
<div class="submit_btn_box">
<s:token/>
<s:submit value="宛先情報登録" class="btn_blue" />
</div>
</s:form>
</div>
</div>
<s:include value="footer.jsp"/>
</body>
</html>