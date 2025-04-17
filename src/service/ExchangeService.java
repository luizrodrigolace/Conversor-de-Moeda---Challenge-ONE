package service;

import com.google.gson.Gson;
import model.ExchangeResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeService {
    //chave de acesso da API e endereço
    private String key = "db25e4d61dcce0d69e03eed3";
    private String apiURL = "https://v6.exchangerate-api.com/v6/" + key + "/latest/";

    public ExchangeResponse getExchangeRates(String baseCurrency) throws IOException, InterruptedException {
        String baseCurrencyApiURl = apiURL+baseCurrency;

        //criando cliente e requisição
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseCurrencyApiURl)).build();

        //resposta da api
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //utilizando Gson para fazer o pase da resposta em Json
        Gson gson = new Gson();
        return gson.fromJson(response.body(), ExchangeResponse.class);
    }
}
