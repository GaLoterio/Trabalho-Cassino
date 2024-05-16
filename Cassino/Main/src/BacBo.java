import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class BacBo {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        User jogador1 = new User("gustavo");
        
        //inicializando variaveis
        int dado1A;
        int dado2A;
        int dado1V;
        int dado2V;
        double aposta;
        int escolha;
        int loop = 1;

        System.out.println("*******************");
        System.out.println("Bem vindo ao Bac Bo!");
        System.out.println("*******************");
        JOptionPane.showMessageDialog(null, "Bac Bo é um jogo de dados onde você pode apostar numa cor, ou no empate.\n Os dados serão rolados, e a soma dos dados da sua cor for maior que a soma dos dados da outra cor, você ganha.");

        while (loop == 1) {
            jogador1.vezesJogadasBacBo ++;

            System.out.println("Vamos jogar! Deseja apostar no AZUL, VERMELHO ou no EMPATE?");
            System.out.println("1: Azul \n2: Vermelho \n3: Empate");
            escolha = sc.nextInt();

            System.out.println("Agora insira o valor que você deseja apostar:");
            aposta = sc.nextDouble();
            while (aposta > jogador1.saldo || aposta <= 0) {
                System.out.println("Valor de aposta inválido, insira um valor válido:");
                aposta = sc.nextDouble();
            }

            jogador1.saldo -= aposta;

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
            } else if (totalAzul < totalVermelho) {
                vitoriaVermelho = true;
            } else {
                empate = true;
            }

            if (vitoriaAzul == true && escolha == 1) {
                System.out.println("Parabens voce ganhou!");
                jogador1.saldo += aposta * 2;
                System.out.println("Você ganhou " + aposta * 2 + " e seu novo saldo é de: R$" + jogador1.saldo + "!");
                jogador1.vitoriasBacBo +=1;
            } else if (vitoriaVermelho == true && escolha == 2) {
                System.out.println("Parabens voce ganhou!");
                jogador1.saldo += aposta * 2;
                System.out.println("Você ganhou " + aposta * 2 + " e seu novo saldo é de: R$" + jogador1.saldo + "!");
                jogador1.vitoriasBacBo +=1;
            } else if (empate == true && escolha == 3) {
                System.out.println("Parabens voce ganhou!");
                jogador1.saldo += aposta * 5;
                System.out.println("Você ganhou " + aposta * 5 + " e seu novo saldo é de: R$" + jogador1.saldo + "!");
                jogador1.vitoriasBacBo +=1;
            } else {
                System.out.println("Infelizmente voce perdeu!");
                System.out.println("Você perdeu R$" + aposta + "! Seu novo saldo é de R$" + jogador1.saldo + "!");
                jogador1.derrotasBacBo +=1;
            }

            System.out.println("Dados azuis: " + totalAzul);
            System.out.println("Dados vermelhos: " + totalVermelho);

            System.out.println("Deseja jogar novamente?");
            System.out.println("1: Sim\n2: Nao");
            loop = sc.nextInt();
        }

        System.out.println("Fechando Bac Bo...");
        //TimeUnit.SECONDS.sleep(2);
    }

}
