package model;

public class Asset {

    private String name;
    private double cost;
    private double salvageValue;
    private int life;
    private double endValue;

    public Asset(String name, double cost, double salvageValue, int life) {
        this.name = name;
        this.cost = cost;
        this.salvageValue = salvageValue;
        this.life = life;
    }

    public double getAnnualDep() {
        return (cost - salvageValue) / life;
    }

    public double getAnnualDep(int year) {
        return 2 * getAnnualDep() * salvageValue;
    }

    public double getEndValue() {
        return endValue;
    }

    public void setEndValue(double endValue) {
        this.endValue = endValue;
    }

}
