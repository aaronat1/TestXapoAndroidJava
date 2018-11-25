package com.aaronat1.desarrollo.githubtrending.interactor;

import com.aaronat1.desarrollo.githubtrending.BaseTest;
import com.aaronat1.desarrollo.githubtrending.main.MainInteractorImpl;
import com.aaronat1.desarrollo.githubtrending.main.MainRepository;

import org.junit.Test;
import org.mockito.Mock;


import static org.mockito.Mockito.verify;

public class MainInteractyorImplTest extends BaseTest {

    @Mock
    private MainRepository mainRepository;
    private MainInteractorImpl mainInteractor;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mainInteractor = new MainInteractorImpl(mainRepository);
    }

    @Test
    public void doTestExecuteCallRepository() throws Exception {
        mainInteractor.getTrendingRepositories();
        verify(mainRepository).getTrendingRepositories();
    }


}
