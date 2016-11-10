<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap -->
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
    <title>Papazon</title>
</head>
<body>
<div class="container" style="width: 20%; margin-top: 10%">
    <div class="panel panel-info">
        <div class="panel-heading" >Iniciar Sesi&oacute;n</div>
        <div class="panel-body">

            <g:form controller="principal" action="autenticar">
                <label>Usuario: </label>
                <g:textField name="usuario" class="form-control"/><br/>
                <label>Password </label>
                <g:passwordField name="password" class="form-control"/><br/>
                <g:actionSubmit value="Autenticar" class="btn btn-info"/>
            </g:form>

            <g:link action="registrar">Registrarse</g:link>
        </div>


    </div>

</div>



</body>
</html>