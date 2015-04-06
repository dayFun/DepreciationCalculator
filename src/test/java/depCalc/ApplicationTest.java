package depCalc;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import depCalc.presenter.Presenter;
import depCalc.view.DepCalcView;


public class ApplicationTest {

    @Mock
    private DepCalcView view;
    @Mock
    private Presenter presenter;

    private Application app;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        app = new Application();
    }

}
