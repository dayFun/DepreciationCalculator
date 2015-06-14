package depCalc.model;

public class AssetTwo {
    private static final char STRAIGHT_LINE_DEPRECIATION = 'S';
    private static final char DOUBLE_DECLINE_DEPRECIATION = 'D';
    private static final double DOUBLE_DECLINING_RATE = 0.4;
    private static final double UNKNOWN_DEPRECIATION_METHOD_FLAG = -99.99;

    private String name;
    private double cost;
    private double salvageValue;
    private int lifeYearsLeft;

    public AssetTwo() {
        this("", 0.0, 0.0, 0);
    }

    public AssetTwo(String name, double cost, double salvageValue, int lifeYearsLeft) {
        this.name = name;
        this.cost = cost;
        this.salvageValue = salvageValue;
        this.lifeYearsLeft = lifeYearsLeft;
    }

    public double getAnnualDepreciation() {
        return (cost - salvageValue) / lifeYearsLeft;
    }

    public double getAnnualDepreciation(int year, char depreciationMethod) {
        if (depreciationMethod == STRAIGHT_LINE_DEPRECIATION) {
            return getAnnualDepreciation();
        } else if (depreciationMethod == DOUBLE_DECLINE_DEPRECIATION) {
            return getDoubleDeclineDeprication(cost);
        }

        return UNKNOWN_DEPRECIATION_METHOD_FLAG;
    }

    public double getBeginningBalance(int year, char depreciationMethod) {
        double balance = cost;

        if (depreciationMethod == STRAIGHT_LINE_DEPRECIATION) {
            double annualDepreciation = getAnnualDepreciation();
            for (int currentYear = 1; currentYear < year; currentYear++) {
                balance -= annualDepreciation;
            }
            return balance;
        } else if (depreciationMethod == DOUBLE_DECLINE_DEPRECIATION) {
            for (int currentYear = 1; currentYear < year; currentYear++) {
                double depreciation = getDoubleDeclineDeprication(balance);
                balance -= depreciation;
            }
            return balance;
        }

        return UNKNOWN_DEPRECIATION_METHOD_FLAG;
    }

    public double getEndingBalance(int year, char depreciationMethod) {
        double endingBalance = getBeginningBalance(year, depreciationMethod);
        if (depreciationMethod == STRAIGHT_LINE_DEPRECIATION) {
            return endingBalance - getAnnualDepreciation();
        } else if (depreciationMethod == DOUBLE_DECLINE_DEPRECIATION) {
            return endingBalance - getDoubleDeclineDeprication(endingBalance);
        }

        return UNKNOWN_DEPRECIATION_METHOD_FLAG;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public double getSalvageValue() {
        return salvageValue;
    }

    public int getLifeYearsLeft() {
        return lifeYearsLeft;
    }

    private double getDoubleDeclineDeprication(double beginningBalance) {
        return beginningBalance * DOUBLE_DECLINING_RATE;
    }
}
