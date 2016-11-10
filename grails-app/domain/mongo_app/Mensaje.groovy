package mongo_app

class Mensaje {
    String contenido
    List comentarios
    Usuario usuario
    static embedded = ['comentarios','usuario']

    static constraints = {

    }

}
