package com.aaronat1.desarrollo.githubtrending.presenter;

import com.aaronat1.desarrollo.githubtrending.BaseTest;
import com.aaronat1.desarrollo.githubtrending.main.MainInteractor;
import com.aaronat1.desarrollo.githubtrending.main.MainPresenterImpl;
import com.aaronat1.desarrollo.githubtrending.main.ui.MainView;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static junit.framework.TestCase.assertNotNull;

public class MainPresenterImplTest extends BaseTest {

    @Mock
    private MainView mainView;

    @Mock
    private MainInteractor mainInteractor;

    private MainPresenterImpl mainPresenter;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mainPresenter = new MainPresenterImpl(mainView, mainInteractor);
    }

    @Test
    public void testOnGetTrendingRepositories() throws Exception {
        mainPresenter.getTrendingRepositories();
        assertNotNull(mainView);
        verify(mainView).showLoadingView();
        verify(mainInteractor).getTrendingRepositories();
    }

}
