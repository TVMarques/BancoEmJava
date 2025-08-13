package co.thiagomarques.bank;
import java.util.List;
import java.util.ArrayList;

public class Banco {

    private String ag;
    private List <Account> accounts;

    private int ultimaConta = 1;

    public Banco(String ag){
        this.ag = ag;
        this.accounts = new ArrayList<>();//Lista de contas vazias.
    }

    public List<Account> getAccounts(){
        return accounts; //Assim retorna todas as contas criadas na lista.
    }

    public void insereConta(Account account){
        accounts.add(account);//Adicionando contas na lista de contas.
    }

    public Account geracaoDeConta(String nome){
        Account account = new Account(ag, "" + ultimaConta ,nome);
        ultimaConta++;//Fazendo com que o número de contas registrados no banco aumente.
        return  account;
    }

    public void totalDeContas(){
        double total = 0;
        for (Account account : accounts){//Para cada lista de contas aqui desta classe, faça:
            double saldo = account.getSaldo();
            total += saldo;//Faz a soma do saldo das contas no banco.
        }
        System.out.println("Banco possui agora R$ " + total); //Imprime o valor total do BANCO !!
    }
}
