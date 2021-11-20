<%@ include file="./header.jspf"%>

<h3>Member's Enter details </h3>
<hr>
<form action="login" method="post">
	<table border ="3" align ="center">
		<tr>
			<td>Enter UserName</td>
			<td><input type="text" name="userName"></td>
		</tr>
		<tr>
			<td>Enter Password</td>
			<td><input type="password" name="passWord"></td>
		</tr>
		<tr>
		   <style>button {text-align:center;}</style>
			<td colspan="2"><button>Login</button></td>
			</table>
		</tr>
	</table>
</form>