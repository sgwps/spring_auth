<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Log in</title>
</head>

<body>
<div>
  <form method="POST" action="/login">
    <h2>Log in</h2>
    <div>
      <input name="username" type="text" placeholder="Username"
             autofocus="true"/>
      <input name="password" type="password" placeholder="Password"/>
      <button type="submit">Log In</button>
      <h4><a href="/registration">Sign up</a></h4>
    </div>
  </form>
</div>

</body>
</html>
