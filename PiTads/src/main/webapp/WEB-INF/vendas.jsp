<!DOCTYPE html>


<html>

    <head>

        <style><%@include file="../css/vendas/vendas.css"%></style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Tades</title>
        <link rel="shortcut icon" href="Logo.ico" />
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
        <div class="body">
            <a href="${pageContext.request.contextPath}/VendasListar">
                <div class="card">
                    <div class="card-body">
                        Efetuar venda
                    </div>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/VendasRelatorio">
                <div class="card">
                    <div class="card-body">
                        Relatorio Geral
                    </div>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/VendasRelatorioFilial">
                <div class="card">
                    <div class="card-body">
                        Relatorio por Filial
                    </div>
                </div>
            </a>
        </div>
    </body>

</html>