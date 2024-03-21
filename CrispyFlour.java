import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {

    private double quantity;

    public CrispyFlour() {

    }

    public CrispyFlour(double quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String iD, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(iD, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        double originalAmount = quantity * cost;
        return originalAmount - applyDiscount(originalAmount);
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().minusYears(1);
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CrispyFlour {iD = '" + getiD() +
                "', name = '" + getName() +
                "', manufacturingDate = '" + getManufacturingDate() +
                "', cost = '" + cost +
                "', quantity = '" + quantity +
                "'}";
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.06;
    }

    @Override
    public double getAmountWithoutDiscount() {
        return getCost() * getQuantity();
    }
}
