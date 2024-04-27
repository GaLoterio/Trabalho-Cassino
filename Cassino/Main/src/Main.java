import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        //Inicialização de variáveis
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        String nome;
        double deposito;

        //Início Menu
        System.out.println("**********************");
        System.out.println("Bem vindo ao cassino!");
        System.out.println("**********************");
        System.out.println("Qual seu nome?");
        nome = sc.nextLine();
        User jogador1 = new User(nome);

        System.out.println("Seu saldo é de R$" + jogador1.saldo + ". Quanto você deseja depositar?");
        deposito = sc.nextDouble();
        while (deposito <= 0){
            System.out.println("Você deve inserir um valor maior que 0!");
            deposito = sc.nextInt();
        }
        jogador1.Depositar(deposito);
        
        System.out.println("Olá " + jogador1.nome + "! Você tem R$" + jogador1.saldo + " disponiveis para jogar!");

        //Escolha do jogo
        while (escolha != 3){
            System.out.println("Escolha uma das seguintes opções:\n 1: Black Jack\n 2: Bac Bo\n 3: Depositar\n 4: Sacar\n 5: Sair");
            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                System.out.println("Abrindo Black jack...");
                    //abrir black jack
                    break;
                case 2:
                    System.out.println("Abrindo Bac bo...");
                    // abrir bac bo
                    break;
                case 3:
                    
                    break;
                case 4: 
                    //sacar
                    break;
                case 5:
                    System.out.println("Até a próxima!"); 
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
 
        }


        sc.close();
    }
    
}
