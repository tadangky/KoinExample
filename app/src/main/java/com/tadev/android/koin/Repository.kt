package com.tadev.android.koin

import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call

class Repository(private val api: ApiService) {
    suspend fun login(url: String, accountLoginRequest: AccountLoginRequest): Call<AccountLoginResponse> {
        return api.login(url, accountLoginRequest)
    }

    suspend fun getTodos(): List<TodosResponse> {
        return api.listTodos()
    }

    suspend fun postPosts(): ResponseBody {
        return api.postPosts()
    }

    suspend fun getPosts(): List<PostsResponse> {
        return api.getPosts()
    }

    suspend fun getComments(): List<CommentsResponse> {
        return api.commentsByPostId(2)
    }

    suspend fun getCurrent(): WeatherDataResponse {
        return api.current("af15034261efe7815feeaaaef822015e", "New York")
    }
}
