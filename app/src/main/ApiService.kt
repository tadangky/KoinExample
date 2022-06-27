package com.tadev.android.koin

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST
    fun login(@Url url: String, @Body accountLoginRequest: AccountLoginRequest): Call<AccountLoginResponse>

    @GET("comments")
    suspend fun commentsByPostId(@Query("postId") postId: Int): List<CommentsResponse>

    @GET("todos")
    suspend fun listTodos(): List<TodosResponse>

    @POST("posts")
    suspend fun postPosts(): ResponseBody

    @GET("posts")
    suspend fun getPosts(): List<PostsResponse>

    @GET("current")
    suspend fun current(
        @Query("access_key") access_key: String,
        @Query("query") query: String
    ): WeatherDataResponse

}

data class AccountLoginRequest(
    @SerializedName("phone") var phone: String = "",
    @SerializedName("password") var password: String = "",
)

data class AccountLoginResponse(
    @SerializedName("status") var status: String = "",
    @SerializedName("data") var data: Data,
)

data class Data(
    @SerializedName("token") var token: Token,
    @SerializedName("slot_socket_name") var slotSocketName: String = "",
    @SerializedName("slot_page_type") var slotSocketType: String = "",
)

data class Token(
    @SerializedName("access_token") var accessToken: String = "",
    @SerializedName("refresh_token") var refreshToken: String = "",
)


data class TodosResponse(
    @SerializedName("id") val id : Int,
    @SerializedName("userId") val userId : Int,
    @SerializedName("title") val title : String,
    @SerializedName("completed") val completed : Boolean
)

data class CommentsResponse(
    @SerializedName("postId") val postId : Int,
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("email") val email : String,
    @SerializedName("body") val body : Boolean
)

data class PostsResponse(
    @SerializedName("id") val id : Int,
    @SerializedName("userId") val userId : Int,
    @SerializedName("title") val title : String,
    @SerializedName("body") val body : String
)
