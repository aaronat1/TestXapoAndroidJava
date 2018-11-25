package com.aaronat1.desarrollo.githubtrending.main;

public class MainInteractorImpl implements MainInteractor {

    private MainRepository mainRepository;

    public MainInteractorImpl(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @Override
    public void getTrendingRepositories() {
        mainRepository.getTrendingRepositories();
    }


}
