package co.thiagomarques.bank;

public class Account {
    private static final int MAX_LENGTH = 20;//Propriedade compartilhada em todos os objetos pois é da classe. O final deixa o valor constante.
    private String agencia;
    private String conta;
    private String nome;
    private double saldo;
    private Log logger;

    //Construtor -- Forçará a classe a pedir os parâmetros agência, conta e classe
    public Account(String agencia, String conta, String nome){
        this.agencia = agencia;//O valor trazido da invocação da classe é atribuido ao parâmetro da classe aqui neste objeto.
        this.conta = conta;
        setNome(nome);//No construtor, passa o setter criado abaixo para o nome.
        logger = new Log(); //Criando um objeto da classe Log.
    }

    //Método para limitar o caraacter de nome
    public void setNome(String nome) {
        if(nome.length() > MAX_LENGTH){//Se o nome passou do limite de caracteres da propridade compartilhada com valor constatnte.
           this.nome = nome.substring(0, MAX_LENGTH);//Corte o nome dentro dos caracteres do MAX_LENGTH
        }else{
           this.nome = nome;//Passa o nome normalmente.
        }
        System.out.println(this.nome);
    }

    //Método para depositar um valor
    public  void depositar(double valor){
         saldo += valor; //Adicionando valor no  saldo (deposito de dinheiro)
         logger.out("DEPÓSITO - Valor depositado R$ " + valor + ", sua conta tem agora R$ " + saldo);//Chamando o método out da classe Log que imprime uma mensagem.
    }

    //Método para sacar um valor
    public boolean sacar(double valor){
        if(saldo < valor){
            logger.out("SAQUE - Ops !! Não é possível sacar pois não há saldo suficiente! Saldo: R$ " + saldo + " para saque de R$ " + valor);
            return false;
        }else{
            saldo = saldo - valor;//Outra forma de fazer o valor ser tirado do saldo: saldo -= valor;
            logger.out("SAQUE - Valor a retirar: " + valor + " , total na conta é: " + saldo);
            logger.out("SAQUE - Saque efetuado !!");
            return true;
        }
    }

    public double getSaldo(){
        return saldo;
    }

    @Override
    public String toString() {//Sobreescrevendo o toString
        //String resultado = "A conta " + this.nome + " " + this.agencia + " / " + this.conta + " possui : R$ " + saldo;
        //return resultado;
        return "A conta " + this.nome + " " + this.agencia + " / " + this.conta + " possui : R$ " + saldo; //As linhas acima são o mesmo resultado desta
    }
}
