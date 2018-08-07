package br.ufjf.microservice.service.HttpRquisitions;

import br.ufjf.microservice.domain.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Requisitions {

    private String httpGetRequisition(String url){

        String retorno ="";
        try
        {
            URL apiEnd = new URL(url);
            int codigoResposta;
            HttpURLConnection conexao;
            InputStream is;

            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setReadTimeout(15000);
            conexao.setConnectTimeout(15000);
            conexao.connect();



            codigoResposta = conexao.getResponseCode();

            if (codigoResposta< HttpURLConnection.HTTP_BAD_REQUEST){

                is =conexao.getInputStream();

            }else
            {
                is = conexao.getErrorStream();
            }

            retorno = converterInputStreamToString(is);
            is.close();
            conexao.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }



        return retorno;

    }

    public  Usuario httpGetUser(String url)
    {
        String retorno = httpGetRequisition(url);
        Gson gson = new Gson();
        Usuario user= gson.fromJson(retorno, Usuario.class);

        return user;

    }

    public List<Usuario> httpGetListUsers(String url){

        String s = httpGetRequisition(url);

        Gson gson = new Gson();
        Usuario[] user = gson.fromJson(s,Usuario[].class);

        return Arrays.asList(user);
    }



    public void httpPost() throws IOException {

        Usuario user = httpGetUser("http://localhost:8000/usuario/1");


        user.setNome("Antonia das Graças");
        Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

        String json = gson.toJson(user);



        System.out.println(json);

        String url="http://localhost:8000/usuario";
        StringEntity  entity = new StringEntity(json,ContentType.APPLICATION_JSON);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);

         System.out.println(response.getStatusLine().getStatusCode());



    }


    private static String converterInputStreamToString(InputStream is){
        StringBuffer buffer = new StringBuffer();
        try{
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while((linha = br.readLine())!=null){
                buffer.append(linha);
            }

            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return buffer.toString();
    }
}
