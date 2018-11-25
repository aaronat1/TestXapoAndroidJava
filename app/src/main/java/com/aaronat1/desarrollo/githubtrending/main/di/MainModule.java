package com.aaronat1.desarrollo.githubtrending.main.di;


import com.aaronat1.desarrollo.githubtrending.entities.TrendingRepository;
import com.aaronat1.desarrollo.githubtrending.main.MainInteractor;
import com.aaronat1.desarrollo.githubtrending.main.MainInteractorImpl;
import com.aaronat1.desarrollo.githubtrending.main.MainPresenter;
import com.aaronat1.desarrollo.githubtrending.main.MainPresenterImpl;
import com.aaronat1.desarrollo.githubtrending.main.MainRepository;
import com.aaronat1.desarrollo.githubtrending.main.MainRepositoryImpl;
import com.aaronat1.desarrollo.githubtrending.main.ui.MainView;
import com.aaronat1.desarrollo.githubtrending.main.ui.adapters.RepositoriesAdapter;

import java.util.List;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    MainView mainView;

    public MainModule(MainView mainView){
        this.mainView = mainView;
    }

    @Provides @Singleton
    MainView providesMainView() {
        return this.mainView;
    }

    @Provides @Singleton
    MainPresenter providesMainPresenter(MainView mainView, MainInteractor mainInteractor) {
        return new MainPresenterImpl(mainView, mainInteractor);
    }

    @Provides @Singleton
    MainInteractor providesMainInteractor(MainRepository mainRepository) {
        return new MainInteractorImpl(mainRepository);
    }

    @Provides @Singleton
    MainRepository providesMainRepository() {
        return new MainRepositoryImpl();
    }

}
