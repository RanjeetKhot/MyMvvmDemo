package com.example.kotlinpeople.API

import com.example.kotlinpeople.other.QuotesResponse
import com.example.kotlinpeople.ui.fragment.loginFragment.AuthResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @GET("posts")
    suspend fun getQuotes(): Response<List<QuotesResponse>>

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthResponse>


    @FormUrlEncoded
    @POST("signup")
    suspend fun userSignup(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthResponse>

    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): MyApi {

            val incept = HttpLoggingInterceptor()
            incept.setLevel(HttpLoggingInterceptor.Level.HEADERS)
            incept.setLevel(HttpLoggingInterceptor.Level.BODY)

//            val client=OkHttpClient()
//            client.interceptors().add(incept)

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .addInterceptor(incept)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }


}

