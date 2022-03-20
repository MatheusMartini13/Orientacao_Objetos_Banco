package files.principal;

public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("** Extrato da Poupança **");
        super.imprimirInfosComuns();
    }
}
