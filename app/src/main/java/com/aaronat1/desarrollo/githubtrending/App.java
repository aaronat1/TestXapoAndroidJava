package com.aaronat1.desarrollo.githubtrending;

import android.app.Application;

import com.aaronat1.desarrollo.githubtrending.main.ui.MainView;
import com.aaronat1.desarrollo.githubtrending.main.di.DaggerMainComponent;
import com.aaronat1.desarrollo.githubtrending.main.di.MainComponent;
import com.aaronat1.desarrollo.githubtrending.main.di.MainModule;

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public MainComponent getMainComponent(MainView mainView) {
        return DaggerMainComponent.builder().mainModule(new MainModule(mainView)).build();
    }

}
