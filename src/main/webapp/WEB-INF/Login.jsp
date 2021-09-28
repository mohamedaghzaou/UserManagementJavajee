<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
                <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>LogIn</title>
</head>
<body>
<%@include file="Header.jsp" %>

<div class="container mt-4">
<form  action="LogIn" method="post">
<c:if test="${login==false }">
<div class="alert alert-primary" role="alert">
  Username or password incorrect 
</div>
</c:if>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="text" class="form-control" required="required"  name="username" aria-describedby="emailHelp" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" required="required"  name="password" placeholder="Password">
  </div>
  <div class="form-check">
    <input type="checkbox" name="rememberme" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Remember Me</label>
  </div>
  <button type="submit" class="btn btn-primary">LogIN</button>
</form>
</div>
</body>
</html>