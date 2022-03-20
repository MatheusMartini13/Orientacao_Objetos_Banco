package files.principal;

public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numeroconta;
    protected double saldo;
    protected Cliente cliente;

     public Conta(Cliente cliente) {
         this.agencia = AGENCIA_PADRAO;
         this.numeroconta = SEQUENCIAL++;
         this.cliente = cliente;

     }

     @Override
    public int sacar(double valor) {
         System.out.println("** Analisando saldo da conta **");
         if (this.saldo <= valor) {
             System.out.println("xx Saldo insuficiente para a operação. xx");
             return 0;
         } else{
             System.out.println("-- Retirando "+ valor+ " da conta --");
             this.saldo -= valor;
             return 1;
         }
    }

    @Override
    public void depositar(double valor) {
        System.out.println("++ Adicionando "+ valor+ " na conta ++");
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        System.out.println("** Operação de Transferência **");
        if (this.sacar(valor) == 1) {
            System.out.println("** Realizando transferência para a conta de numero " + contaDestino.getNumeroconta() + " do cliente " + contaDestino.cliente.getNome() + " **");
            contaDestino.depositar(valor);
        }
        System.out.println("** Atualizando dados da sua conta **");
        this.imprimirInfosComuns();
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroconta() {
        return numeroconta;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numeroconta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
    }

}
