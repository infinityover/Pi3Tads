<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
    </script>
        <style><%@include file="../css/produtos.css"%></style>
    <title>Tades</title>
</head>

<body>
        <form method="post" action="${pageContext.request.contextPath}/produtoSalvar" class="form">
        <div class="corpo">
                <input type="hidden" name="id" placeholder="id" value=<c:out value="${id}" />>
                <label>CPF:</label>
                <input type="text" name="cpf" placeholder="CPF do usuario" value=<c:out value="${cpf}" />>
                <label>Senha</label>
                <input type="password" name="senha" placeholder="Senha" value=<c:out value="${senha}" />>
                <label>Confirme a senha:</label>
                <input type="text" name="senha" placeholder="Confirme a senha:">
                <label>Perfil:</label>
                <select id="estado" name="perfil" name="perfil">
                    <option value="Gerente" <c:if test="${estado == 'Gerente'}"><c:out value="selected"/></c:if>>Gerente</option>
                    <option value="TI" <c:if test="${estado == 'TI'}"><c:out value="selected"/></c:if>>TI</option>
                    <option value="Vendedor" <c:if test="${estado == 'Vendedor'}"><c:out value="selected"/></c:if>>Vendedor</option>
                    <option value="Administrativo" <c:if test="${estado == 'Administrativo'}"><c:out value="selected"/></c:if>>Administrativo</option>
                    <option value="Produto" <c:if test="${estado == 'Produto'}"><c:out value="selected"/></c:if>>Produto</option>
                </select>
            <a href="/PiTads/Filiais"><button type="Button" class="btn btn-red">Cancelar</button></a>
            <button type="submit" class="btn btn-black">Salvar</button>
    </div>
        </form>
</body>

</html>