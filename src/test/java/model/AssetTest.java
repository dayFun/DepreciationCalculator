package model;

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
    public void testStraightLineGetAnnualDep() throws Exception {
        assertThat(asset.getAnnualDep(), is(equalTo(5000.0)));
    }

    @Test
    public void testDoubleDeclineDepForOneYear() throws Exception {
        assertThat(asset.getAnnualDep(1), is(equalTo(12000.0)));
    }

    @Test
    public void testWhenDoubleDeclineDepIsLowerThanStraightLineThenUseStraightLineDep() throws Exception {
        assertThat(asset.getAnnualDep(3), is(equalTo(5000.0)));
    }

    @Test
    public void testWhenDoubleDeclineDepEndValueIsEqualToSalvageValueThenDepIsZero() throws Exception {
        assertThat(asset.getAnnualDep(5), is(equalTo(0.0)));
    }

    @Test
    public void testGetBeginningBalanceAtTwoYearsWithStraightLine() throws Exception {
        assertThat(asset.getBeginningBalance(2, 'S'), is(equalTo(25000.0)));
    }

    @Test
    public void testGetBeginningBalanceAtFiveYearsWithStraightLine() throws Exception {
        assertThat(asset.getBeginningBalance(5, 'S'), is(equalTo(10000.0)));
    }

    @Test
    public void testGetBeginningBalanceAtTwoYearsWithDoubleDeclineDep() throws Exception {
        assertThat(asset.getBeginningBalance(2, 'D'), is(equalTo(18000.0)));
    }

    @Test
    public void testGetBeginningBalanceAtFiveYearsWithDoubleDeclineDep() throws Exception {
        assertThat(asset.getBeginningBalance(5, 'D'), is(equalTo(5000.0)));
    }
}
