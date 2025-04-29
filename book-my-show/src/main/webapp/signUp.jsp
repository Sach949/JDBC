<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup-for-bookmyshow</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<body>

<nav class="navbar navbar-light " style = "background-color: #FFA500;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="https://upload.wikimedia.org/wikipedia/en/thumb/d/d0/Café_Coffee_Day_logo.svg/1200px-Café_Coffee_Day_logo.svg.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
      book-my-show
    </a>
  </div>
</nav>


<div align="center">
<form action = "signUp" method = "post" >
  <div class="mb-3" style="width:300px">
    <label class="form-label">User Name</label>
    <input type="text" name ="name" class="form-control" aria-describedby="name">
  </div>
  <div class="mb-3" style="width:300px">
    <label class="form-label">Date Of Birth</label>
    <input type="date" class="form-control" name="dob">
  </div>
  <div class="mb-3" style="width:300px">
    <label class="form-label">Mobile No.</label>
    <input type="tel" class="form-control" name="mobile">
  </div>
  <div class="mb-3" style="width:300px">
      <label class="form-label">Email</label>
      <input type="email" class="form-control" name="email">
  </div>
  <div class="mb-3" style="width:300px">
        <label class="form-label">Country</label>
        <input type="text" class="form-control" name="country">
    </div>


  <input type="submit" class="btn btn-primary" value="Sing Up">
  <a type="button" class="btn btn-danger"  href="index.jsp ">Cancel</a>
</form>
</div>
<br>
<div align = "center">
<h5>Copyright@2025</h5>
Created By Sachin
</div>
</body>
</html>