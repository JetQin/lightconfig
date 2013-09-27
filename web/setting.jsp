<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html lang="zh">
<head>
<title>系统配置</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="system config page">
<meta name="author" content="JetQin">

<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-select.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-editable.js"></script>

<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/bootstrap-select.css" rel="stylesheet">
<link href="assets/css/bootstrap-editable.css" rel="stylesheet">
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

<script type="text/javascript">
	$(document).ready(function()
	{
		$('select').selectpicker();
		$("[name='region']").attr("value", $("#regionSelect").val());

		$('#regionSelect').change(function()
		{
			$("[name='region']").attr("value", $("#regionSelect").val());
		});
		$("#btnSave").click(function()
		{
			$.ajax(
			{
				url : "saveSetting",
				data :
				{
					region : $("[name='region']").val(),
					group : $("[name='group']").val(),
					province : $("[name='province']").val(),
					cityName : $("[name='cityName']").val()
				}
			}).done(function(html)
			{
				document.getElementById("group").value="";
				document.getElementById("province").value="";
				document.getElementById("cityName").value="";
				$("#myModal>.modal-body").html('<span class="badge badge-success">'+html.operation+'</span>');
				$("#myModal").modal();
			});
		});

	});
</script>

</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span10">
				<form id="selectForm" class="form-horizontal" >
					<input type="hidden" value="" name="region" />
					<div class="control-group">
						<label class="control-label" for="inputPassword">新增省份信息</label>
						<div class="controls">
							<select id="regionSelect" class="selectpicker">
								<option value="S">南方中心</option>
								<option value="N">北方中心</option>
							</select>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword">客服部:</label>
						<div class="controls">
							<input id="group" name="group" type="text" placeholder="请输入客服部">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword">省份:</label>
						<div class="controls">
							<input id="province" name="province" type="text" placeholder="请输入省份">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword">城市:</label>
						<div class="controls">
							<input id="cityName" name="cityName" type="text" placeholder="请输入城市">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button id="btnSave" type="button" class="btn btn-primary">保存</button>
							<button id="btnCancel" type="button" class="btn btn-primary">取消</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">操作结果</h3>
				</div>
				<div class="modal-body">
					<p></p>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">确定</button>
				</div>
		</div>

		<hr>

		<footer>
		<p>© Company 2013</p>
		</footer>

	</div>
</body>
</html>