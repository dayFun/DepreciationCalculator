package depCalc.view;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import depCalc.model.Asset;


public class DepMetricsPanelTest {

    private DepMetricsPanel metricsPanel;
    private String name;
    private double cost;
    private double salvageValue;
    private int lifeYearsLeft;

    @Before
    public void setup() {
        metricsPanel = new DepMetricsPanel();
        name = "105\" 4K TV";
        cost = 20000.99;
        salvageValue = 5000.99;
        lifeYearsLeft = 10;
    }

    @Test
    public void testCreateAssetFromFieldsWithValidData() throws Exception {
        setTextFieldsOnView(name, cost, salvageValue, lifeYearsLeft);

        Asset parsedAsset = metricsPanel.createAsset();

        assertThat(parsedAsset.getName(), is(equalTo(name)));
        assertThat(parsedAsset.getCost(), is(equalTo(cost)));
        assertThat(parsedAsset.getSalvageValue(), is(equalTo(salvageValue)));
        assertThat(parsedAsset.getLifeYearsLeft(), is(equalTo(lifeYearsLeft)));
    }

    @Test
    public void testCreateAssetFromFieldsWithInvalidDataForCost() throws Exception {
        metricsPanel.getAssetNameTF().setText(name);
        metricsPanel.getAssetCostTF().setText("Not a number");
        metricsPanel.getAssetSalvageValueTF().setText(String.valueOf(salvageValue));
        metricsPanel.getAssetLifeYearsTF().setText(String.valueOf(lifeYearsLeft));

        Asset parsedAsset = metricsPanel.createAsset();
    }

    private void setTextFieldsOnView(String name, double cost, double salvageValue, int lifeYearsLeft) {
        metricsPanel.getAssetNameTF().setText(name);
        metricsPanel.getAssetCostTF().setText(String.valueOf(cost));
        metricsPanel.getAssetSalvageValueTF().setText(String.valueOf(salvageValue));
        metricsPanel.getAssetLifeYearsTF().setText(String.valueOf(lifeYearsLeft));
    }
}
