package co.thiagomarques.bank;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco santander = new Banco("0001");
        //C = Criar conta
        //E = Sair (exit)

        while (true) {//Cria as várias contas
            System.out.println("O que deseja fazer ? C = Criar conta, E = Sair do programa");
            String op = scanner.nextLine();

            if (op.equals("C")){
                System.out.println("Digite o seu nome: ");
                String nome = scanner.nextLine();
                Account account = santander.geracaoDeConta(nome);//Gerando a conta automáticamente.
                santander.insereConta(account);//Adiciona na lista de contas.

                operacaoConta(account);//Outra função para operar a nova conta criada.
            } else if (op.equals("E")) {
                System.out.println("Fim da operação.");
                break;
            }else{
                System.out.println("Comando invalido, tente novamente");
            }
        }

        List<Account> listaDeContas = santander.getAccounts();
        for (Account cc: listaDeContas){ //Nomenclatura com cc padrão para fazer loops dentro de um objeto.
            System.out.println(cc);//Usando o for para imprimir
        }

        santander.totalDeContas();
        //Criar uma conta (agência, conta, nome)
        //   limitar o nome = 12 caracteres
       // Account account1 = new Account("0001", "1234", "Zenom Barriga Pesado");

        //sacar valores
        // Não pode sacar mais do que o saldo
       // account1.sacar(200.0);

        //depositar
        //account1.depositar(100);
        //account1.depositar(100);
        //account1.depositar(100);

        //account1.sacar(200);
        //account1.sacar(300);



        //informar para o usuário as operações (saque, depósito)
        //System.out.println(account1);//Imprimindo a toString sobreescrita no código
    }

    static void operacaoConta(Account account){

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("O que deseja fazer ? D=Depósito, S=Saque, E=Sair da Conta");
            String op = scanner.nextLine();
            //D = Depósito
            //S = Saque
            //E = Sair (exit)
            if (op.equals("D")){
                System.out.println("Qual valor deseja depositar ?:");
                double value = scanner.nextDouble();
                account.depositar(value);
            }else if (op.equals("S")){
                System.out.println("Qual valor deseja sacar ?:");
                double value = scanner.nextDouble();
                /*if (!account.sacar(value)){//Outra forma de aviso, na lógica do método já existe uma mensagem.
                    System.out.println("Ops!! Não foi possível sacar o valor R$ " + value);
                }*/
                account.sacar(value);
            } else if (op.equals("E")) {
                break;
            }else{
                System.out.println("Comando inválido, tente novamente !!");
            }

            scanner = new Scanner(System.in);//Evita que haja duplicação de mensagem do scanner
        }
    }
}
