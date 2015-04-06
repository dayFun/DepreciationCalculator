package depCalc.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import depCalc.view.DepCalcView;


public class PresenterTest {

    @Mock
    private DepCalcView view;

    private Presenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new Presenter(view);
    }

    @Test
    public void testHandleExitButtonClick() throws Exception {}
}
