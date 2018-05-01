package com.bigmeco.checksite

import io.reactivex.Observable
import retrofit2.http.GET

interface StatysSIte {
        @GET("")
    fun getSatys(): Observable<String>
}