import javax.swing.JOptionPane;

public class User {
    String nome;
    double saldo = 0;
    double valor;
    int vitorias21 = 0;
    int derrotas21 = 0;
    int vitoriasBacBo = 0;
    int derrotasBacBo = 0;
    int vezesJogadas21 = 0;
    int vezesJogadasBacBo = 0;
    int empates21 = 0;
    int vitorias = vitorias21 + vitoriasBacBo;
    int derrotas = derrotas21 + derrotasBacBo;
    

    public User(String nome) {
        this.nome = nome;
    }

    public void Depositar() {
        valor=Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto você deseja depositar?", "Jogo da Galera", -1));
        
        while (valor <= 0) {
            valor=Double.parseDouble(JOptionPane.showInputDialog(null, "Valor inválido! Insira outro valor!", "Jogo da Galera", -1));
        }
        this.saldo += valor;
        JOptionPane.showMessageDialog(null,"Foi depositado um valor de R$" + valor + " na sua conta!", "Jogo da Galera", -1 );
        JOptionPane.showMessageDialog(null, "Seu saldo agora é de R$" + this.saldo + "!", "Jogo da Galera", -1);   
    }

    public void Sacar() {
        valor=Double.parseDouble(JOptionPane.showInputDialog(null,"Quanto você deseja sacar?", "Jogo da Galera", -1));

        while (valor > this.saldo || valor <= 0) {
            valor=Double.parseDouble(JOptionPane.showInputDialog(null,"Valor de saque inválido, tente novamente.", "Jogo da Galera", -1));
            
        }
        this.saldo -= valor;
        JOptionPane.showMessageDialog(null,"Você sacou R$" + valor + ".", "Jogo da Galera", -1);
        JOptionPane.showMessageDialog(null, "Seu saldo agora é de R$" + this.saldo + "!", "Jogo da Galera", -1);
        
    }

}
