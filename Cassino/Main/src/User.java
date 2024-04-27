import java.util.Scanner;

public class User {
    String nome;
    double saldo = 0;
    Scanner sc = new Scanner(System.in);

    public User(String nome){
        this.nome = nome;
    }

    public void Depositar(double valor){
        while (valor <= 0){
            System.out.println("Valor de depósito inválido, insira outro valor.");
            valor = sc.nextDouble();
        }
        this.saldo += valor;
    }


   

}
