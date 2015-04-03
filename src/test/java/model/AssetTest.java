package model;

import static org.junit.Assert.assertEquals;

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
        assertEquals(5000, asset.getAnnualDep(), 0.0001);
    }

    @Test
    public void testDoubleDeclineGetAnnualDepreciation() throws Exception {
        assertEquals(12000, asset.getAnnualDep(5), 0.0001);
    }
}
