package com.mindorks.bootcamp.learndagger.di.module;

import android.content.Context;

import androidx.fragment.app.Fragment;
import dagger.Module;

@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    Context provideContext(){
        return fragment.getContext();
    }
}
