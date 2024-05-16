import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) throws Exception {

        // Inicialização de variáveis
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        

        // Início Menu
        JOptionPane.showMessageDialog(null,"******************************\n Bem vindo ao cassino! \n******************************" );
        String nome = JOptionPane.showInputDialog(null,"Digite seu nome:");
        

        User jogador1 = new User(nome);

        JOptionPane.showMessageDialog(null,"Seu saldo é de R$"+jogador1.saldo+"\nVocê precisa de um valor inicial para começar a jogar.");
        
        jogador1.Depositar();

        JOptionPane.showMessageDialog(null,"Olá " + jogador1.nome + "! \nVocê tem R$" + jogador1.saldo + " disponiveis para jogar!");
        

        // Escolha do jogo
        while (escolha != 5) {
            escolha=Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma das seguintes opções:\n 1: Black Jack\n 2: Bac Bo\n 3: Depositar\n 4: Sacar\n 5: Sair"));
            

            switch (escolha) {
                case 1:
                    JOptionPane.showMessageDialog(null,"Abrindo Black jack...");
                    //Abrindo o Black Jack
                    BlackJack.main(args);
                    
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"Abrindo Bac bo...");
                    
                    // abrir bac bo
                    break;
                case 3:
                    jogador1.Depositar();
                    break;
                case 4:
                    jogador1.Sacar();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Até a proxima \n Fechando sistema...");
                    
                    TimeUnit.SECONDS.sleep(2);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }

        }

        sc.close();
    }

}
