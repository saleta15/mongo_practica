<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/principal/">Mongo</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><g:link controller="principal" action="top">Comentarios Top</g:link></li>
                    <li><g:link controller="principal" action="palabras">Palabras</g:link></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                        <li>  <form action="/cerrarsesion/" method="POST" class="form-signin">
                            <button style="border-radius: 30px; background-color:transparent; border: snow; margin-top: 13px;  " type="submit">Cerrar Sesi&oacute;n</button>
                        </form>
                        </li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>
</div>
</body>
</html>