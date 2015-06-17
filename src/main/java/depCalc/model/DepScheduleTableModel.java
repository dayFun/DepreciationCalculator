package depCalc.model;

import javax.swing.table.AbstractTableModel;

public class DepScheduleTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -7010312622673643462L;
    private String[] columnHeaders = {"Year", "Beginning Balance", "Annual Depreciation", "Ending Balance"};
    private Asset asset;

    public void setData(Asset asset) {
        this.asset = asset;
    }

    @Override
    public int getRowCount() {
        if (asset != null) {
            return asset.getLifeYearsLeft();
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
                return asset.getBeginningBalance(year, 'S');
            case 2:
                return asset.getAnnualDepreciation(year);
            case 3:
                return asset.getEndingBalance(year, 'S');
            default:
                return null;
        }
    }

    public void clear() {
        asset = null;
    }

}
