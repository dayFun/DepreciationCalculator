package model;

public class Asset {

    // A method called getBegBal(y,m) which returns the beginning balance for year y using method m,
    // where m is either S for straight-line or D for double-declining.
    // A property called getEndBal(y,m) which returns the ending balance for year y using method m.

    private static final char STRAIGHT_LINE_DEP = 'S';
    private static final char DOUBLE_DECLINE_DEP = 'D';
    private static final double DOUBLE_DECLINING_RATE = 0.4;

    private String name;
    private double cost;
    private double salvageValue;
    private int life;

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
        double presentValue = cost;
        double depreciation = 0;
        for (int i = 1; i <= year; i++) {
            depreciation = presentValue * DOUBLE_DECLINING_RATE;
            if (presentValue <= salvageValue) {
                depreciation = 0;
                break;
            } else if (presentValue - depreciation < salvageValue) {
                depreciation = presentValue - salvageValue;
            }

            if (depreciation != 0 && shouldSwitchToStaightLineDep(depreciation, presentValue)) {
                depreciation = getAnnualDep();
            }
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

    private boolean shouldSwitchToStaightLineDep(double depreciation, double presentValue) {
        double straightLineDep = getAnnualDep();

        return (depreciation < straightLineDep) && (presentValue - straightLineDep > salvageValue);
    }
}
