import java.util.Scanner;

public class BankAccount {
    private static double[] tabCpt = new double[25];
    private static int count = 0; 

   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("1. Transaction");
            System.out.println("2. Consulter le solde");
            System.out.println("3. Afficher la dépense la plus importante");
            System.out.println("4. Quitter");
            System.out.print("Entrez votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Entrez le montant de la transaction (positif pour dépôt, négatif pour retrait) : ");
                    double amount = scanner.nextDouble();
                    transaction(amount);
                    break;
                case 2:
                    System.out.println("Le solde du compte est : " + getBalance());
                    break;
                case 3:
                    System.out.println("La dépense la plus importante est : " + largestExpense());
                    break;
                case 4:
                    System.out.println("Vous avez quitté le système bancaire.");
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez réessayer.");
            }
        } while (choice != 4);
        
        scanner.close();
    }
    public static void transaction(double amount) {
        if (count < tabCpt.length) {
            tabCpt[count++] = amount;
            System.out.println("Transaction effectuée avec succès.");
        } else {
            System.out.println("Nombre maximum de transactions atteint.");
        }
    }

    public static double getBalance() {
        double balance = 0;
        for (int i = 0; i < count; i++) {
            balance += tabCpt[i];
        }
        return balance;
    }
    public static double largestExpense() {
        double largest = Double.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            if (tabCpt[i] < largest) {
                largest = tabCpt[i];
            }
        }
        return largest == Double.MAX_VALUE ? 0 : largest;
    }
}
