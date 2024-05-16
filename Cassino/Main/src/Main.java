import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) throws Exception {

        // Inicialização de variáveis
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        double opcao;
        

        // Início Menu
        JOptionPane.showMessageDialog(null,"******************************\n Bem vindo ao cassino! \n******************************" );
        String nome = JOptionPane.showInputDialog(null,"Digite seu nome:");
        
        //criando usuario
        User jogador1 = new User(nome);

        JOptionPane.showMessageDialog(null,"Seu saldo é de R$"+jogador1.saldo+"\nVocê precisa de um valor inicial para começar a jogar.");
        
        jogador1.Depositar();

        JOptionPane.showMessageDialog(null,"Olá " + jogador1.nome + "! \nVocê tem R$" + jogador1.saldo + " disponiveis para jogar!");
        

        // Escolha do jogo
        while (escolha != 6) {
            escolha=Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma das seguintes opções:\n 1: Black Jack\n 2: Bac Bo\n 3: Depositar\n 4: Sacar\n 5: Estatísticas\n 6: Sair"));
            

            switch (escolha) {
                case 1:
                    JOptionPane.showMessageDialog(null,"Abrindo Black jack...");
                    //Abrindo o Black Jack
                    BlackJack.main(args);
                    
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"Abrindo Bac bo...");
                    // abrir bac bo
                    BacBo.main(args);

                    break;
                case 3:
                    //depositar
                    jogador1.Depositar();
                    break;
                case 4:
                    //sacar
                    jogador1.Sacar();
                    break;
                case 5:
                    //mostrar estatisticas
                    opcao = Double.parseDouble(JOptionPane.showInputDialog(null, "Deseja acessar as estatísticas de qual jogo?\n 1: BlackJack  2: BacBo  3: Ambos"));
                    if (opcao == 1){
                        JOptionPane.showMessageDialog(null, "Vezes jogadas: " + jogador1.vezesJogadas21 +
                        "\nVitórias: " + jogador1.vitorias21 +
                        "\nDerrotas: " + jogador1.derrotas21 + 
                        "\nEmpates: " + jogador1.empates21);
                    }else if (opcao == 2) {
                        JOptionPane.showMessageDialog(null, "Vezes jogadas: " + jogador1.vezesJogadasBacBo +
                        "\nVitórias: " + jogador1.vitoriasBacBo +
                        "\nDerrotas: " + jogador1.derrotasBacBo);
                    }else {
                        JOptionPane.showMessageDialog(null, "Vezes jogadas: " + jogador1.vezesJogadas21 +
                        "\nVitórias: " + jogador1.vitorias + 
                        "\nDerrotas: " + jogador1.derrotas + 
                        "\nEmpates: " + jogador1.empates21);
                    }

                    break;
                case 6:
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
