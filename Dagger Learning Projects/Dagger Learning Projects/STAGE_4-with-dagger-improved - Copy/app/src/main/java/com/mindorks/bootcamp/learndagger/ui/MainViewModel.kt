package com.mindorks.bootcamp.learndagger.ui

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import javax.inject.Inject

class MainViewModel @Inject constructor(val databaseService: DatabaseService,val networkService: NetworkService){
    fun getSomeData():String{
        return databaseService.dummyData+" "+networkService.dummyData
    }
}