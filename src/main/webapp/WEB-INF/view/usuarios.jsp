<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="add_usuario_url" value="/usuarios"/>

<html>
    <head>
        <title>View Usuarios</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="main-container">
            <div id="snackbar">Successfully added Usuario with name: ${savedUsuario.name}</div>

            <div class="form-custom">
                <form action="${add_usuario_url}" method="post" modelAttribute="usuario">
                    <form:label path="nome">Usuario Nome: </form:label> <input type="text" name="nome"/>
                    <form:label path="author">Author Name: </form:label> <input type="text" name="author"/>
                    <input type="submit" value="submit"/>
                </form>
            </div>

            <table id="customers">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Author</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${usuarios}" var="usuario">
                        <tr>
                            <td>${usuario.id}</td>
                            <td>${usuario.name}</td>
                            <td>${usuario.author}</td>
                            <td><a href="/update_usuarios/${usuario.id}">Editar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>

    <script>
        window.onload = () => {
            if(${addUsuarioSuccess}){
            showMsg()
            }
        }

        function showMsg() {
          // Get the snackbar DIV
          var x = document.getElementById("snackbar");

          // Add the "show" class to DIV
          x.className = "show";

          // After 3 seconds, remove the show class from DIV
          setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
        }
    </script
</html>