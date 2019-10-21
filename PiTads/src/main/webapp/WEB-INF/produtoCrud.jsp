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
            <label>Código do produto:</label>
            <input type="text" name="id" placeholder="Código do produto" value=<c:out value="${id}" /> <c:if test="${not empty id}"><c:out value="readonly='readonly'"/></c:if>>
            <br>
            <label>Nome do produto:</label>
            <input type="text" name="nome" placeholder="Nome do produto" value=<c:out value="${nome}" />>
            <br>
            <label>Valor:</label>
            <input type="text" name="valor" placeholder="Valor" value=<c:out value="${valor}" />>
            <!--<input type="text" placeholder="Filiais disponiveis" value=<c:out value="${dtNascimentoAttr}" />>-->
        </div>
        </div>
        <button type="submit" class="btn btn-black">Salvar</button>
    </form>
</body>

</html>