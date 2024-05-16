import javax.swing.JOptionPane;

public class User {
    String nome;
    double saldo = 1000;
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
        valor=Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto você deseja depositar?"));
        
        while (valor <= 0) {
            valor=Double.parseDouble(JOptionPane.showInputDialog(null, "Valor inválido! Insira outro valor!"));
        }
        this.saldo += valor;
        JOptionPane.showMessageDialog(null,"Foi depositado um valor de R$" + valor + " na sua conta!" );
        JOptionPane.showMessageDialog(null, "Seu saldo agora é de R$" + this.saldo + "!");   
    }

    public void Sacar() {
        valor=Double.parseDouble(JOptionPane.showInputDialog(null,"Quanto você deseja sacar?"));

        while (valor > this.saldo || valor <= 0) {
            valor=Double.parseDouble(JOptionPane.showInputDialog(null,"Valor de saque inválido, tente novamente."));
            
        }
        this.saldo -= valor;
        JOptionPane.showMessageDialog(null,"Você sacou R$" + valor + ".");
        JOptionPane.showMessageDialog(null, "Seu saldo agora é de R$" + this.saldo + "!");
        
    }

}
