package com.bigmeco.checksite

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Service {
    fun getSite(url:String): StatysSIte {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                        RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build()

        return retrofit.create(StatysSIte::class.java)
    }
}