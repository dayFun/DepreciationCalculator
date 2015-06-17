package depCalc.model;

public class Asset {
    private static final char STRAIGHT_LINE_DEPRECIATION = 'S';
    private static final char DOUBLE_DECLINE_DEPRECIATION = 'D';
    private static final double DOUBLE_DECLINING_RATE = 0.4;
    private static final double UNKNOWN_DEPRECIATION_METHOD_FLAG = -99.99;

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

    public double getAnnualDepreciation() {
        return (cost - salvageValue) / lifeYearsLeft;
    }

    public double getAnnualDepreciation(int year) {
        double beginningBalance = getBeginningBalance(year, DOUBLE_DECLINE_DEPRECIATION);
        return getDoubleDeclineDeprication(beginningBalance);
    }

    public double getBeginningBalance(int year, char depreciationMethod) {
        double balance = cost;
        boolean usingKnownDepreciationMethod = false;

        if (depreciationMethod == STRAIGHT_LINE_DEPRECIATION) {
            double annualDepreciation = getAnnualDepreciation();
            for (int currentYear = 1; currentYear < year; currentYear++) {
                balance -= annualDepreciation;
            }
            usingKnownDepreciationMethod = true;
        } else if (depreciationMethod == DOUBLE_DECLINE_DEPRECIATION) {
            for (int currentYear = 1; currentYear < year; currentYear++) {
                double depreciation = getDoubleDeclineDeprication(balance);
                balance -= depreciation;
            }
            usingKnownDepreciationMethod = true;
        }

        if (usingKnownDepreciationMethod) {
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

    private double getDoubleDeclineDeprication(double beginningBalance) {
        double doubleDeclineDepreciationRate = beginningBalance * DOUBLE_DECLINING_RATE;
        double straightLineDepreciationRate = getAnnualDepreciation();

        if (doubleDeclineDepreciationRate < straightLineDepreciationRate) {
            return maximumAllowableDepreciation(beginningBalance, straightLineDepreciationRate);
        } else {
            return doubleDeclineDepreciationRate;
        }
    }

    private double maximumAllowableDepreciation(double beginningBalance, double depreciation) {
        double valueAfterDepreciation = beginningBalance - depreciation;
        if (valueAfterDepreciation > salvageValue) {
            return depreciation;
        }
        return beginningBalance - salvageValue;
    }
}
