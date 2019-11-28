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
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/Home">Tades</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/Deslogar"><span class="glyphicon glyphicon-log-in"></span> Deslogar</a></li>
                </ul>
            </div>
        </nav>
        <form method="post" action="${pageContext.request.contextPath}/UsuariosSalvar" class="form">
            <div class="corpo">
                <input type="hidden" name="id" placeholder="id" value=<c:out value="${id}" />>
                <label>CPF:</label>
                <input type="text" name="cpf" placeholder="CPF do usuario" value=<c:out value="${cpf}" />>
                <label>Senha</label>
                <input type="password" name="senha" placeholder="Senha" value=<c:out value="${senha}" />>
                <label>Confirme a senha:</label>
                <input type="password" name="senha" placeholder="Confirme a senha:">
                <label>Perfil:</label>
                <select id="estado" name="perfil" name="perfil">
                    <option value="Gerente" <c:if test="${estado == 'Gerente'}"><c:out value="selected"/></c:if>>Gerente</option>
                    <option value="TI" <c:if test="${estado == 'TI'}"><c:out value="selected"/></c:if>>TI</option>
                    <option value="Vendedor" <c:if test="${estado == 'Vendedor'}"><c:out value="selected"/></c:if>>Vendedor</option>
                    <option value="Administrativo" <c:if test="${estado == 'Administrativo'}"><c:out value="selected"/></c:if>>Administrativo</option>
                    <option value="Produto" <c:if test="${estado == 'Produto'}"><c:out value="selected"/></c:if>>Produto</option>
                </select>
                <a href="${pageContext.request.contextPath}/Usuarios"><button type="Button" class="btn btn-red">Cancelar</button></a>
                <button type="submit" class="btn btn-black">Salvar</button>
            </div>
        </form>
    </body>

</html>