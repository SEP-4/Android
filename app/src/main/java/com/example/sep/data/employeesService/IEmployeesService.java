package com.example.sep.data.employeesService;

import com.example.sep.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IEmployeesService {
    @GET("api/v2/employees/{name}")
    Call<List<Employee>> getEmployeesByName(@Path("name") String name);
    //@POST("api/v2/employees/{employee}")
    //Call addEmployee(@Path("employee")Employee employee);

}
