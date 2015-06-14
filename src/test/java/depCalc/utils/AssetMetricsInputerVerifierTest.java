package depCalc.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.awt.Component;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import depCalc.view.DepMetricsPanel;


public class AssetMetricsInputerVerifierTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private DepMetricsPanel depMetricsPanel;
    @Mock
    private JTextField cost;
    @Mock
    private JTextField salvage;
    @Mock
    private JTextField life;

    private AssetMetricsInputerVerifier verifier;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(depMetricsPanel.getAssetCostTF()).thenReturn(cost);
        when(depMetricsPanel.getAssetSalvageValueTF()).thenReturn(salvage);
        when(depMetricsPanel.getAssetLifeYearsTF()).thenReturn(life);

        verifier = new AssetMetricsInputerVerifier(depMetricsPanel);

        when(cost.getName()).thenReturn("JTF Cost");
        when(life.getName()).thenReturn("JTF Life");

    }

    @Test
    public void testVerifyWithValidInputForCostReturnsTrue() throws Exception {
        when(cost.getText()).thenReturn("50000.99");

        assertTrue(verifier.verify(depMetricsPanel));
    }

    @Test
    public void testVerifyWithInvalidInputForCostReturnsFalse() throws Exception {
        when(cost.getText()).thenReturn("Not a Number");
        when(depMetricsPanel.getComponents()).thenReturn(new Component[] {cost});

        assertFalse(verifier.verify(depMetricsPanel));
    }

    @Test
    public void testVerifyWithValidInputForLifeYearsReturnsTrue() throws Exception {
        when(life.getText()).thenReturn("5");
        when(depMetricsPanel.getComponents()).thenReturn(new Component[] {life});

        assertTrue(verifier.verify(depMetricsPanel));
    }

    @Test
    public void testVerifyWithInvalidInputForLifeYearsReturnsFalse() throws Exception {
        when(life.getText()).thenReturn("Not a Number");
        when(depMetricsPanel.getComponents()).thenReturn(new Component[] {life});

        assertFalse(verifier.verify(depMetricsPanel));
    }
}
