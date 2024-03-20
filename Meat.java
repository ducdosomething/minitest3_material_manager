import java.time.LocalDate;

public class Meat extends Material {

    private double weight;

    public Meat() {

    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String iD, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(iD, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return cost * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().minusDays(7);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Meat {iD = '" + getiD() +
                "', name = '" + getName() +
                "', manufacturingDate = '" + getManufacturingDate() +
                "', cost = '" + cost +
                "', weight=" + weight +
                "}";
    }
}
