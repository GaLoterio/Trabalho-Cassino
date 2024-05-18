import java.util.Random;
import javax.swing.JOptionPane;

public class BacBo {

    public static void main(String[] args, User jogador1) {
        Random rand = new Random();

        // inicializando variaveis
        int dado1A;
        int dado2A;
        int dado1V;
        int dado2V;
        double aposta;
        int escolha;
        int loop = 1;

        JOptionPane.showMessageDialog(null,
                "**************************************************\n                BEM VINDO AO BACBO\n**************************************************",
                "BEM VINDO", -1);
        JOptionPane.showMessageDialog(null,
                "Bac Bo é um jogo de dados onde você pode apostar numa cor, ou no empate.\n Os dados serão rolados, e se a soma dos dados da sua cor for maior que\n a soma dos dados da outra cor, você ganha.");

        while (loop == 1) {
            jogador1.vezesJogadasBacBo++;

            escolha = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Vamos jogar! Deseja apostar no:\n 1: Azul 2: Vermelho 3: Empate",
                    "Jogo da Galera", -1));

            aposta = Double.parseDouble(
                    JOptionPane.showInputDialog(null, "Quanto você deseja apostar?", "Jogo da Galera", -1));
            while (aposta > jogador1.saldo || aposta <= 0) {
                aposta = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Valor de aposta inválido, insira um valor válido:", "Jogo da Galera", -1));
            }

            jogador1.saldo -= aposta;

            if (escolha == 1) {
                JOptionPane.showMessageDialog(null,
                        "Aposta final: R$" + aposta + " no azul!\n Agora vamos rolar os dados...");
            } else if (escolha == 2) {
                JOptionPane.showMessageDialog(null,
                        "Aposta final: R$" + aposta + " no vermelho!\n Agora vamos rolar os dados...");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Aposta final: R$" + aposta + " no empate!\n Agora vamos rolar os dados...");
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

            JOptionPane.showMessageDialog(null, "Dados azuis: " + totalAzul + " X Dados vermelhos: " + totalVermelho);

            if (vitoriaAzul == true && escolha == 1) {
                jogador1.saldo += aposta * 2;
                JOptionPane.showMessageDialog(null, "Parabéns você ganhou! Recebeu R$" + aposta * 2
                        + " e seu novo saldo é de: R$" + jogador1.saldo + "!");
                jogador1.vitoriasBacBo += 1;
            } else if (vitoriaVermelho == true && escolha == 2) {
                jogador1.saldo += aposta * 2;
                JOptionPane.showMessageDialog(null, "Parabéns você ganhou! Recebeu R$" + aposta * 2
                        + " e seu novo saldo é de: R$" + jogador1.saldo + "!");
                jogador1.vitoriasBacBo += 1;
            } else if (empate == true && escolha == 3) {
                jogador1.saldo += aposta * 5;
                JOptionPane.showMessageDialog(null, "Parabéns você ganhou! Recebeu R$" + aposta * 2
                        + " e seu novo saldo é de: R$" + jogador1.saldo + "!");
                jogador1.vitoriasBacBo += 1;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Você perdeu! Menos R$" + aposta + " e seu novo saldo é de: R$" + jogador1.saldo + "!");
                jogador1.derrotasBacBo += 1;
            }

            loop = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Jogo da Galera?",
                    JOptionPane.YES_NO_OPTION);
            if (loop == JOptionPane.NO_OPTION) {
                loop = 2;
            } else {
                loop = 1;
            }
        }

    }

}
