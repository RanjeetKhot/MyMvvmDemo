package com.example.kotlinpeople.API
import com.example.kotlinpeople.other.QuotesResponse
import com.example.kotlinpeople.other.RegistrationResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {

    @GET("posts")
    suspend fun getQuotes() : Response<List<QuotesResponse>>

    @GET("login")
    suspend fun getLogin() : Response<List<RegistrationResponse>>


    companion object{
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : MyApi{

            val incept=HttpLoggingInterceptor()
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

