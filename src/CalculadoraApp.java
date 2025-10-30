import java.util.Locale;
import java.util.Scanner;

public class CalculadoraApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        boolean continuar = true;

        System.out.println("=== CALCULADORA JAVA ===");

        while (continuar) {
            double valorUm = lerNumero(scanner, "Digite o primeiro valor: ");
            String operacao = lerOperacao(scanner);
            double valorDois = lerNumero(scanner, "Digite o segundo valor: ");

            double resultado = realizarCalculo(valorUm, valorDois, operacao);
            System.out.println("Resultado: " + resultado);

            continuar = desejaContinuar(scanner);
        }

        System.out.println("Encerrando a calculadora... Até logo!");
        scanner.close();
    }

    // Método para ler números com verificação
    public static double lerNumero(Scanner scanner, String mensagem) {
        double numero = 0.0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensagem);
            if (scanner.hasNextDouble()) {
                numero = scanner.nextDouble();
                valido = true;
            } else {
                System.out.println("Entrada inválida! Digite apenas números.");
                scanner.next(); // limpa a entrada incorreta
            }
        }
        return numero;
    }

    // Método para ler e validar a operação
    public static String lerOperacao(Scanner scanner) {
        String operacao = "";
        boolean valido = false;

        while (!valido) {
            System.out.print("Digite a operação (+, -, /, *): ");
            operacao = scanner.next();
            if (operacao.matches("[+\\-/*]")) { // expressão regular
                valido = true;
            } else {
                System.out.println("Operação inválida! Tente novamente.");
            }
        }
        return operacao;
    }

    // Método que realiza o cálculo
    public static double realizarCalculo(double valorUm, double valorDois, String operacao) {
        switch (operacao) {
            case "+": return valorUm + valorDois;
            case "-": return valorUm - valorDois;
            case "*": return valorUm * valorDois;
            case "/":
                if (valorDois == 0) {
                    System.out.println("Erro: divisão por zero!");
                    return 0;
                }
                return valorUm / valorDois;
            default:
                System.out.println("Operação desconhecida!");
                return 0;
        }
    }

    // Método para perguntar se o usuário quer continuar
    public static boolean desejaContinuar(Scanner scanner) {
        System.out.print("Deseja realizar outra operação? (S/N): ");
        String resposta = scanner.next().trim().toUpperCase(Locale.ROOT);
        return resposta.equals("S");
    }
}
