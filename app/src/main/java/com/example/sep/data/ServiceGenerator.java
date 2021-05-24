package com.example.sep.data;
import android.security.NetworkSecurityPolicy;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.sep.data.gymService.IGymService;
import com.example.sep.data.measurementService.IMeasurementService;
import com.example.sep.data.remoteControllerService.IRemoteControllerService;

public class ServiceGenerator {
    private static IGymService gymService;
    private static IMeasurementService measurementService;
    private static IRemoteControllerService remoteControllerService;

    public static IGymService getGymsService() {
        if (gymService == null) {
            gymService = new Retrofit.Builder()
                    .baseUrl("http://sep4webservice-prod.us-east-1.elasticbeanstalk.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(IGymService.class);
        }
        return gymService;
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

    public static IRemoteControllerService getRemoteControllerService() {
        if (remoteControllerService == null) {
            remoteControllerService = new Retrofit.Builder()
                    .baseUrl("http://sep4webservice-prod.us-east-1.elasticbeanstalk.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(IRemoteControllerService.class);

        }
        return remoteControllerService;
    }

}

