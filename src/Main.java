import java.util.Scanner;

import model.Contract;
import service.ContractService;
import service.HistoryService;
import weapon.WeaponFactory;
import weapon.WeaponProducer;
import weapon.WeaponStorage;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        WeaponStorage storage = new WeaponStorage();
        WeaponProducer producer = new WeaponFactory();
        ContractService manager = new ContractService(storage, producer);
        HistoryService history = new HistoryService();

        System.out.println();

        boolean flag = true;
        while (flag) {
            System.out.println("===MENU===");
            System.out.println("1. Current stock");
            System.out.println("2. Show all contracts in history");
            System.out.println("3. New contract (manual input)");
            System.out.println("4. Exit");
            System.out.println("Your choice: ");

            double choice = sc.nextDouble();
            sc.nextLine();

            switch ((int) choice) {
                case 1:
                    storage.prtintStock();
                    System.err.println("Press enter to return to the main MENU");
                    sc.nextLine();
                    break;
                case 2:
                    history.printHistory();
                    System.err.println("Press enter to return to the main MENU");
                    sc.nextLine();
                    break;
                case 3:
                    while (true) {
                        System.out.println("enter weapon name (or \"exit\" to stop and return to the main menu)");
                        String weaponName = sc.nextLine().trim();

                        if (weaponName.equalsIgnoreCase("exit")) {
                            break;
                        }

                        System.out.println("enter quantity");
                        int quantity = sc.nextInt();
                        sc.nextLine();

                        Contract userContract = new Contract(weaponName, quantity);
                        manager.processContract(userContract);
                        history.addToHistory(weaponName, quantity);
                    }
                    break;
                case 4:
                    flag = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}