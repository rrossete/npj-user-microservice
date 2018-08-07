package br.ufjf.microservice.resources;

import br.ufjf.microservice.domain.Usuario;
import br.ufjf.microservice.service.UsuarioService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResources {

    @Autowired
    UsuarioService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> find(@PathVariable Integer id){

        Usuario usuario = service.find(id);
        Gson gson = new Gson();
        String json = gson.toJson(usuario);

        try{
            FileWriter writer = new FileWriter("../file.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return ResponseEntity.ok().body(usuario);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert (@RequestBody String params){

        Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();


        System.out.println("AQUUIIIII:   "+ params);

        Usuario usuario = gson.fromJson(params, Usuario.class);

        System.out.println(usuario);
        service.insert(usuario);

       URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Usuario categoria, @PathVariable Integer id){

        categoria.setId(id);
        categoria = service.update(categoria);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll(){

        List<Usuario> usuarios = service.findAll();

        return ResponseEntity.ok().body(usuarios);
    }









}
