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
<script src="assets/js/bootstrap-editable.js"></script>
<script src="assets/js/jquery.mockjax.js"></script>
<script src="assets/js/moment.min.js"></script> 
<script src="assets/js/demo.js"></script>
<script src="assets/js/demo-mock.js"></script>

<link href="assets/css/bootstrap-editable.css" rel="stylesheet">
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">  
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
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span10">
				<select class="selectpicker">
					<option>南方分中心</option>
					<option>北方分中心</option>
					<option>5分钟阈值设置</option>
				</select>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span12">
						<table id="contentTable" class="table table-bordered table-striped">
							<tr>
								<td>阈值有效范围</td>
								<td>接通率告警</td>
								<td>接通率严重告警</td>
								<td>20S接通率告警</td>
								<td>20S接通率严重告警</td>
								<td>排队数</td>
								<td>外呼时长</td>
								<td>呼入时长</td>
								<td>案头时长</td>
								<td>放弃率</td>
							</tr>
							<s:iterator value="provinces" status="province">
								<s:if test="-1!=provinceID">
									<tr>
										<td><s:property value="provinceName" />
										</td>
										<td><a href="#" id="username" data-type="text" data-pk="1" data-original-title="输入新值"><s:property value="connectAlarmRate" /></a>
										</td>
										<td><a href="#" id="username" data-type="text" data-pk="1" data-original-title="输入新值"><s:property value="connectErrorRate" /></a>
										</td>
										<td><a href="#" id="username" data-type="text" data-pk="1" data-original-title="输入新值"><s:property value="connectShortAlarmRate" /></a>
										</td>
										<td><a href="#" id="username" data-type="text" data-pk="1" data-original-title="输入新值"><s:property value="connectShortErrorRate" /></a>
										</td>
										<td><a href="#" id="username" data-type="text" data-pk="1" data-original-title="输入新值"><s:property value="queueNo" /></a>
										</td>
										<td><a href="#" id="username" data-type="text" data-pk="1" data-original-title="输入新值"><s:property value="outboundTime" /></a>
										</td>
										<td><a href="#" id="username" data-type="text" data-pk="1" data-original-title="输入新值"><s:property value="inboundTime" /></a>
										</td>
										<td><a href="#" id="username" data-type="text" data-pk="1" data-original-title="输入新值"><s:property value="desktopTime" /></a>
										</td>
										<td><a href="#" id="username" data-type="text" data-pk="1" data-original-title="输入新值"><s:property value="abandonRate" /></a>
									</tr>
								</s:if>
								<s:else>
									<td><s:property value="provinceName" />
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</s:else>
							</s:iterator>
						</table>
					</div>
				</div>
			</div>
		</div>
		<hr>

		<footer>
		<p>© Company 2013</p>
		</footer>

	</div>
</body>
</html>