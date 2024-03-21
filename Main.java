import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MaterialManager
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MaterialManager materialManager = new MaterialManager();

        materialManager.addMeat("1", "M1", LocalDate.of(2023, 1, 12), 200, 1.0);
        materialManager.addMeat("2", "M2", LocalDate.of(2022, 2, 4), 100, 2.0);
        materialManager.addMeat("3", "M3", LocalDate.of(2016, 11, 20), 300, 3.0);
        System.out.println("List of Meats: ");
        materialManager.displayMeat();
        System.out.println("---------------------------");

        materialManager.addFlour("1", "C1", LocalDate.of(2001, 12, 21), 400, 1.0);
        materialManager.addFlour("2", "C2", LocalDate.of(2002, 2, 10), 200, 5.0);
        materialManager.addFlour("3", "C3", LocalDate.of(2003, 7, 2), 300, 6.0);
        System.out.println("List of Flours: ");
        materialManager.displayFlour();
        System.out.println("---------------------------");

        System.out.println("List of Meats: ");
        materialManager.displayMeat();
        materialManager.bubbleSortMeatByCost();
        System.out.println("List of Meats after sort by cost: ");
        materialManager.displayMeat();
        System.out.println("---------------------------");

        System.out.println("List of Flours: ");
        materialManager.displayFlour();
        materialManager.bubbleSortFlourByCost();
        System.out.println("List of Flours after sort by cost: ");
        materialManager.displayFlour();
        System.out.println("---------------------------");

        double totalAmount = 0.0;

        ArrayList<CrispyFlour> flours = materialManager.getFlours();
        System.out.println("List of Flours with discount: ");
        for (CrispyFlour flour : flours) {
            totalAmount += flour.getAmount();
            double discountedAmount = flour.getAmount();
            System.out.println(
                    "ID: " + flour.getiD() + ", Name: " + flour.getName() + ", Discount amount: $" + discountedAmount);
        }
        System.out.println("---------------------------");

        ArrayList<Meat> meats = materialManager.getMeats();

        System.out.println("List of Meats with discount: ");
        for (Meat meat : meats) {
            totalAmount += meat.getAmount();
            double discountedAmount = meat.getAmount();
            System.out.println(
                    "ID: " + meat.getiD() + ", Name: " + meat.getName() + ", Discount amount: $"
                            + discountedAmount);
        }
        System.out.println("---------------------------");

        System.out.println("Total amount of all material: $" + totalAmount);
        System.out.println("---------------------------");

        System.out.println("Enter the Cost of Meat you want to search: ");
        double searchMeatCost = scanner.nextDouble();
        Meat foundedMeat = materialManager.searchMeatByCost(searchMeatCost);
        if (foundedMeat != null) {
            System.out.println("Found Meat: " + foundedMeat);
        } else {
            System.out.println("Material does not exist!");
        }
        System.out.println("---------------------------");

        System.out.println("Enter the Name of Flour you want to search: ");
        String searchFlourName = scanner.next();
        CrispyFlour foundedFlour = materialManager.searchFlourByName(searchFlourName);
        if (foundedMeat != null) {
            System.out.println("Found Flour: " + foundedFlour);
        } else {
            System.out.println("Material does not exist!");
        }
        System.out.println("---------------------------");

        System.out.println("Enter the ID of Meat you want to update: ");
        String searchMeatId = scanner.nextLine();
        Meat foundMeat = materialManager.searchMeatById(searchMeatId);
        if (foundMeat != null) {
            System.out.println("Found Meat: " + foundMeat);
            System.out.println("Enter the new name: ");
            String newMeatName = scanner.next();
            System.out.println("Enter the new cost: ");
            int newMeatCost = scanner.nextInt();
            System.out.println("Enter the new weight: ");
            double newMeatWeight = scanner.nextDouble();

            materialManager.updateMeatById(searchMeatId, newMeatName, newMeatCost,
                    newMeatWeight);
            System.out.println("Meat information after update: ");
            System.out.println(foundMeat);
            System.out.println("---------------------------");

            System.out.println("Enter the ID of Flour you want to update: ");
            String searchFlourId = scanner.next();
            CrispyFlour foundFlour = materialManager.searchFlourById(searchFlourId);
            if (foundFlour != null) {
                System.out.println("Found Flour: " + foundFlour);
                System.out.println("Enter the new name: ");
                String newFlourName = scanner.next();
                System.out.println("Enter the new cost: ");
                int newFlourCost = scanner.nextInt();
                System.out.println("Enter the new quantity: ");
                double newFlourQuantity = scanner.nextDouble();

                materialManager.updateFlourById(searchFlourId, newFlourName, newFlourCost,
                        newFlourQuantity);
                System.out.println("Flour information after update: ");
                System.out.println(foundFlour);
            }
            System.out.println("---------------------------");

            System.out.println("Enter the ID of meat you want to delete: ");
            String deleteMeatId = scanner.next();
            materialManager.deleteMeatById(deleteMeatId);
            System.out.println("Material list after delete: ");
            materialManager.displayMeat();
            System.out.println("---------------------------");

            System.out.println("Enter the ID of flour you want to delete: ");
            String deleteFlourId = scanner.next();
            materialManager.deleteFlourById(deleteFlourId);
            System.out.println("Material list after delete: ");
            materialManager.displayFlour();
        }

        for (Meat meat : materialManager.getMeats()) {
            double discountDifference = meat.calculateDiscountDifference();
            System.out.println("Meat ID " + meat.getiD() + ": Discount difference: $" + discountDifference);
        }

        for (CrispyFlour flour : materialManager.getFlours()) {
            double discountDifference = flour.calculateDiscountDifference();
            System.out.println("Flour ID " + flour.getiD() + ": Discount difference: $" + discountDifference);
        }

        scanner.close();
    }
}