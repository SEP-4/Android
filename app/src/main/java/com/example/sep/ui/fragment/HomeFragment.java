package com.example.sep.ui.fragment;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.sep.R;
import com.example.sep.model.AC;
import com.example.sep.viewmodel.HomeViewModel;
import com.example.sep.viewmodel.RemoteControllerViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RemoteControllerViewModel remoteControllerViewModel;
    private TextView tmpLevelTextView, co2LevelTextView, humidityLevelTextView;
    private TextView tmpDetailsTextView, co2DetailsTextView, humidityDetailsTextView;
    private Button btnTemperature, btnHumidity, btnCO2;
    private Switch ACSwitch, WindowsSwitch, HumidifierSwitch;
    private NavController navController;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        remoteControllerViewModel = new ViewModelProvider(this).get(RemoteControllerViewModel.class);

        tmpLevelTextView = root.findViewById(R.id.temperatureLevel_textView);
        co2LevelTextView = root.findViewById(R.id.co2Level_textView);
        humidityLevelTextView = root.findViewById(R.id.humidityLevel_textView);
        tmpDetailsTextView = root.findViewById(R.id.tmpDetailsDescriptionTextView);
        co2DetailsTextView = root.findViewById(R.id.co2DetailsDescriptionTextView);
        humidityDetailsTextView = root.findViewById(R.id.humidityDetailsDescriptionTextView);

        ACSwitch = root.findViewById(R.id.tmpAutomationSwitch);
        WindowsSwitch = root.findViewById(R.id.CO2AutomationSwitch);
        HumidifierSwitch = root.findViewById(R.id.humidityAutomationSwitch);


        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.retrieveLastTemperature();



        homeViewModel.getLastTemperature().observe(this.getViewLifecycleOwner(), measurement -> {
            tmpLevelTextView.setText(measurement.getTemperature() + "C°");
            co2LevelTextView.setText(measurement.getcO2Level() + "ppm");
            humidityLevelTextView.setText(measurement.getHumidity() + "%");
            tmpDetailsTextView.setText("20-22C°");
            co2DetailsTextView.setText("400 - 1000ppm");
            humidityDetailsTextView.setText("40-60%");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("My notification", "My notification", NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }

            if (measurement.getTemperature() < 20 || measurement.getTemperature() > 22){
                tmpLevelTextView.setTextColor(Color.RED);
                tmpDetailsTextView.setTextColor(Color.RED);

                String temperatureStatus = null;
                if (measurement.getTemperature() < 20)
                    temperatureStatus = "low";
                else if (measurement.getTemperature() > 22)
                    temperatureStatus = "high";

                sendNotification("Temperature warning!", "The room temperature is too " + temperatureStatus + ".");
            }
            if (measurement.getcO2Level() > 1000 ) {
                co2LevelTextView.setTextColor(Color.RED);
                co2DetailsTextView.setTextColor(Color.RED);

                sendNotification("CO2 level warning!","The CO2 level is too low.");
            }
            if(measurement.getHumidity()> 60 || measurement.getHumidity() < 40 ){
                humidityLevelTextView.setTextColor(Color.RED);
                humidityDetailsTextView.setTextColor(Color.RED);

                String humidityStatus = null;
                if (measurement.getTemperature() > 60)
                    humidityStatus = "high";
                else if (measurement.getTemperature() < 40)
                    humidityStatus = "low";

                sendNotification("Humidity percentage warning!","The humidity percentage is too " + humidityStatus + ".");
            }

            remoteControllerViewModel.retrieveLastState();
            remoteControllerViewModel.getACState().observe(this.getViewLifecycleOwner(), new Observer<AC>() {
                @Override
                public void onChanged(AC ac) {
                    if(ac.getAutomation() == 1){
                        ACSwitch.setChecked(true);
                    }
                    else {
                        ACSwitch.setChecked(false);
                    }
                }
            });

            remoteControllerViewModel.retrieveLastStateWindow();
            remoteControllerViewModel.getWindowState().observe(this.getViewLifecycleOwner(), window -> {


                if (window.getAutomation() == 1){
                    WindowsSwitch.setChecked(true);

                }
                else {
                    WindowsSwitch.setChecked(false);
                }
            });

            remoteControllerViewModel.retrieveLastStateHumidifier();
            remoteControllerViewModel.getHumidifierState().observe(this.getViewLifecycleOwner(), humidifier -> {

                HumidifierSwitch.setChecked(humidifier.getAutomation() == 1);
            });


            ACSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        remoteControllerViewModel.turnOnAutomationAC();
                        Toast.makeText(getContext(), "Automation is on!", Toast.LENGTH_SHORT).show();

                        if(measurement.getTemperature() > 22){
                            remoteControllerViewModel.turnOnAC();
                            Toast.makeText(getContext(), "AC is turned on!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(measurement.getTemperature()< 20) {
                        remoteControllerViewModel.turnOffAC();
                        Toast.makeText(getContext(), "AC is turned off!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        remoteControllerViewModel.turnOffAutomationAC();
                        Toast.makeText(getContext(), "Automation is off!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            HumidifierSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        remoteControllerViewModel.turnOnAutomationHumidifier();
                        Toast.makeText(getContext(), "Automation is on!", Toast.LENGTH_SHORT).show();
                        if(measurement.getHumidity() < 40 ){
                            remoteControllerViewModel.turnOnHumidifier();
                            Toast.makeText(getContext(), "Humidifier is on!", Toast.LENGTH_SHORT).show();
                        }else if(measurement.getHumidity()> 60) {

                            remoteControllerViewModel.turnOffHumidifier();
                            Toast.makeText(getContext(), "Humidifier is off!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        remoteControllerViewModel.turnOffAutomationHumidifier();
                        Toast.makeText(getContext(), "Automation is off", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            WindowsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        remoteControllerViewModel.openWindowAutomation();
                        Toast.makeText(getContext(), "Automation is on!", Toast.LENGTH_SHORT).show();
                        if(measurement.getcO2Level() > 1000){
                            remoteControllerViewModel.openWindow();
                            Toast.makeText(getContext(), "Window is open!", Toast.LENGTH_SHORT).show();

                        }else if(measurement.getcO2Level() < 1000) {
                            remoteControllerViewModel.closeWindow();
                            Toast.makeText(getContext(), "Windows are closed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        remoteControllerViewModel.closeWindowAutomation();
                        Toast.makeText(getContext(), "Automation is off!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        });


        return root;
    }


    private void sendNotification(String title, String text) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.getActivity(), "My notification")
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this.getActivity());
        notificationManager.notify(12, builder.build());
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        btnCO2 = view.findViewById(R.id.detailsCO2);
        btnHumidity = view.findViewById(R.id.detailsHumidity);
        btnTemperature = view.findViewById(R.id.detailsTemperature);

        btnCO2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_home_to_nav_slideshow);
            }
        });

        btnHumidity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_home_to_nav_humidity);
            }
        });


        btnTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_home_to_nav_gallery);
            }
        });
    }
}