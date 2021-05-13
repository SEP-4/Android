package com.example.sep.data.gymService;

import com.example.sep.model.Employee;
import com.example.sep.model.Gym;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IGymService {
    @GET("gym")
    Call<GymResponse> getGymsByEmail(@Query("email") String email);


    //@POST("api/v2/employees/{employee}")
    //Call addEmployee(@Path("employee")Employee employee);

}
