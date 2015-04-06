package depCalc.model;

public class Asset {

    private static final char STRAIGHT_LINE_DEP = 'S';
    private static final char DOUBLE_DECLINE_DEP = 'D';
    private static final double DOUBLE_DECLINING_RATE = 0.4;

    private String name;
    private double cost;
    private double salvageValue;
    private int life;

    public Asset() {
        this("", 0.0, 0.0, 0);
    }

    public Asset(String name, double cost, double salvageValue, int life) {
        this.name = name;
        setCost(cost);
        setSalvageValue(salvageValue);
        setLifeYearsLeft(life);
    }

    public double getAnnualDep() {
        return (cost - salvageValue) / life;
    }

    public double getAnnualDep(int year) {
        double presentValue = cost;
        double depreciation = 0;
        for (int i = 1; i <= year; i++) {
            depreciation = presentValue * DOUBLE_DECLINING_RATE;
            if (presentValue <= salvageValue) {
                depreciation = 0;
            } else if (presentValue - depreciation < salvageValue) {
                depreciation = presentValue - salvageValue;
            }

            depreciation = switchToStraightLineDepIfNecessary(presentValue, depreciation);
            presentValue = presentValue - depreciation;
        }
        return depreciation;
    }


    public double getBeginningBalance(int year, char depreciationMethod) {
        double beginningBalance = cost;
        if (depreciationMethod == STRAIGHT_LINE_DEP) {
            for (int i = 1; i < year; i++) {
                beginningBalance = beginningBalance - getAnnualDep();
            }
        } else if (depreciationMethod == DOUBLE_DECLINE_DEP) {
            for (int i = 1; i < year; i++) {
                beginningBalance = beginningBalance - getAnnualDep(i);
            }
        }
        return beginningBalance;
    }

    public double getEndingBalance(int year, char depreciationMethod) {
        double endingBalance = cost;
        if (depreciationMethod == STRAIGHT_LINE_DEP) {
            for (int i = 1; i <= year; i++) {
                endingBalance = endingBalance - getAnnualDep();
            }
        } else if (depreciationMethod == DOUBLE_DECLINE_DEP) {
            for (int i = 1; i <= year; i++) {
                endingBalance = endingBalance - getAnnualDep(i);
            }
        }
        return endingBalance;
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
        if (cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Cost cannot be less than zero.");
        }
    }

    public double getSalvageValue() {
        return salvageValue;
    }

    public void setSalvageValue(double salvageValue) {
        if (salvageValue >= 0) {
            this.salvageValue = salvageValue;
        } else {
            throw new IllegalArgumentException("Salvage value cannot be less than zero.");
        }
    }

    public int getLifeYearsLeft() {
        return life;
    }

    public void setLifeYearsLeft(int life) {
        if (life >= 0) {
            this.life = life;
        } else {
            throw new IllegalArgumentException("Life years left cannot be less than zero.");
        }
    }

    private double switchToStraightLineDepIfNecessary(double presentValue, double depreciation) {
        if (depreciation != 0 && shouldSwitchToStaightLineDep(depreciation, presentValue)) {
            depreciation = getAnnualDep();
        }
        return depreciation;
    }

    private boolean shouldSwitchToStaightLineDep(double depreciation, double presentValue) {
        double straightLineDep = getAnnualDep();

        return (depreciation < straightLineDep) && (presentValue - straightLineDep > salvageValue);
    }
}
