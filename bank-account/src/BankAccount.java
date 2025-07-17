public class BankAccount {
    public double getBalance() {
        return balance;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public void setOverdraftUsed(double overdraftUsed) {
        this.overdraftUsed = overdraftUsed;
    }

    private double balance;
    private double overdraftLimit;
    private double overdraftUsed;

    public static final double fixedOverdraft = 50.0;
    public static final double overdraftPercent =0.5;
    public static final double overdraftFeeRate = 0.2;

    // Construtor
    public BankAccount(double initialDeposit){
        //define o saldo inicial
        this.balance = initialDeposit;

        //define limite do cheque especial
        if (initialDeposit <= 500.00){
            this.overdraftLimit = fixedOverdraft;
        } else {
            this.overdraftLimit =initialDeposit * overdraftPercent;
        }
        //inicia sem uso do limite
        this.overdraftUsed=0;

    }
    //======metotodos publicos para implementar======
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }

        balance += amount;
        System.out.printf("Depósito de R$ %.2f realizado.%n", amount);

        // Aplica taxa se o cheque especial foi usado e saldo agora é >= 0
        applyOverdraftFee();
    }
    public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Valor inválido para saque.");
                return;
            }

            double totalAvailable = balance + (overdraftLimit - overdraftUsed);

            if (amount > totalAvailable) {
                System.out.println("Saque não permitido: saldo insuficiente, mesmo com cheque especial.");
                return;
            }

            balance -= amount;
            System.out.printf("Saque de R$ %.2f realizado.%n", amount);

            // Atualiza o uso do cheque especial, se necessário
            if (balance < 0) {
                overdraftUsed = Math.abs(balance);
            }


    }
    public void payBill(double amount) {
        System.out.println("Pagamento de boleto:");
        withdraw(amount); // mesma lógica de saque
    }

    public void checkBalance() {
        System.out.printf("Saldo atual: R$ %.2f%n", balance);

        if (balance < 0) {
            System.out.println("⚠️ Sua conta está negativa (usando cheque especial).");
            System.out.printf("Limite restante: R$ %.2f%n", overdraftLimit - overdraftUsed);
        } else {
            System.out.println("✅ Sua conta está positiva.");
            System.out.printf("Cheque especial disponível: R$ %.2f%n", overdraftLimit - overdraftUsed);
        }
    }

    public void checkOverdraftUsage() {
        if (balance < 0) {
            System.out.println("Você está utilizando o cheque especial.");
            System.out.printf("Valor usado: R$ %.2f%n", Math.abs(balance));
            System.out.printf("Limite disponível: R$ %.2f%n", overdraftLimit - Math.abs(balance));
        } else {
            System.out.println("Você não está utilizando o cheque especial.");
            System.out.printf("Limite total disponível: R$ %.2f%n", overdraftLimit);
        }

    }
        public void applyOverdraftFee() {
            if (overdraftUsed > 0 && balance >= 0) {
                double fee = overdraftUsed * overdraftFeeRate;
                System.out.printf("Aplicando taxa de R$ %.2f sobre o uso do cheque especial.%n", fee);
                balance -= fee;
                overdraftUsed = 0; // Zera o controle do cheque especial usado
            }
        }

    }
