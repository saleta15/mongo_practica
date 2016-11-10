package mongo_app

import com.mongodb.DB
import com.mongodb.DBCollection
import com.mongodb.DBCursor
import com.mongodb.DBObject
import com.mongodb.MapReduceCommand
import com.mongodb.MapReduceOutput
import com.mongodb.Mongo
import com.mongodb.MongoClient
import com.mongodb.client.FindIterable
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document

import java.util.regex.Pattern

import static com.mongodb.client.model.Filters.*

class PrincipalController {
    def usuarioService
    def login() {


    }

    def index(){
        List mensajes = Mensaje.all
        render(view: "index",model: [mensajes: mensajes])

    }

    def registrar() {

    }

    def guardar(){
        def usuario = new Usuario(params)
        usuario.save()
        redirect(action: "login")
    }

    def autenticar(){
        def lol = params
        String usuario = lol.get("usuario")

        String password = lol.get("password")
        if(usuarioService.autenticar(usuario,password)){
            session.setAttribute("usuario", Usuario.find(new Document("usuario",usuario)).first())
            redirect(action: "index")
        }
        else
            redirect(action: "login")
    }

    def postear(){
        String contenido = params.get("contenido")
        def usuario = (Usuario) session.getAttribute("usuario")
        def mensaje = new Mensaje()
        mensaje.contenido = contenido
        mensaje.usuario = usuario
        mensaje.save()
        redirect(action:"index")


    }

    def ver_mensaje(int id){
        Mensaje mensaje =  Mensaje.find(new Document("_id",id)).first()
        render(view: "ver_mensaje", model:[mensaje: mensaje])
    }

    def comentar(){
        Comentario comentario =  new Comentario(contenido: params.get("contenido"))
        int id = Integer.parseInt(params.get("mensaje").toString())
        Mensaje mensaje =  Mensaje.find(new Document("_id",id)).first()
        if(!mensaje.comentarios){
            mensaje.comentarios = new ArrayList()
        }
        comentario.usuario = (Usuario)session.getAttribute("usuario")
        comentario.save()
        mensaje.comentarios.add(comentario)
        mensaje.save()

        redirect(action:"ver_mensaje", params: [id:mensaje.id])
    }

    def top(){
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase db = mongoClient.getDatabase("test") ;
        MongoCollection<Document> collection = db.getCollection("mensaje");
        List<Document> parametros2 = new ArrayList<>();
        parametros2.add(new Document("\$unwind", "\$comentarios"));
        parametros2.add(new Document("\$group", new Document("_id", "\$_id").append("tamano", new Document("\$sum",1))));
        parametros2.add(new Document("\$sort",new Document("tamano",-1)));
        parametros2.add(new Document("\$limit",5))
        def mensajes = []
        def papazon = collection.aggregate(parametros2).each {
            lol -> def id = lol.get("_id")
                def mensaje = Mensaje.find(new Document("_id",id)).first()
                mensajes.add(mensaje)
        }
        render(view: "comentarios_top", model: [mensajes: mensajes] )
    }

    def palabras(){
        MongoClient mongoClient = new MongoClient("localhost",27017);
        DB db = mongoClient.getDB("test") ;
        DBCollection coleccion = db.getCollection("comentario");

        String map = "function() {  \n" +
                "    var comentario = this.contenido;\n" +
                "        comentario = comentario.split(\" \"); \n" +
                "        for (var i = 0; i < comentario.length; i++) {\n" +
                "            if (comentario[i])  {      "+
                "               emit(comentario[i], 1); \n" +
                "            }\n" +
                "        }\n" +
                "};";

        String reduce = "function(key, values) { " +
                "    return Array.sum(values); " +
                "}";

        MapReduceCommand mapcmd = new MapReduceCommand(coleccion, map, reduce,
                "comentarios_top", MapReduceCommand.OutputType.REPLACE, null);

        coleccion.mapReduce(mapcmd);
        DBCollection coleccion2 = db.getCollection("comentarios_top");
        def papazon = coleccion2.find().sort(new Document("value",-1)).toArray()


        render(view: "palabras", model: [mensajes: papazon] )
    }

    def mensajes_palabra(String id){

        def mensaje =  Comentario.find(eq("contenido",Pattern.compile(Pattern.quote(id))))
        render(view: "mensajes_palabra", model:[mensajes: mensaje])
    }






}
