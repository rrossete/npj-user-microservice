package br.ufjf.microservice;

import br.ufjf.microservice.domain.Usuario;
import br.ufjf.microservice.repository.UsuarioRepository;
import br.ufjf.microservice.resources.UsuarioResources;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class MicroserviceApplication implements CommandLineRunner {

    @Autowired
    UsuarioRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception { //criado para instaciar os objetos na hora do start da aplicação


        Timestamp data= new Timestamp(System.currentTimeMillis());


        Usuario usuario = new Usuario("Jose Maria", "434423264", "12351354", 1, "15652145", "252525", true,data ,data ,1,1,1);

        repository.saveAll(Arrays.asList(usuario));
    }

}
