import javax.swing.JOptionPane;
import java.util.Random;

public class BlackJack {
    public static void main(String[] args) {
 Random random = new Random();
        String[] nipes = { "♠", "♥", "♦", "♣" };
        String[] faces = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Ás" };
        String total = "";
        User jogador1 = new User("gustavo");

        int contador = 2;
        int maoJogador = 0;
        String nipe;
        String face;

        JOptionPane.showMessageDialog(null,"**************************************************\n               BEM VINDO AO BLACK JACK\n**************************************************","BEM VINDO",-1);
        JOptionPane.showMessageDialog(null,"BLACK JACK\nVocê receberá duas cartas e seu objetivo é chegar mais próximo de 21. \nCaso passe de 21 ou o distribuidor chegar mais perto de 21 você perde. \nCaso ganhe, o valor apostado será dobrado.","TUTORIAL",3);

        //Valor de aposta
        double valorAposta;
                
        valorAposta = Double.parseDouble(JOptionPane.showInputDialog(null,"Quanto você deseja apostar?"));
        while (valorAposta > jogador1.saldo || valorAposta <= 0){
           valorAposta = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor de aposta inválido, insira um valor válido:"));
        }

        double novoValor = jogador1.saldo - valorAposta;
        double dobrarAposta = valorAposta * 2;
        double perdeuAposta = valorAposta - valorAposta;
        double empateAposta = valorAposta / 2; 

        for (int i = 1; i <= contador; i++) {
            nipe = nipes[random.nextInt(4)];
            face = faces[random.nextInt(faces.length)];
            total = face + nipe;
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "Sua primeira carta é " + total);
            } else {
                JOptionPane.showMessageDialog(null, "Sua segunda carta é " + total);
            }
            if (face.equals("Ás")) {
                maoJogador += 11; // Ás vale 11 pontos inicialmente
            } else {
                maoJogador += Integer.parseInt(face);
            }
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
            mensagem = "Jogador ganhou!"+" R$" +dobrarAposta;
            novoValor += dobrarAposta;
        } else if(maoJogador > 21){
            mensagem = "Você estourou!"+" R$" +perdeuAposta;
            novoValor -= perdeuAposta;
        } else if(diferencaJ > diferencaD) {
            mensagem = "Distribuidor ganhou";
            novoValor -= perdeuAposta;
        } else if (diferencaJ == diferencaD) {
            mensagem = "Empate"+" R$" +empateAposta;
            novoValor -= empateAposta;
        } else {
            mensagem = "Jogador ganhou"+" R$" +dobrarAposta;
            novoValor += dobrarAposta;

        }

        JOptionPane.showMessageDialog(null, "A mão do distribuidor é " + maoDistribuidor);
        JOptionPane.showMessageDialog(null, mensagem);
        JOptionPane.showMessageDialog(null, "Seu saldo agora é " +novoValor);

    }

    
       
    

}