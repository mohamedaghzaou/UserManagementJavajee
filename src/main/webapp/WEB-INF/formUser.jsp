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


<form action="User?op=${Action}" method="post">
  <div class="form-group">
    <input type="hidden" name="id" class="form-control" value="${user.id }" aria-describedby="emailHelp">
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">First name</label>
    <input type="text" class="form-control"  aria-describedby="emailHelp" name="Firstname" value="${user.firstName }" placeholder="Enter First name">
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Last name</label>
    <input type="text" class="form-control"  aria-describedby="emailHelp" value="${user.lastName }" name="Lastname" placeholder="Enter Last name">
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Address</label>
    <input type="text" class="form-control"  aria-describedby="emailHelp" value="${user.address }" name="Address"  placeholder="Enter Address">
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control"  aria-describedby="emailHelp" value="${user.email }" name="Email" placeholder="Enter Email address">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Phone Number</label>
    <input type="tel" class="form-control" id="exampleInputPassword1" value="${user.phoneNumber }" name="PhoneNumber"  placeholder="Enter Phone Number">
  </div>
      <label for="exampleInputPassword1" >sex</label>
  <select class="form-select" name="sex" aria-label="Default select example">
  <option ${user.sex=='Male'?'selected':'' } value="Male">Male</option>
  <option ${user.sex=='Male'?'':'selected' } value="Female">Female</option>
</select>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>