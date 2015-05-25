<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>
    User: <shiro:principal/><br/>
    Permissions:<br/>
    <shiro:hasPermission name="user:add">
        user:add<br/>
    </shiro:hasPermission>
    <shiro:hasPermission name="user:delete">
        user:delete<br/>
    </shiro:hasPermission>
</body>
</html>