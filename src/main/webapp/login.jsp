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
  <h1>Login</h1>
  <form action="/" method="post">
   <table style="with: 100%">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>

   </table>
   <form name = "form1" method = "post" action = "/">
                   <button name="btnLog" type="submit">Login</button>
   </form>
  </form>
  <form name = "form1" method = "get" action = "/registration">
                  <input type = "submit" value = "Register">
                  </form>
 </div>
</body>
</html>