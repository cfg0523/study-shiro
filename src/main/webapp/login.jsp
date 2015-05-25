<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
    <form action='<c:url value="/login"/>' method="post">
        Username: <input type="text" name="username" value="hayden"/><br/>
        Password: <input type="text" name="password" value="qiannianhu"/><br/>
        <input type="submit" name="submit" value="Submit"/>
    </form>
</body>
</html>