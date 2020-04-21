package services;

import com.google.gson.Gson;
import entities.User;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.UUID;

@Path("user")
@Stateless
public class UserServices {
    @GET
    @Path("testuser")
    @Produces("application/json")
    public String TestUser(){
        User user = new User(UUID.randomUUID().toString(),"Nombre Apellido", 18);
        return user.toJason();

    }
    @GET
    @Path("testuserlist")
    @Produces("application/json")
    public String getTestUserList(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID().toString(), "Nombre Apellido", 18));
        users.add(new User(UUID.randomUUID().toString(), "Nombre2 Apellido", 20));
        users.add(new User(UUID.randomUUID().toString(), "Nombre Apellido", 18));
        users.add(new User(UUID.randomUUID().toString(), "Nombre Apellido", 18));
        users.add(new User(UUID.randomUUID().toString(), "Nombre Apellido", 18));
        users.add(new User(UUID.randomUUID().toString(), "Nombre Apellido", 18));
        Gson gson = new Gson();
        return gson.toJson(users);
    }

    @GET
    @Path("paramuser")
    @Produces("application/json")
    public String getParamsUser(@QueryParam("nombre") String nombre, @QueryParam("edad")String edad){
        User user = new User(UUID.randomUUID().toString(), nombre, Integer.parseInt(edad));
        Gson gson = new Gson();
        return gson.toJson(user);
    }
    @GET
    @Path("userhtml")
    @Produces("text/html")
    public String getUserHtml(){
        User user = new User(UUID.randomUUID().toString(), "HTMLUser", 18);
        String html = "";
        html += "<html>";
             html += "<body>";
                  html += "<h1> Resultado </h1>";
                  html += "<p> El usuario es el siguiente </p>";
                  html += "<p> Nombre " + user.getNombre() + "</p>";
                  html += "<p> Edad " + user.getEdad() + "</p>";
             html += "</body>";
        html += "</html>";
        return html;
    }
    @GET
    @Path("pathuser/{nombre}/{edad}")
    @Produces("application/json")
    public String getPathUser(@PathParam("nombre") String nombre, @PathParam("edad") String edad){
        User user = new User(UUID.randomUUID().toString(), nombre, Integer.parseInt(edad));
        Gson gson = new Gson();
        return gson.toJson(user);
    }

}
