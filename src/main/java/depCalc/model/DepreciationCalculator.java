package depCalc.model;

public class DepreciationCalculator {
    private static final char STRAIGHT_LINE_DEPRECIATION = 'S';
    private static final char DOUBLE_DECLINE_DEPRECIATION = 'D';
    private static final double DOUBLE_DECLINING_RATE = 0.4;
    private static final double UNKNOWN_DEPRECIATION_METHOD_FLAG = -99.99;

    private final Asset asset;

    public DepreciationCalculator(Asset asset) {
        this.asset = asset;
    }

    public Asset getAsset() {
        return asset;
    }

    public double getAnnualDepreciation() {
        return (getAsset().getCost() - getAsset().getSalvageValue()) / getAsset().getLifeYearsLeft();
    }

    public double getAnnualDepreciation(int year) {
        double beginningBalance = getBeginningBalance(year, DOUBLE_DECLINE_DEPRECIATION);
        return getDoubleDeclineDeprication(beginningBalance);
    }

    public double getBeginningBalance(int year, char depreciationMethod) {
        double balance = getAsset().getCost();
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
        if (valueAfterDepreciation > getAsset().getSalvageValue()) {
            return depreciation;
        }
        return beginningBalance - getAsset().getSalvageValue();
    }
}
