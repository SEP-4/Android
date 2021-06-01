package com.example.sep.data.gymService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IGymService {
    @GET("gym")
    Call<GymResponse> getGymsByEmail(@Query("email") String email);


    //@POST("api/v2/employees/{employee}")
    //Call addEmployee(@Path("employee")Employee employee);

}
