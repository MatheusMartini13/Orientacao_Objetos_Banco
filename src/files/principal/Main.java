package files.principal;

public class Main {

    public static void main(String[] args) {
        Cliente matheus = new Cliente();
        matheus.setNome("Matheus Martini");

        Conta cc = new ContaCorrente(matheus);
        cc.depositar(100);

        Conta poupanca = new ContaPoupança(matheus);

        cc.transferir(75,poupanca);

        cc.sacar(10);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }

}
