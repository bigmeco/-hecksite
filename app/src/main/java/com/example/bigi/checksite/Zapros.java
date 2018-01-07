package com.example.bigi.checksite;

import android.database.Observable;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bigi on 07.01.2018.
 */

public interface Zapros {
    @GET("")
    Call<String> getLog();
}