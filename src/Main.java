import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        String option;

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

            String currency = "";
            String conversionRate = "";

            switch (option) {
                case "1": // dolar => Peso argentino
                    currency = "USD";
                    conversionRate = "ARS";
                    break;
                case "2": //Peso argentigo => dolar
                    currency = "ARS";
                    conversionRate = "USD";
                    break;
                case "3": //Dolar => real brasileiro
                    currency = "USD";
                    conversionRate = "BRL";
                    break;
                case "4": //Real brasileiro => dolar
                    currency = "BRL";
                    conversionRate = "USD";
                    break;
                case "5": //Dolar => peso colombiano
                    currency = "USD";
                    conversionRate = "COP";
                    break;
                case "6": //peso colombiano => dolar
                    currency = "COP";
                    conversionRate  = "USD";
                    break;
                case "7":
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }

            //System.out.println("Digite o valor que deseja converter:");
            //Double value = read.nextDouble() ;

            String key = "db25e4d61dcce0d69e03eed3";
            String address = "https://v6.exchangerate-api.com/v6/" + key + "/latest/" + currency;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } while (!option.equals("7"));
    }
}