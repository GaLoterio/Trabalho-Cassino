import javax.swing.JOptionPane;
import java.util.Random;
public class BlackJack {
    public static void main(String[] args) {
        
        
        String[] nipes = {"♠", "♥", "♦", "♣"};
        String[] faces = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String total="";
        String total2="";
        int contador = 2;
        
        for (int i = 1; i<=contador; i++){
        String nipe = nipes[(int)(Math.random()*4)];
        String face = faces[(int) (Math.random()* faces.length)];
        total = face + nipe;
        total2 = face;
        JOptionPane.showMessageDialog(null,"Sua mão é " + total);

        }
        
         Random random = new Random();
        int maoJogador=Integer.parseInt(total2);
        int maoDistribuidor = random.nextInt(7) + 15;
        String mensagem;
        
        int diferencaJ = 21 - maoJogador;
        int diferencaD = 21 - maoDistribuidor;
        
        if (diferencaJ > diferencaD){
            mensagem="Distribuidor ganhou";
        }
        else if(diferencaJ == diferencaD){
            mensagem="Empate";
        } else{
        mensagem="Jogador ganhou";
        }

        JOptionPane.showMessageDialog(null,"A mão do distribuidor é " +maoDistribuidor);
        JOptionPane.showMessageDialog(null,mensagem);
        

    
    }
    
}

