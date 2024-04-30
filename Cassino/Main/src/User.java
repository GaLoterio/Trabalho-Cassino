import java.util.Scanner;

public class User {
    String nome;
    double saldo = 0;
    Scanner sc = new Scanner(System.in);

    public User(String nome) {
        this.nome = nome;
    }

    public void Depositar() {
        System.out.println("Quanto você deseja depositar?");
        double valor = sc.nextDouble();
        while (valor <= 0) {
            System.out.println("Valor de depósito inválido, insira outro valor.");
            valor = sc.nextDouble();
        }
        this.saldo += valor;
        System.out.println("Foi depositado um valor de R$" + valor + " na sua conta!");
        System.out.println("Seu saldo agora é de R$" + this.saldo + "!");
    }

    public void Sacar() {
        System.out.println("Quanto você deseja sacar?");
        double valor = sc.nextDouble();
        while (valor > this.saldo || valor <= 0) {
            System.out.println("Valor de saque inválido, tente novamente.");
            valor = sc.nextDouble();
        }
        this.saldo -= valor;
        System.out.println("Você sacou R$" + valor + ".");
        System.out.println("Seu saldo agora é de R$" + this.saldo + "!");
    }

}
