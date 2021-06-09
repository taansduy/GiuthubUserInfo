package com.example.githubuserinfo.utils

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.githubuserinfo.base.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun <T:Any> CoroutineScope.perform(source: MutableLiveData<Resource<T>>, action: suspend () -> T){
    source.postValue(Resource.loading())
    launch(Dispatchers.IO) {
        val result: Resource<T> = try {
            Resource.success(action())
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, "Exception during perform $action", e)
            Resource.error(message = e.toString())
        }
        source.postValue(result)
    }
}