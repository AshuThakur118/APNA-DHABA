<%@ include file="./header.jspf" %>
<%@ page isELIgnored="false"%>
<h3>New user register here</h3>
<hr>
<form action="register" method="post">
	<table border ="2" align ="center">
		<tr>
			<td>Enter Name </td>
			<td><input type="text" name="userName" ></td>
		</tr>
		<tr>
			<td>Enter Email</td>
			<td><input type="text" name="email" ></td>
		</tr>
		<tr>
			<td>Enter Password</td>
			<td><input type="password" name="passWord" ></td>
		</tr>
		<tr>
			<td>Select Gender</td>
			<td><input type="radio" name="gender" value="Male" /> Male | 
			<input type="radio" name="gender" value="Female" /> Female | 
			<input type="radio" name="gender" value="Other" /> Other </td>
		</tr>
		<tr>
			<td><input type="reset" /></td>
			<td><input type="submit" value="Register" /></td>
		</tr>
	</table>
</form>

<%@ include file="./footer.jspf" %>