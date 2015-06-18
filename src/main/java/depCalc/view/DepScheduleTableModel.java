package depCalc.view;

import javax.swing.table.AbstractTableModel;

import depCalc.model.DepreciationCalculator;

public class DepScheduleTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -7010312622673643462L;
    private String[] columnHeaders = {"Year", "Beginning Balance", "Annual Depreciation", "Ending Balance"};
    private DepreciationCalculator depreciationCalculator;

    public void setData(DepreciationCalculator depreciationCalculator) {
        this.depreciationCalculator = depreciationCalculator;
    }

    @Override
    public int getRowCount() {
        if (depreciationCalculator != null) {
            return depreciationCalculator.getAsset().getLifeYearsLeft();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columnHeaders.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnHeaders[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int year = rowIndex + 1;
        switch (columnIndex) {
            case 0:
                return year;
            case 1:
                return depreciationCalculator.getBeginningBalance(year, 'S');
            case 2:
                return depreciationCalculator.getAnnualDepreciation();
            case 3:
                return depreciationCalculator.getEndingBalance(year, 'S');
            default:
                return null;
        }
    }

    //TODO: Will this work?
    public void clear() {
        depreciationCalculator = null;
    }

}
