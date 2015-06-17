package depCalc.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class AssetTest {
    private Asset asset;

    @Before
    public void setup() {
        asset = new Asset("Truck", 30000, 5000, 5);
    }

    @Test
    public void testStraightLineGetAnnualDepreciation() throws Exception {
        assertThat(asset.getAnnualDepreciation(), is(equalTo(5000.0)));
    }

    @Test
    public void testStraightLineGetAnnualDepreciationAtYear3() throws Exception {
        assertThat(asset.getAnnualDepreciation(), is(equalTo(5000.0)));
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
        assertThat(asset.getAnnualDepreciation(1), is(equalTo(12000.0)));
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
        assertThat(asset.getAnnualDepreciation(3), is(equalTo(5000.0)));
    }

    @Test
    public void testDoubleDeclineDepreciationForFiveYears() throws Exception {
        assertThat(asset.getBeginningBalance(1, 'D'), is(equalTo(30000.0)));
        assertThat(asset.getAnnualDepreciation(1), is(equalTo(12000.0)));
        assertThat(asset.getEndingBalance(1, 'D'), is(equalTo(18000.0)));

        assertThat(asset.getBeginningBalance(2, 'D'), is(equalTo(18000.0)));
        assertThat(asset.getAnnualDepreciation(2), is(equalTo(7200.0)));
        assertThat(asset.getEndingBalance(2, 'D'), is(equalTo(10800.0)));

        assertThat(asset.getBeginningBalance(3, 'D'), is(equalTo(10800.0)));
        assertThat(asset.getAnnualDepreciation(3), is(equalTo(5000.0)));
        assertThat(asset.getEndingBalance(3, 'D'), is(equalTo(5800.0)));

        assertThat(asset.getBeginningBalance(4, 'D'), is(equalTo(5800.0)));
        assertThat(asset.getAnnualDepreciation(4), is(equalTo(800.0)));
        assertThat(asset.getEndingBalance(4, 'D'), is(equalTo(5000.0)));

        assertThat(asset.getBeginningBalance(5, 'D'), is(equalTo(5000.0)));
        assertThat(asset.getAnnualDepreciation(5), is(equalTo(0.0)));
        assertThat(asset.getEndingBalance(5, 'D'), is(equalTo(5000.0)));
    }



}
