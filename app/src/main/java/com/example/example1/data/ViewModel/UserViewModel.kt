package com.rick.workclass.ejemplo.com.example.example1.data.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import com.rick.workclass.ejemplo.com.example.example1.data.Network.RetrofitClient
import com.rick.workclass.ejemplo.com.example.example1.data.model.UserModel
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val api = RetrofitClient.api
    fun loginAPI(user_model:UserModel, onResult:(JsonObject?) -> Unit){
        viewModelScope.launch {
            try{
                val response = api.login(user_model)
                if (response.isSuccessful){
                    val jsonResponse = response.body()
                    Log.d("debug",response.body().toString())
                    onResult(jsonResponse)
                }
                else{
                    Log.d("debug","ERROR:${response.body()}")
                    onResult(null)
                }
            }catch (exception:Exception){
                Log.d("debug","API CALL FAILED:$exception")
                onResult(null)

            }

        }
    }
}