import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws Exception {

        // Inicialização de variáveis
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        String nome;

        // Início Menu
        System.out.println("**********************");
        System.out.println("Bem vindo ao cassino!");
        System.out.println("**********************");
        System.out.println("Qual seu nome?");
        nome = sc.nextLine();

        User jogador1 = new User(nome);

        System.out.println(
                "Seu saldo é de R$" + jogador1.saldo + ". Você precisa de um valor inicial para começar a jogar.");
        jogador1.Depositar();

        System.out.println("*************************************************************");
        System.out.println("Olá " + jogador1.nome + "! Você tem R$" + jogador1.saldo + " disponiveis para jogar!");

        // Escolha do jogo
        while (escolha != 5) {
            System.out.println(
                    "Escolha uma das seguintes opções:\n 1: Black Jack\n 2: Bac Bo\n 3: Depositar\n 4: Sacar\n 5: Sair");
            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Abrindo Black jack...");
                    BlackJack.main(args);
                    
                    break;
                case 2:
                    System.out.println("Abrindo Bac bo...");
                    // abrir bac bo
                    break;
                case 3:
                    jogador1.Depositar();
                    break;
                case 4:
                    jogador1.Sacar();
                    break;
                case 5:
                    System.out.println("Até a próxima!");
                    System.out.println("Fechando sistema...");
                    TimeUnit.SECONDS.sleep(2);
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }

        }

        sc.close();
    }

}
