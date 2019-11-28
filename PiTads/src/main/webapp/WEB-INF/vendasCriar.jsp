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

    <form method="post" action="${pageContext.request.contextPath}/VendasCriarSalvar" class="form">
        <div class="corpo">

            <input type="hidden" name="idVenda">
            <label>Para qual filial a venda será realizada?</label>
            <select id="filial" name="filial" name="filial">
                <c:forEach items="${Filiais}" var="filial">
                    <option value=<c:out value="${filial.id}"/>><c:out value="${filial.apelido}"/></option>
                </c:forEach>
            </select>
            <a href="/PiTads/VendasListar"><button type="Button" class="btn btn-red">Cancelar</button></a>
            <button type="submit" class="btn btn-black">Salvar</button>
        </div>
    </form>
</body>

</html>