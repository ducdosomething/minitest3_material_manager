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

    public Meat searchMeatByCost(double searchMeatCost) {
        for (Meat meat : meats) {
            if (meat.getCost() == searchMeatCost) {
                return meat;
            }
        }
        return null;
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

    public CrispyFlour searchFlourByName(String searchFlourName) {
        for (CrispyFlour flour : flours) {
            if (flour.getName().equals(searchFlourName)) {
                return flour;
            }
        }
        return null;
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

    public void bubbleSortMeatByCost() {
        int size = meats.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (meats.get(j).getCost() > meats.get(j + 1).getCost()) {
                    Meat temp = meats.get(j);
                    meats.set(j, meats.get(j + 1));
                    meats.set(j + 1, temp);
                }
            }
        }
    }

    public void bubbleSortFlourByCost() {
        int size = flours.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (flours.get(j).getCost() > flours.get(j + 1).getCost()) {
                    CrispyFlour temp = flours.get(j);
                    flours.set(j, flours.get(j + 1));
                    flours.set(j + 1, temp);
                }
            }
        }
    }

    public ArrayList<Meat> getMeats() {
        return meats;
    }

    public void setMeats(ArrayList<Meat> meats) {
        this.meats = meats;
    }

    public ArrayList<CrispyFlour> getFlours() {
        return flours;
    }

    public void setFlours(ArrayList<CrispyFlour> flours) {
        this.flours = flours;
    }

}
