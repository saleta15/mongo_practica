<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns="http://www.w3.org/1999/html">
<head>
    <!-- Bootstrap -->
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
    <title>Login Customizado.....</title>
</head>
<body>

    <div class="container" id="contenedorCrearUsuario">

        <h1>Registrar</h1>

            <div class = "panel panel-default">
                <div class = "panel-body">
                        <g:form controller="principal" action="guardar">
                            <label>Nombre: </label>
                            <g:textField name="nombre" class="form-control"/><br/>
                            <label>Usuario: </label>
                            <g:textField name="usuario" class="form-control"/><br/>
                            <label>Password </label>
                            <g:textField name="password" class="form-control"/><br/>
                            <g:actionSubmit value="Guardar" class="btn btn-info"/>
                        </g:form>
                    <br>
                </div>
            </div>

    </div>
    <script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>