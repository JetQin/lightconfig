<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="author" content="Vitaliy Potapov">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />



<script src="assets/js/jquery.js"></script>

<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<link href="assets/css/bootstrap-editable.css" rel="stylesheet">

<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/bootstrap-editable.js"></script>

<script type="text/javascript">
	$(document).ready(function()
	{
		$('#username').editable({
		    type: 'text',
		    pk: 1,
		    url: 'config/saveData',
		    title: 'Enter username'
		});
	});
</script>
</head>

 <body> 

        <div style="width: 80%; margin: auto;"> 
            <h1>X-editable Demo</h1>
         

            
            <table id="user" class="table table-bordered table-striped" style="clear: both">
                <tbody> 
                    <tr>         
                        <td width="15%">Username</td>
<!--                        <td width="50%"><a href="#" id="username">superuser</a></td>-->
                        <td width="50%"><a href="#" id="username" data-type="text" data-pk="1" data-url="/post" data-title="Enter username">superuser</a></td>
                        <td width="35%"><span class="muted">Simple text field</span></td>
                    </tr>
                </tbody>
            </table>
            
         
            <footer class="footer" style="clear: both; padding-top: 10px">
                <hr>
                <p><a href="http://vitalets.github.com/x-editable">X-editable</a> &copy; Vitaliy Potapov 2012. Released under the MIT license.</p> 
            </footer>

        </div>
    </body>
</html>