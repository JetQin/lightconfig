<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html lang="zh">
<head>
<title>系统配置</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="system config page">
<meta name="author" content="JetQin">

<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-select.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-select.css">


<script type="text/javascript">
	$(document).ready(function()
	{
		$('select').selectpicker();
	});
</script>

</head>
<body>
	<select class="selectpicker">
		<option>南方分中心</option>
		<option>北方分中心</option>
		<option>5分钟阈值设置</option>
	</select>
</body>
</html>