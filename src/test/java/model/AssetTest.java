package model;

import org.junit.Test;

public class AssetTest {

    private Asset asset;

    @Test
    public void testStraightLineGetAnnualDepreciation() throws Exception {
        asset = new Asset("Truck", 30000, 5000, 5);

        assertThat(asset.getAnnualDep(), is(equalTo(5000)));

    }
}
