package br.ufjf.microservice.resources;

import br.ufjf.microservice.domain.Usuario;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import br.ufjf.microservice.service.HttpRquisitions.Requisitions;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "/teste")
public class TesteResources {

    Requisitions requisitions = new Requisitions();
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ResponseEntity<Usuario> test() throws IOException {

        List<Usuario> users = requisitions.httpGetListUsers("http://www.localhost:8000/usuario");

      // Usuario usuario = requisitions.httpGetUser("http://www.localhost:8000/usuario/1");

       return ResponseEntity.ok().build();

        }

    }

