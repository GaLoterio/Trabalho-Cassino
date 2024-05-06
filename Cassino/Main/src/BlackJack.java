import javax.swing.JOptionPane;
import java.util.Random;

public class BlackJack {
    public static void main(String[] args) {
 Random random = new Random();
        String[] nipes = { "♠", "♥", "♦", "♣" };
        String[] faces = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        String total = "";


        int contador = 2;
        int maoJogador = 0;
        String nipe;
        String face;
        for (int i = 1; i <= contador; i++) {
            nipe = nipes[random.nextInt(4)];
            face = faces[random.nextInt(faces.length)];
            total = face + nipe;
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "Sua primeira carta é " + total);
            } else {
                JOptionPane.showMessageDialog(null, "Sua segunda carta é " + total);
            }
            maoJogador += Integer.parseInt(face); // Atualizar a pontuação do jogador
        }
        while (maoJogador < 21) {
            int opcao = JOptionPane.showConfirmDialog(null, "Sua pontuação atual é " + maoJogador + ". Deseja pedir mais uma carta?");
            if (opcao == JOptionPane.YES_OPTION) {
                nipe = nipes[random.nextInt(4)];
                face = faces[random.nextInt(faces.length)];
                total = face + nipe;
                maoJogador += Integer.parseInt(face); // Atualizar a pontuação do jogador
                JOptionPane.showMessageDialog(null, "Você recebeu uma carta " + total);
            } else {
                break;
            }
        }


        int maoDistribuidor = random.nextInt(7) + 15;
        String mensagem;

        int diferencaJ = 21 - maoJogador;
        int diferencaD = 21 - maoDistribuidor;

        if (maoJogador == 21){
            mensagem = "Jogador ganhou!";
        } else if(maoJogador > 21){
            mensagem = "Você estourou!";
        } else if(diferencaJ > diferencaD) {
            mensagem = "Distribuidor ganhou";
        } else if (diferencaJ == diferencaD) {
            mensagem = "Empate";
        } else {
            mensagem = "Jogador ganhou";
        }

        JOptionPane.showMessageDialog(null, "A mão do distribuidor é " + maoDistribuidor);
        JOptionPane.showMessageDialog(null, mensagem);

    }

}