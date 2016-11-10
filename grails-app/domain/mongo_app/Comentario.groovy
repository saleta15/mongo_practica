package mongo_app

class Comentario {
    String contenido
    Usuario usuario

    static embedded = ['usuario']
    static constraints = {
    }
}
