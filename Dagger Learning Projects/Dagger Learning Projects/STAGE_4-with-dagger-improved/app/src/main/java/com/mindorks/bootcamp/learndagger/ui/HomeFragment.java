package com.mindorks.bootcamp.learndagger.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.R;
import com.mindorks.bootcamp.learndagger.di.component.DaggerFragmentComponent;
import com.mindorks.bootcamp.learndagger.di.module.FragmentModule;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {


    public static final String TAG="HomeFragment";
    @Inject
    HomeViewModel homeViewModel;

    public static HomeFragment newInstance(){
        Bundle args=new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDependencies();
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    private void getDependencies() {
      DaggerFragmentComponent
                .builder()
                .applicationComponent(((MyApplication) getContext().getApplicationContext()).applicationComponent)
                .fragmentModule(new FragmentModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvMessage = view.findViewById(R.id.tv_message);
        tvMessage.setText(homeViewModel.getSomeData());
    }
}
