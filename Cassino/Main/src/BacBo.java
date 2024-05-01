import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BacBo {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        User jogador1 = new User("gustavo");
        jogador1.Depositar();

        int dado1A;
        int dado2A;
        int dado1V;
        int dado2V;
        double aposta;
        double ganho;
        int escolha;
        int loop = 1;

        System.out.println("*******************");
        System.out.println("Bem vindo ao Bac Bo!");
        System.out.println("*******************");

        while (loop == 1) {
            System.out.println("Vamos jogar! Deseja apostar no AZUL, VERMELHO ou no EMPATE?");
            System.out.println("1: Azul \n2: Vermelho \n3: Empate");
            escolha = sc.nextInt();

            System.out.println("Agora insira o valor que você deseja apostar:");
            aposta = sc.nextDouble();
            while (aposta > jogador1.saldo || aposta <= 0) {
                System.out.println("Valor de aposta inválido, insira um valor válido:");
                aposta = sc.nextDouble();
            }

            if (escolha == 1) {
                System.out.println("Aposta final: R$" + aposta + " no azul!\n Agora vamos rolar os dados...");
            } else if (escolha == 2) {
                System.out.println("Aposta final: R$" + aposta + " no vermelho!\n Agora vamos rolar os dados...");
            } else {
                System.out.println("Aposta final: R$" + aposta + " no empate!\n Agora vamos rolar os dados...");
            }

            dado1A = rand.nextInt(6) + 1;
            dado2A = rand.nextInt(6) + 1;
            dado1V = rand.nextInt(6) + 1;
            dado2V = rand.nextInt(6) + 1;

            boolean vitoriaAzul = false;
            boolean vitoriaVermelho = false;
            boolean empate = false;

            int totalAzul = dado1A + dado2A;
            int totalVermelho = dado1V + dado2V;

            if (totalAzul > totalVermelho) {
                vitoriaAzul = true;
                System.out.println("Passou por aqui 1");
            } else if (totalAzul < totalVermelho) {
                vitoriaVermelho = true;
                System.out.println("Passou por aqui 2");
            } else {
                empate = true;
                System.out.println("Passou por aqui 3");
            }

            if (vitoriaAzul == true && escolha == 1) {
                System.out.println("Parabens voce ganhou!");
            } else if (vitoriaVermelho == true && escolha == 2) {
                System.out.println("Parabens voce ganhou!");
            } else if (empate == true && escolha == 3) {
                System.out.println("Parabens voce ganhou!");
            } else {
                System.out.println("Infelizmente voce perdeu!");
            }

            System.out.println("Dados azuis: " + totalAzul);
            System.out.println("Dados vermelhos: " + totalVermelho);

            System.out.println("Deseja jogar novamente?");
            System.out.println("1: Sim\n 2: Nao");
            loop = sc.nextInt();
        }

        System.out.println("Fechando Bac Bo...");
        TimeUnit.SECONDS.sleep(2);
    }

}
