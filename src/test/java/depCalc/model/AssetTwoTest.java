package depCalc.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class AssetTwoTest {
    private AssetTwo asset;

    @Before
    public void setup() {
        asset = new AssetTwo("Truck", 30000, 5000, 5);
    }

    @Test
    public void testStraightLineGetAnnualDepreciation() throws Exception {
        assertThat(asset.getAnnualDepreciation(), is(equalTo(5000.0)));
    }

    @Test
    public void testStraightLineGetAnnualDepreciationAtYear3() throws Exception {
        assertThat(asset.getAnnualDepreciation(3, 'S'), is(equalTo(5000.0)));
    }

    @Test
    public void testGetBeginningBalanceAtTwoYearsWithStraightLine() throws Exception {
        assertThat(asset.getBeginningBalance(2, 'S'), is(equalTo(25000.0)));
    }

    @Test
    public void testGetEndingBalanceAtTwoYearsWithStraightLine() throws Exception {
        assertThat(asset.getEndingBalance(2, 'S'), is(equalTo(20000.0)));
    }

    @Test
    public void testDoubleDeclineDepForOneYear() throws Exception {
        assertThat(asset.getAnnualDepreciation(1, 'D'), is(equalTo(12000.0)));
    }

    @Test
    public void testGetBeginningBalanceAtTwoYearsWithDoubleDecline() throws Exception {
        assertThat(asset.getBeginningBalance(2, 'D'), is(equalTo(18000.0)));
    }

    @Test
    public void testGetEndingBalanceAtTwoYearsWithDoubleDecline() throws Exception {
        assertThat(asset.getEndingBalance(2, 'D'), is(equalTo(10800.0)));
    }

    @Test
    public void testWhenDoubleDeclineRateIsLowerThanStraightLineThenUseStraightLineDepreciation() throws Exception {
        assertThat(asset.getBeginningBalance(3, 'D'), is(equalTo(10800.0)));
        assertThat(asset.getAnnualDepreciation(3, 'D'), is(equalTo(5000.0)));
    }



}
