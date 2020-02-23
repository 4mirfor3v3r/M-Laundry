package com.amier.laundry.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkConfig {

    private fun getInterceptor():OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okhttp = OkHttpClient.Builder().addInterceptor(interceptor)
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()

        return okhttp
    }
    private fun getNetwork():Retrofit{
        return Retrofit.Builder().baseUrl(Coonstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getInterceptor())
            .build()
    }
    fun api():APIService{
        return getNetwork().create(APIService::class.java)
    }
}