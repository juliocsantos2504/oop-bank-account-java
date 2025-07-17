import java.util.Scanner;
public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Informe o valor do depósito inicial: ");
        double initialDeposit = scanner.nextDouble();
        BankAccount bankAccount = new BankAccount(initialDeposit);

        scanner.useDelimiter("\\n");
        var option = -1;
        do {
            System.out.println("------- escolha uma das opcoes---------");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar um boleto");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            switch (option){
                case 1 -> checkBalance(bankAccount);
                case 2 -> checkOverdraftUsage(bankAccount);
                case 3 -> deposit(bankAccount);
                case 4 -> withdraw(bankAccount);
                case 5 -> payBill(bankAccount);
                case 0 -> System.exit(0);
                default -> System.out.println("Opcao invalida");
            }
        }while (true);
    }
    private static void deposit(BankAccount bankAccount){
        System.out.print("Informe o valor do depósito: ");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }
    private static void payBill(BankAccount bankAccount){
        System.out.print("Informe o valor do boleto: ");
        double amount = scanner.nextDouble();
        bankAccount.payBill(amount);
    }
    private static void withdraw(BankAccount bankAccount) {
        System.out.print("Informe o valor do saque: ");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }
    private static void checkBalance(BankAccount bankAccount) {
        bankAccount.checkBalance();
    }

    private static void checkOverdraftUsage(BankAccount bankAccount) {
        bankAccount.checkOverdraftUsage();
    }

}