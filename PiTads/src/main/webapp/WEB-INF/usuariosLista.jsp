<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <style><%@include file="../css/produtos.css"%></style>

        <title>Tades</title>

    </head>

    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/PiTads/Home">Tades</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/PiTads/Deslogar"><span class="glyphicon glyphicon-log-in"></span> Deslogar</a></li>
                </ul>
            </div>
        </nav>
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