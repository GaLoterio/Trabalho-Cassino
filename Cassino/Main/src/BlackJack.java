import javax.swing.JOptionPane;
import java.util.Random;

public class BlackJack {
    public static void main(String[] args, User jogador1) {
        Random random = new Random();
        String[] nipes = { "♠", "♥", "♦", "♣" };
        String[] faces = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Ás" };
        String total = "";

        int contador = 2;
        int maoJogador = 0;
        String nipe;
        String face;
        int loop = 1;

        JOptionPane.showMessageDialog(null,
                "**************************************************\n               BEM VINDO AO BLACK JACK\n**************************************************",
                "BEM VINDO", -1);
        JOptionPane.showMessageDialog(null,
                "BLACK JACK\nVocê receberá duas cartas e seu objetivo é chegar mais próximo de 21. \nCaso passe de 21 ou o distribuidor chegar mais perto de 21 você perde. \nCaso ganhe, o valor apostado será dobrado.",
                "TUTORIAL", 3);

        // Valor de aposta
        double valorAposta;

        while (loop == 1) {
            maoJogador = 0;
            jogador1.vezesJogadas21++;

            valorAposta = Double.parseDouble(
                    JOptionPane.showInputDialog(null, "Quanto você deseja apostar?", "Jogo da Galera", -1));
            while (valorAposta > jogador1.saldo || valorAposta <= 0) {
                valorAposta = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Valor de aposta inválido, insira um valor válido:", "Jogo da Galera", -1));
            }

            // Atualiza o saldo do jogador apos a aposta

            jogador1.saldo -= valorAposta;

            double dobrarAposta = valorAposta * 2;
            double empateAposta = valorAposta / 2;

            for (int i = 1; i <= contador; i++) {
                nipe = nipes[random.nextInt(4)];
                face = faces[random.nextInt(faces.length)];
                total = face + nipe;
                if (i == 1) {
                    JOptionPane.showMessageDialog(null, "Sua primeira carta é " + total, "Jogo da Galera", -1);
                } else {
                    JOptionPane.showMessageDialog(null, "Sua segunda carta é " + total, "Jogo da Galera", -1);
                }
                if (face.equals("Ás")) {
                    maoJogador += 11; // Ás vale 11 pontos inicialmente
                } else {
                    maoJogador += Integer.parseInt(face);
                }
            }

            while (maoJogador < 21) {
                int opcao = JOptionPane.showConfirmDialog(null,
                        "Sua pontuação atual é " + maoJogador + ". Deseja pedir mais uma carta?", "Jogo da Galera", 0);
                if (opcao == JOptionPane.YES_OPTION) {
                    nipe = nipes[random.nextInt(4)];
                    face = faces[random.nextInt(faces.length)];
                    total = face + nipe;
                    if (face.equals("Ás")) {
                        maoJogador += 11;
                        JOptionPane.showMessageDialog(null, "Você recebeu uma carta " + total, "Jogo da Galera", -1);
                    } else {
                        maoJogador += Integer.parseInt(face); // Atualizar a pontuação do jogador
                        JOptionPane.showMessageDialog(null, "Você recebeu uma carta " + total, "Jogo da Galera", -1);
                    }
                } else {
                    break;
                }
            }

            int maoDistribuidor = random.nextInt(7) + 15;
            String mensagem;

            int diferencaJ = 21 - maoJogador;
            int diferencaD = 21 - maoDistribuidor;

            if (maoJogador == 21) {
                mensagem = "Jogador ganhou! Recebeu R$" + dobrarAposta;
                jogador1.vitorias21++;
                jogador1.saldo += dobrarAposta;
            } else if (maoJogador > 21) {
                mensagem = "Você estourou! Perdeu R$" + valorAposta;
                jogador1.derrotas21++;
            } else if (diferencaJ > diferencaD) {
                mensagem = "Distribuidor ganhou! Você perdeu R$" + valorAposta;
                jogador1.derrotas21++;
            } else if (maoDistribuidor == maoJogador) {
                mensagem = "Empate! Você ganhou R$" + empateAposta;
                jogador1.empates21++;
                jogador1.saldo += empateAposta;
            } else {
                mensagem = "Jogador ganhou! Recebeu R$" + dobrarAposta;
                jogador1.vitorias21++;
                jogador1.saldo += dobrarAposta;
            }

            JOptionPane.showMessageDialog(null,
                    "A mão do distribuidor é " + maoDistribuidor + " e a sua mão é " + maoJogador, "Jogo da Galera",
                    -1);
            JOptionPane.showMessageDialog(null, mensagem, "Jogo da Galera", -1);
            JOptionPane.showMessageDialog(null, "Seu saldo agora é " + jogador1.saldo, "Jogo da Galera", -1);

            loop = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Jogo da Galera?",
                    JOptionPane.YES_NO_OPTION);
            if (loop == JOptionPane.NO_OPTION) {
                loop = 2;
            } else {
                loop = 1;
            }

        }

        //
    }

}