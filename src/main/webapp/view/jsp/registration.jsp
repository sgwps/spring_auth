<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>Sign up</title>
</head>

<body>
  <div>
    <form method="post" th:object="${form}">
      <input placeholder="Username" type="text" th:field="*{username}">
      <br>
      <input placeholder="Password" type="password" th:field="*{password}">
      <br>
      <input placeholder="Confirm password" type="password" th:field="*{passwordConfirmation}">
      <br>
      <input type="submit">
    </form>

  </div>
</body>

</html>