<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Registration</h1>
  <form action="/registration" method="post">
   <table style="with: 100%">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
         <td>Email</td>
         <td><input type="email" name="email" /></td>
        </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>

    <button name="btnReg" input type="submit" value="Register"> Register </button>
   </table>
  </form>
 </div>
</body>
</html>