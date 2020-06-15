package com.e.dummyrestapi.API;

import com.e.dummyrestapi.response.EmployeeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeAPI {

    @GET("employees")
    Call<EmployeeResponse> getAllEmployee();

}
