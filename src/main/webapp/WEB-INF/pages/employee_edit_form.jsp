<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red; text-align:center;">Employee Edit Page</h1>

<frm:form modelAttribute="emp" >
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Employee No .:</td>
			<td><frm:input path="empno" readonly="true"/></td>
		</tr>
		<tr>
			<td>Employee name .:</td>
			<td><frm:input path="ename"/></td>
		</tr>
		<tr>
			<td>Employee Desg .:</td>
			<td><frm:input path="job"/></td>
		</tr>
		<tr>
			<td>Employee Salary .:</td>
			<td><frm:input path="sal"/></td>
		</tr>
		<tr>
			<td>Employee deptno .:</td>
			<td><frm:input path="deptno"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Update"></td>
			<td><input type="reset" value="cancel"></td>
		</tr>
	</table>
</frm:form>