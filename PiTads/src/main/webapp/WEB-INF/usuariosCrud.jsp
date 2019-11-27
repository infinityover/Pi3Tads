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

    <form method="post" action="${pageContext.request.contextPath}/produtoSalvar">
        <div class="form-group">
            
            <input type="hidden" name="id" placeholder="id" value=<c:out value="${id}" />>
            <br>
            
            <label>CPF:</label>
            <input type="text" name="cpf" placeholder="CPF do usuario" value=<c:out value="${cpf}" />>
            <br>
            <label>Senha</label>
            <input type="password" name="senha" placeholder="Senha" value=<c:out value="${senha}" />>
            <br>
            <label>Confirme a senha:</label>
            <input type="text" name="senha" placeholder="Confirme a senha:">
        </div>
        </div>
        <button type="submit" class="btn btn-black">Salvar</button>
    </form>
</body>

</html>