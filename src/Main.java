import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.ExchangeResponse;
import service.ExchangeService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        String option;

        //menu de opções em um do-while
        do {
            System.out.println("\n===========================");
            System.out.println("  Seja bem-vindo/a ao Conversor de Moeda");
            System.out.println("===========================");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileiro");
            System.out.println("4) Real brasileiro => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Sair");
            System.out.println("===========================");
            System.out.print("Escolha uma opção: ");

            option = read.nextLine();

            String baseCurrency = "";
            String targetCurrency = "";

            switch (option) {
                case "1": // dolar => Peso argentino
                    baseCurrency = "USD";
                    targetCurrency = "ARS";
                    break;
                case "2": //Peso argentigo => dolar
                    baseCurrency = "ARS";
                    targetCurrency = "USD";
                    break;
                case "3": //Dolar => real brasileiro
                    baseCurrency = "USD";
                    targetCurrency = "BRL";
                    break;
                case "4": //Real brasileiro => dolar
                    baseCurrency = "BRL";
                    targetCurrency = "USD";
                    break;
                case "5": //Dolar => peso colombiano
                    baseCurrency = "USD";
                    targetCurrency = "COP";
                    break;
                case "6": //peso colombiano => dolar
                    baseCurrency = "COP";
                    targetCurrency  = "USD";
                    break;
                case "7":
                    continue;
                default:
                    System.out.println("Opção invalida");
                    continue;
            }

            System.out.println("Digite o valor que deseja converter:");
            Double amount = read.nextDouble() ;

            ExchangeService exchangeService = new ExchangeService();
            ExchangeResponse response = exchangeService.getExchangeRates(baseCurrency);
            Map<String,Double> conversionRates = response.getConversionRates();
            Double conversionToExchange = conversionRates.get(targetCurrency);

            Double result = amount*conversionToExchange;
            read.nextLine();

            System.out.println(amount+" em "+baseCurrency+" => "+ result + " " + targetCurrency);

        } while (!option.equals("7"));
        read.close();
    }
}