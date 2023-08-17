<!DOCTYPE HTML>
<html xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<head>
  <title>Main page</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div>
  <div sec:authorize="!isAuthenticated()">
  <h4><a href="/registration">Sign up</a></h4>
  <h4><a href="/login">Log in</a></h4>
  </div>
  <div sec:authorize="isAuthenticated()">
    <h3 Welcome, th:text="${#authentication.getPrincipal().getUsername()}"></h3> 
    <h4> <a href="/logout">Log out</a>

    </h4>
  </div>

</div>
</body>
</html>