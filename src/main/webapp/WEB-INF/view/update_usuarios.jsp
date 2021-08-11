<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="add_usuario_url" value="/update_usuarios"/>

<html>
    <head>
        <title>View Usuarios</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="main-container">
            <div class="form-custom">
                <form action="${add_usuario_url}" method="post" modelAttribute="usuario">
                    <input type="hidden" value="${usuario.id}" name="id"/>
                    <form:label path="nome">Usuario Nome: </form:label> <input type="text" value="${usuario.nome}" name="nome"/>
                    <form:label path="author">Author Name: </form:label> <input type="text" value="${usuario.author}" name="author"/>
                    <input type="submit" value="submit"/>
                </form>
            </div>
        </div>
    </body>
</html>