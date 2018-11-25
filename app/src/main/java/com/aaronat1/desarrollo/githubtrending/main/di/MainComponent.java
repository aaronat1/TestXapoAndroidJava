package com.aaronat1.desarrollo.githubtrending.main.di;

import com.aaronat1.desarrollo.githubtrending.main.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
