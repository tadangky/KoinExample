package com.tadev.android.koin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    val todoList = MutableLiveData<List<TodosResponse>>()

    fun getTodos() {
        //https://jsonplaceholder.typicode.com
        Log.e("TATA", "MainViewModel login")

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = repository.getTodos()
                    Log.e("TATA", "MainViewModel getTodos result: $result")
                    todoList.postValue(result)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }

    }

    fun comments() {
        //https://jsonplaceholder.typicode.com
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
//                    val result = repository.login(AccountLoginRequest())
//                    val result = repository.login()
//                    val result = repository.getCurrent()
                    val result = repository.getComments()

                    Log.e("TATA", "MainViewModel comments: $result")
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }

    fun posts() {
        //https://jsonplaceholder.typicode.com
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
//                    val result = repository.getPosts()
                    val result = repository.postPosts()

                    val json = JSONObject(result.string())
                    Log.e("TATA", "MainViewModel posts posts: ${json}")
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }

    fun login() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
//                    val result = repository.getPosts()
                    val result = repository.login("http://abcxyz.com/api/login-customer", AccountLoginRequest("0777389889", "123456780"))

//                    val json = JSONObject(result.string())
                    result.enqueue(object : retrofit2.Callback<AccountLoginResponse> {
                        override fun onFailure(call: Call<AccountLoginResponse>, t: Throwable) {
                            Log.e("TATA", "onFailure")
                        }

                        override fun onResponse(
                            call: Call<AccountLoginResponse>,
                            response: Response<AccountLoginResponse>
                        ) {

                            Log.e("TATA", "onResponse code: ${response.code()}")

                            if (response.body() is AccountLoginResponse) {
                                Log.e("TATA", "onResponse: ${response.body()}")
                            } else {
                                Log.e("TATA", "onResponse: ${response.message()}")
                                Log.e("TATA", "onResponse: ${response.errorBody()?.string()}")
                                response.errorBody()?.let {
//                                    val json = JSONObject(it.string())
//                                    Log.e("TATA", "onResponse json: ${json}")
                                }

                            }

                        }
                    })

//                    Log.e("TATA", "MainViewModel posts posts: ${result}")
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }
}
