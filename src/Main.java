import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        SearchCep consultaCep = new SearchCep();

        System.out.println("Digite um número de CEP para consulta (Somente números): ");
        var cep = leitura.nextLine();

        try {
            Adress novoEndereço = consultaCep.searchAdress(cep);
            System.out.println(novoEndereço);
            JsonGenerator generator = new JsonGenerator();
            generator.saveJson(novoEndereço);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }
}