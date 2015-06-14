package depCalc.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import depCalc.view.DepMetricsPanel;

public class AssetMetricsInputVerifierTest2 {

    private DepMetricsPanel depMetricsPanel;
    private AssetMetricsInputerVerifier verifier;

    @Before
    public void setup() {
        depMetricsPanel = new DepMetricsPanel();
        verifier = new AssetMetricsInputerVerifier(depMetricsPanel);
    }

    @Test
    public void testVerifyWithValidInputForCostReturnsTrue() throws Exception {
        depMetricsPanel.getAssetCostTF().setText("5");

        assertTrue(verifier.shouldYieldFocus(depMetricsPanel));

    }
}
