<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
        </script>
        <style><%@include file="../css/produtos.css"%></style>

        <title>Tades</title>

    </head>

    <body>
    <c:choose>
        <c:when test="${not empty Usuarios}">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">CPF</th>
                        <th scope="col">Perfil</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${Usuarios}" var="usuario">
                    <tr>
                    <th scope="row"><c:out value="${usuario.id}"/></th>
                    <td><c:out value="${usuario.cpf}"/></td>
                    <td><c:out value="${usuario.perfil}"/></td>
                <td>
                    <td><a href="/PiTads/UsuariosCrud?id=<c:out value='${usuario.id}'/>" ><button type="button" class="btn btn-black">Editar</button></a></td>
                    <td><a href="/PiTads/UsuariosExcluir?id=<c:out value='${usuario.id}'/>" ><button type="button" class="btn btn-red">Excluir</button></a></td>
                </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>Nenhum usuario cadastradado, como chegou aqui?</p>
        </c:otherwise>
    </c:choose>

    <a href="/PiTads/Home"><button type="button" class="btn btn-black">Voltar</button></a>
    <a href="/PiTads/UsuariosCrud"><button type="button" class="btn btn-black">Novo</button></a>
</body>

</html>