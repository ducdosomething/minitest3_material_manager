import java.time.LocalDate;
import java.util.ArrayList;

public class MaterialManager {

    ArrayList<Meat> meats = new ArrayList<>();

    public void addMeat(String iD, String name, LocalDate manufacturingDate, int cost, double weight) {
        Meat meat = new Meat(iD, name, manufacturingDate, cost, weight);
        meats.add(meat);
    }

    ArrayList<CrispyFlour> flours = new ArrayList<>();

    public void addFlour(String iD, String name, LocalDate manufacturingDate, int cost, double quantity) {
        CrispyFlour flour = new CrispyFlour(iD, name, manufacturingDate, cost, quantity);
        flours.add(flour);
    }

    public void displayMeat() {
        if (meats.isEmpty()) {
            System.out.println("No meats available!");
        } else {
            for (Meat meat : meats) {
                System.out.println(meat);
            }
        }
    }

    public void displayFlour() {
        if (flours.isEmpty()) {
            System.out.println("No flours available!");
        } else {
            for (CrispyFlour flour : flours) {
                System.out.println(flour);
            }
        }
    }

    public Meat searchMeatById(String searchMeatId) {
        for (Meat meat : meats) {
            if (meat.getiD().equals(searchMeatId)) {
                return meat;
            }
        }
        return null;
    }

    public void updateMeatById(String searchMeatId, String newMeatName, int newMeatCost, double newMeatWeight) {
        for (Meat meat : meats) {
            if (meat.getiD().equals(searchMeatId)) {
                meat.setName(newMeatName);
                meat.setCost(newMeatCost);
                meat.setWeight(newMeatWeight);
                return;
            }
        }
    }

    public void deleteMeatById(String deleteMeatId) {
        for (int i = 0; i < meats.size(); i++) {
            if (meats.get(i).getiD().equals(deleteMeatId)) {
                meats.remove(i);
                return;
            }
        }
    }

    public CrispyFlour searchFlourById(String searchFlourId) {
        for (CrispyFlour flour : flours) {
            if (flour.getiD().equals(searchFlourId)) {
                return flour;
            }
        }
        return null;
    }

    public void updateFlourById(String searchFlourId, String newFlourName, int newFlourCost, double newFlourQuantity) {
        for (CrispyFlour flour : flours) {
            if (flour.getiD().equals(searchFlourId)) {
                flour.setName(newFlourName);
                flour.setCost(newFlourCost);
                flour.setQuantity(newFlourQuantity);
                return;
            }
        }
    }

    public void deleteFlourById(String deleteFlourId) {
        for (int i = 0; i < flours.size(); i++) {
            if (flours.get(i).getiD().equals(deleteFlourId)) {
                flours.remove(i);
                return;
            }
        }
    }
}
