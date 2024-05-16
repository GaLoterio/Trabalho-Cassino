import javax.swing.JOptionPane;

public class User {
    String nome;
    double saldo = 1000;
    double valor;

    public User(String nome) {
        this.nome = nome;
    }

    public void Depositar() {
        valor=Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto você deseja depositar?"));
        
        while (valor <= 0) {
            valor=Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto você deseja depositar?"));
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
