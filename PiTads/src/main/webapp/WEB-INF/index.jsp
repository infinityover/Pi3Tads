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
            <svg class="svg" xmlns="http://www.w3.org/2000/svg" width="393.179" height="393.179" viewBox="0 0 393.179 393.179">
                <g id="Logo" transform="translate(-875.199 -237.199)">
                  <rect id="Rectangle_4" data-name="Rectangle 4" width="278" height="278" transform="translate(933 295)" fill="#a3c9d3"/>
                  <rect id="Rectangle_5" data-name="Rectangle 5" width="278.189" height="278.189" transform="translate(1064.923 237.199) rotate(43)" fill="#2e3853"/>
                  <line id="Line_1" data-name="Line 1" y1="194.732" x2="194.732" transform="translate(926.898 291.217)" fill="none" stroke="#707070" stroke-width="1"/>
                  <line id="Line_2" data-name="Line 2" y1="194.732" x2="197.051" transform="translate(970.945 335.263)" fill="none" stroke="#707070" stroke-width="1"/>
                  <line id="Line_3" data-name="Line 3" y1="194.732" x2="197.051" transform="translate(1010.355 372.355)" fill="none" stroke="#707070" stroke-width="1"/>
                  <text id="Tades" transform="translate(998 456)" fill="rgba(219,220,214,0.87)" font-size="56" font-family="Roboto-Regular, Roboto"><tspan x="0" y="0">Tades</tspan></text>
                </g>
              </svg>

        </div>
    </section>
    <div class="main ">
        <div class="col-md-6 col-sm-12">
            <div class="login-form centered">
                <form method="post" action="${pageContext.request.contextPath}/Login" novalidate>
                    <div class="form-group">
                    <c:if test="${loginError}">
                        <div class="erro-input com-erro">
                            Login e/ou senha incorreto(s).
                        </div>
                    </c:if>
                        <input type="text" name="Cpf" id="Cpf" class="form-control" placeholder="CPF" required <c:if test="${cpf}"> value='${cpf}' </c:if>>
                            <c:if test="${cpfError}">
                                    <div class="erro-input com-erro">
                                        Digite o CPF de login.
                                    </div>
                            </c:if>
                    </div>
                    <div class="form-group">
                        <input type="password" name="Senha" id="Senha" class="form-control" placeholder="Senha" required>
                    </div>
                    <c:if test="${senhaError}">
                        <div class="erro-input com-erro">
                            Digite a senha de login.
                        </div>
                    </c:if>
                    <div class="addons">
                        <div class="form-group">
                            <input type="checkbox" class="" placeholder="Senha" <c:if test="${senhaError}"> value='${senha}' </c:if>>
                            <label>Lembrar-me</label>
                        </div>
                        <!--<a href="./esqueci.html" class="forgot-pass">Esqueci minha senha</a>-->

                    </div>
                    <br>
                    <button type="submit" class="btn btn-black">Login</button>
                </form>
            </div>
        </div>
    </div>
    <a href="Creditos" style="left: 10px;bottom: 10px;position: fixed;">Créditos</a>
</body>

</html>