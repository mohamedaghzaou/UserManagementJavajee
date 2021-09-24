<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
<a href="User?op=add">Add</a>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Address</th>
      <th scope="col">Phone number</th>
        <th scope="col">Email</th>
      <th scope="col">Sex</th>
            <th scope="col"></th>
            <th scope="col"></th>
      
    </tr>
  </thead>
  <tbody>
  
  <c:forEach var = "user" items="${ listuser}">
  <tr>
      		<th scope="row"><c:out value="${user.id}"/></th>
      		<td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.address}"/></td>
            <td><c:out value="${user.phoneNumber}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.sex}"/></td>
            <td><a href="User?op=update&id=${user.id}" class="link-success">Update</a></td>
            <td><a href="User?op=delete&id=${user.id}" class="link-danger">Delete</a></td>
            
    </tr>
  </c:forEach>
  </tbody>
</table></body>
</html>