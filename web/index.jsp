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
	$(document).ready(
	function()
	{
		$('select').selectpicker();

		var local = document.getElementById("currentregion").value;
		var heading = $("#regionSelect option[value='" + local+ "']").text();
	    $("#heading").append("<h4>"+heading+"</h4>");
		
		$('#regionSelect').change(function()
		{
			
			$("[name='region']").attr("value",$("#regionSelect").val());
			$("#selectForm").submit();
		});
	
		$('.treditor').editable(
		{
			type : 'text',
			url : 'saveData',
			title : '输入新值',
			validate : function(value)
			{
				if (value > 100 || value < 0)
				{
					return '所填数值必须在0～100之间';
				}
			}
		});
		$('.cityeditor').editable(
		{
			type : 'text',
			url : 'saveData',
			title : '输入新值',
			validate : function(value)
			{
				if (value > 100 || value < 0)
				{
					return '所填数值必须在0～100之间';
				}
			}
		});
	});
</script>

</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span10">
				<form id="selectForm"  action="config">
					<input type="hidden" value="" name="region" /> <input
						type="hidden" value='<s:property value="location"/>'
						id="currentregion" />
					<div class="control-group">
						<div class="controls">
							<select id="regionSelect" class="selectpicker">
								<option value="">请选择</option>
								<option value="S">南方分中心</option>
								<option value="N">北方分中心</option>
								<option value="T">5分钟阈值设置</option>
							</select>
						</div>
					</div>
					<div class="control-group">
						<div id="heading" class="controls">
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span12">
						<table id="contentTable"
							class="table table-bordered table-striped">
							<s:if test='show'>
								<tr>
									<s:iterator value="staticsHeader" id="header">
										<td><s:property value='header' /></td>
									</s:iterator>
								</tr>
								<s:iterator value="provinces" status="province">
										<tr>
											<td><s:property value="provinceName" />
											</td>
											<td><a href="#" class="treditor"
												data-pk="<s:property value="provinceName" />"
												id="connectAlarmRate"><s:property
														value="connectAlarmRate" /> </a>
											</td>
											<td><a href="#" class="treditor"
												data-pk="<s:property value="provinceName" />"
												id="connectErrorRate"><s:property
														value="connectErrorRate" /> </a>
											</td>
											<td><a href="#" class="treditor"
												data-pk="<s:property value="provinceName" />"
												id="connectShortAlarmRate"><s:property
														value="connectShortAlarmRate" /> </a>
											</td>
											<td><a href="#" class="treditor"
												data-pk="<s:property value="provinceName" />"
												id="connectShortErrorRate"><s:property
														value="connectShortErrorRate" /> </a>
											</td>
											<td><a href="#" class="treditor"
												data-pk="<s:property value="provinceName" />" id="queueNo"><s:property
														value="queueNo" /> </a>
											</td>
											<td><a href="#" class="treditor"
												data-pk="<s:property value="provinceName" />"
												id="outboundTime"><s:property value="outboundTime" /> </a>
											</td>
											<td><a href="#" class="treditor"
												data-pk="<s:property value="provinceName" />"
												id="inboundTime"><s:property value="inboundTime" /> </a>
											</td>
											<td><a href="#" class="treditor"
												data-pk="<s:property value="provinceName" />"
												id="desktopTime"><s:property value="desktopTime" /> </a>
											</td>
											<td><a href="#" class="treditor"
												data-pk="<s:property value="provinceName" />"
												id="abandonRate"><s:property value="abandonRate" /> </a>
										</tr>
								</s:iterator>
							</s:if>
							<s:else>
								<tr>
									<s:iterator value="countHeader" id="header">
										<td><s:property value='header' />
										</td>
									</s:iterator>
								</tr>
								<s:iterator value="cities" status="city">
										<tr>
											<td><s:property value="provinceName" />
											</td>
											<td><a href="#" class="cityeditor"
												data-pk="<s:property value="provinceName" />" id="inboundNo">
													<s:property value="inboundNo" /> </a>
											</td>
											<td><a href="#" class="cityeditor"
												data-pk="<s:property value="provinceName" />" id="requestNo">
													<s:property value="requestNo" /> </a>
											</td>
											<td><a href="#" class="cityeditor"
												data-pk="<s:property value="provinceName" />" id="serviceNo">
													<s:property value="serviceNo" /> </a>
											</td>
											<td><a href="#" class="cityeditor"
												data-pk="<s:property value="provinceName" />" id="ivrFixNo">
													<s:property value="ivrFixNo" /> </a>
											</td>
										</tr>
								</s:iterator>
							</s:else>
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