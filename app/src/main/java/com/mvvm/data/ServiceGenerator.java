package com.mvvm.data;
import android.annotation.SuppressLint;
import android.security.NetworkSecurityPolicy;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.mvvm.data.employeesService.IEmployeesService;
import com.mvvm.data.temperatureService.ITemperatureService;

import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ServiceGenerator {
    private static IEmployeesService employeesService;
    private static ITemperatureService temperatureService;

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
    public static ITemperatureService getTemperatureService() {
        if (temperatureService == null) {
            temperatureService = new Retrofit.Builder()
                    .baseUrl("https://sep4webservice-prod.us-east-1.elasticbeanstalk.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ITemperatureService.class);

        }
        System.out.println("tmpService: " + temperatureService);
        System.out.println("Network" + NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted());
        return temperatureService;
    }

    public static OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

