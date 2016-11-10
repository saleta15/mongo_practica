
<!DOCTYPE html>
<html lang="en">

<head>
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">

</head>
<g:render template="header" />
<body>



    <div class="container" style="width: 40%">
        <div class="panel panel-default" >

            <div class="panel-body" >
                <div class="row">

                    <div class="col-lg-12">

                        <p class="lead">
                            por <i>${mensaje.usuario.nombre}</i>
                        </p>
                        <p id="cuerpo">${mensaje.contenido}</p>
                        <hr>
                        <br>
                        <br>
                        <div class="well">
                            <h4>Deja un comentario</h4>
                            <g:form controller="principal" action="comentar" >
                                <div class="form-group">
                                    <g:hiddenField name="mensaje" value="${mensaje.id}"/>
                                    <g:textArea class="form-control" rows="3" name="contenido"/>
                                </div>
                               <g:actionSubmit value="Comentar" class="btn btn-success" />
                            </g:form>
                        </div>
                        <h4>Comentarios</h4>
                        <hr>
                        <g:each in="${mensaje.comentarios}" var="comentario">
                            <div class="media">
                                <div class="media-body">

                                    <h4 class="media-heading">${comentario.usuario.nombre}</h4>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-9">
                                    ${comentario.contenido}
                                </div>


                            </div>

                            <hr>
                        </g:each>
                    </div>
                </div >
            </div>
        </div>
        </div>
        <!-- /.row -->
</body>

</html>
