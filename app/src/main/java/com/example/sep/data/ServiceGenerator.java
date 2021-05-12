package com.example.sep.data;
import android.security.NetworkSecurityPolicy;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.sep.data.employeesService.IEmployeesService;
import com.example.sep.data.measurementService.IMeasurementService;

public class ServiceGenerator {
    private static IEmployeesService employeesService;
    private static IMeasurementService measurementService;

    public static IEmployeesService getEmployeesService() {
        if (employeesService == null) {
            employeesService = new Retrofit.Builder()
                    .baseUrl("https://employees.co")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(IEmployeesService.class);
        }
        return employeesService;
    }

    public static IMeasurementService getMeasurementService() {
        if (measurementService == null) {
            measurementService = new Retrofit.Builder()
                    .baseUrl("http://sep4webservice-prod.us-east-1.elasticbeanstalk.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(IMeasurementService.class);

        }
        System.out.println("tmpService: " + measurementService);
        System.out.println("Network" + NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted());
        return measurementService;
    }

}

