package depCalc.model;

public class Asset {
    private String name;
    private double cost;
    private double salvageValue;
    private int lifeYearsLeft;

    public Asset() {
        this("", 0.0, 0.0, 0);
    }

    public Asset(String name, double cost, double salvageValue, int lifeYearsLeft) {
        this.name = name;
        this.cost = cost;
        this.salvageValue = salvageValue;
        this.lifeYearsLeft = lifeYearsLeft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSalvageValue() {
        return salvageValue;
    }

    public void setSalvageValue(double salvageValue) {
        this.salvageValue = salvageValue;
    }

    public int getLifeYearsLeft() {
        return lifeYearsLeft;
    }

    public void setLifeYearsLeft(int lifeYearsLeft) {
        this.lifeYearsLeft = lifeYearsLeft;
    }
}
