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
        JOptionPane.showMessageDialog(null,
                "**************************************************\n BEM VINDO AO CASSINO JOGO DA GALERA\n**************************************************",
                "BEM VINDO", -1);
        String nome = JOptionPane.showInputDialog(null, "Digite seu nome:", "Jogo da Galera", -1);

        // criando usuario
        User jogador1 = new User(nome);

        JOptionPane.showMessageDialog(null,
                "Seu saldo é de R$" + jogador1.saldo + "\nVocê precisa de um valor inicial para começar a jogar.",
                "Jogo da Galera", -1);

        jogador1.Depositar();

        // JOptionPane.showMessageDialog(null,"Olá " + jogador1.nome + "! \nVocê tem R$"
        // + jogador1.saldo + " disponiveis para jogar!", "Jogo da Galera", -1);

        // Escolha do jogo
        while (escolha != 7) {
            escolha = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Escolha uma das seguintes opções:\n 1: Black Jack\n 2: Bac Bo\n 3: Depositar\n 4: Sacar\n 5: Estatísticas\n 6: Ver Saldo \n 7: Sair",
                    "Jogo da Galera", -1));

            switch (escolha) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Abrindo Black jack...", "Jogo da Galera", -1);
                    // Abrindo o Black Jack
                    BlackJack.main(args, jogador1);

                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Abrindo Bac bo...", "Jogo da Galera", -1);
                    // abrir bac bo
                    BacBo.main(args, jogador1);

                    break;
                case 3:
                    // depositar
                    jogador1.Depositar();
                    break;
                case 4:
                    // sacar
                    jogador1.Sacar();
                    break;
                case 5:
                    // mostrar estatisticas
                    while(true) {
                        opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Deseja acessar as estatísticas de qual jogo?\n 1: BlackJack  2: BacBo  3: Ambos",
                                "Jogo da Galera", -1));
                        if (opcao == 1) {
                            JOptionPane.showMessageDialog(null, "Vezes jogadas: " + jogador1.vezesJogadas21 +
                                    "\nVitórias: " + jogador1.vitorias21 +
                                    "\nDerrotas: " + jogador1.derrotas21 +
                                    "\nEmpates: " + jogador1.empates21, "Jogo da Galera", -1);
                        } else if (opcao == 2) {
                            JOptionPane.showMessageDialog(null, "Vezes jogadas: " + jogador1.vezesJogadasBacBo +
                                    "\nVitórias: " + jogador1.vitoriasBacBo +
                                    "\nDerrotas: " + jogador1.derrotasBacBo, "Jogo da Galera", -1);
                        } else if (opcao == 3) {
                            JOptionPane.showMessageDialog(null, "Vezes jogadas: " + jogador1.getTotalVezesJogadas() +
                                    "\nVitórias: " + jogador1.getTotalVitorias() +
                                    "\nDerrotas: " + jogador1.getTotalDerrotas() +
                                    "\nEmpates: " + jogador1.empates21, "Jogo da Galera", -1);
                        } else {
                            JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.", "Jogo da Galera", -1);
                            continue;
                        }
                        break;
                    }
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Seu saldo é R$" + jogador1.saldo, "Saldo", -1);
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Até a proxima \n Fechando sistema...", "Jogo da Galera", -1);
                    TimeUnit.SECONDS.sleep(2);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida", "Jogo da Galera", -1);
                    break;
            }

        }

        sc.close();
    }

}
