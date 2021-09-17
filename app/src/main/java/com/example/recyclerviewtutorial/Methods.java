package com.example.recyclerviewtutorial;

import com.example.recyclerviewtutorial.pojo.DashboardPojo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {

    @GET("getbusiness_services")
    Call<DashboardPojo> getAllresultdata();

}
