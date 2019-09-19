package com.mindorks.bootcamp.learndagger.di.module;

import android.app.Activity;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.scope.ActivityScope;
import com.mindorks.bootcamp.learndagger.ui.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    MainViewModel provideMainViewModel(DatabaseService databaseService,
                                       NetworkService networkService) {
        return new MainViewModel(databaseService, networkService);
    }
}
