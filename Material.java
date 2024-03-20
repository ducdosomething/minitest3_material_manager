import java.time.LocalDate;

/**
 * Material
 */
public abstract class Material {

    private String iD;
    private String name;
    private LocalDate manufacturingDate;
    protected int cost;

    public Material() {
    }

    public Material(String iD, String name, LocalDate manufacturingDate, int cost) {
        this.iD = iD;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.cost = cost;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Material {iD=" + iD + ", name=" + name + ", manufacturingDate=" + manufacturingDate + ", cost=" + cost
                + "}";
    }

    public abstract double getAmount();

    public abstract LocalDate getExpiryDate();
}