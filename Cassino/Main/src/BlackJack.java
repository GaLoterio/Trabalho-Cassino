import javax.swing.JOptionPane;
import java.util.Random;

public class BlackJack {
    public static void main(String[] args) {
 Random random = new Random();
        String[] nipes = { "♠", "♥", "♦", "♣" };
        String[] faces = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        String total = "";
        String total2 = "";
        String total3="21";
        int contador = 2;
        int maoJogador = 0;
        String nipe;
        String face;
        for (int i = 1; i <= contador; i++) {
            nipe = nipes[(int) (Math.random() * 4)];
            face = faces[(int) (Math.random() * faces.length)];
            total = face + nipe;
            total2 = face;
           
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "Sua primeira carta é " + total);
            } else {
                JOptionPane.showMessageDialog(null, "Sua segunda carta é " + total);
            }
        }
        
        maoJogador = Integer.parseInt(total2);
        while(maoJogador < 21){
                String resposta = JOptionPane.showInputDialog(null, "Você deseja pedir mais uma carta?");
                if(resposta.equalsIgnoreCase("sim")){
                    nipe = nipes[(int) (Math.random() * 4)];
                    face = faces[(int) (Math.random() * faces.length)];
                    total = face + nipe;
                    JOptionPane.showMessageDialog(null, "Sua nova carta é " + total);
                    maoJogador += Integer.parseInt(total);
                } else {
                    break;
                }
                
            }

       
        
        int maoDistribuidor = random.nextInt(7) + 15;
        String mensagem;

        int diferencaJ = 21 - maoJogador;
        int diferencaD = 21 - maoDistribuidor;

        if (diferencaJ > diferencaD) {
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