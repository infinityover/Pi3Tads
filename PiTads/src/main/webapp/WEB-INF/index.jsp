<%-- 
    Document   : index
    Created on : Oct 19, 2019, 1:18:48 PM
    Author     : paulo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
    </script>

    <title>Tades</title>
    <style><%@include file="../css/index.css"%></style>

</head>

<body>
    <section class="sidenav">
        <div class="position-abs row">
            <img class="img" src="${pageContext.request.contextPath}/assets/Logo.svg">
        </div>
    </section>
    <div class="main ">
        <div class="col-md-6 col-sm-12">
            <div class="login-form centered">
                <form method="post" action="${pageContext.request.contextPath}/Home" novalidate>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="CPF">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Senha">
                    </div>
                    <div class="addons">
                        <div class="form-group">
                            <input type="checkbox" class="" placeholder="Senha">
                            <label>Lembrar-me</label>
                        </div>
                        <a href="./esqueci.html" class="forgot-pass">Esqueci minha senha</a>

                    </div>
                    <br>
                    <button type="submit" class="btn btn-black">Login</button>
                </form>
            </div>
        </div>
    </div>
</body>

</html>