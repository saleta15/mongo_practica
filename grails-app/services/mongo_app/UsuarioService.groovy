package mongo_app

import com.mongodb.client.FindIterable
import grails.transaction.Transactional
import org.bson.Document

@Transactional
class UsuarioService {

    def saveUsuario(Usuario person) {

        Mensaje mensaje = new Mensaje( contenido: "papazon")
        person.save()
        mensaje.usuario = person
        mensaje.save()

    }

    def listarUsuarios(){
        def findIterable = Usuario.findAll()
//        findIterable.limit(10)
//                .each { Usuario product ->
//            println "Product title $product.salary"
//        }
    }

    def autenticar( usuario, password){
        Usuario u = Usuario.find(new Document("usuario",usuario)).first()
        u != null && u.password == password

    }
}
