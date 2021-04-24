package com.mvvm.data.employeesService;

import com.mvvm.model.Employee;
import com.mvvm.model.Temperature;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IEmployeesService {
    @GET("api/v2/employees/{name}")
    Call<List<Employee>> getEmployeesByName(@Path("name") String name);
    //@POST("api/v2/employees/{employee}")
    //Call addEmployee(@Path("employee")Employee employee);

}
