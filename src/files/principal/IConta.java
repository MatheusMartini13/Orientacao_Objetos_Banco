package files.principal;

public interface IConta {

    int sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta contadestino);

    void imprimirExtrato();

}
