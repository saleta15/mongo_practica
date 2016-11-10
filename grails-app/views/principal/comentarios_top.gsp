<!DOCTYPE html>
<html>
<head>
    <title>Información Estudiante </title>
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<g:render template="header" />
    <div class="container" style="width:50%">
        <div class="panel panel-default" >

            <div class="panel-body" >

                <h2>Mensajes Mas comentados</h2>
                <hr>
                    <g:each in="${mensajes}" var="mensaje">
                    <div class="col-lg-12">
                        <h4><g:link controller="principal" action="ver_mensaje"  params="[id: mensaje.id]">${mensaje.usuario.nombre}</g:link></h4>
                        <p>${mensaje.contenido} </p>
                        <b>Cantidad comentarios: <p>${mensaje.comentarios.size()} </p></b>
                        <hr>
                    </div>
                    </g:each>
            </div>

        </div>
    </div>
    <!-- /.row -->


</body>
</html>