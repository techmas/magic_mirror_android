package ru.techmas.magicmirror.presenters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import ru.techmas.magicmirror.activities.MainActivity;
import ru.techmas.magicmirror.api.RestApi;
import ru.techmas.magicmirror.interfaces.views.SplashView;
import ru.techmas.magicmirror.interfaces.views.SplashView$$State;
import ru.techmas.magicmirror.utils.presenter.PreferenceHelper;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Date: 04.06.2017
 * Time: 15:00
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
@RunWith(RobolectricTestRunner.class)
public class SplashPresenterTest {
    @Mock
    SplashView splashView;
    @Mock
    SplashView$$State splashViewState;
    @Mock
    RestApi restApi;
    @Mock
    PreferenceHelper preferenceHelper;

    private SplashPresenter splashPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        splashPresenter = new SplashPresenter(restApi, preferenceHelper);
        splashPresenter.attachView(splashView);
        splashPresenter.setViewState(splashViewState);
    }

    @Test
    public void startNextTest() {
        when(preferenceHelper.isFirstRun()).thenReturn(true);
        splashPresenter.startNext();
        verify(splashViewState).showErrorConnection(false);
        verify(splashViewState).startActivity(MainActivity.class);
        // TODO: 12.06.2017  
    }

}
