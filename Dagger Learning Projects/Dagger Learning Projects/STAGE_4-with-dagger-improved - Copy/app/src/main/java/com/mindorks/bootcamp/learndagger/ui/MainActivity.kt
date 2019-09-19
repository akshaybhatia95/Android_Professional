package com.mindorks.bootcamp.learndagger.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.R
import com.mindorks.bootcamp.learndagger.di.component.DaggerActivityComponent
import com.mindorks.bootcamp.learndagger.di.module.ActivityModule
import javax.inject.Inject

class MainActivity : AppCompatActivity(){
    @Inject
    lateinit var viewModel : MainViewModel

    private var tvData:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)

        tvData=findViewById(R.id.tvData)
        tvData?.setText(viewModel.someData)
    }

    fun getDependencies(): Unit {
        DaggerActivityComponent
                .builder()
                .applicationComponent((applicationContext as MyApplication).applicationComponent)
                .activityModule(ActivityModule(this))
                .build()
                .inject(this)
    }

}