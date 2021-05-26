package com.example.sep.ui.fragment;

import android.graphics.Color;
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

            tmpLevelTextView.setText(String.valueOf(measurement.getTemperature() + "C°"));
            co2LevelTextView.setText(String.valueOf(measurement.getcO2Level() + "ppm"));
            humidityLevelTextView.setText(String.valueOf(measurement.getHumidity() + "%"));
            tmpDetailsTextView.setText("20-22C°");
            co2DetailsTextView.setText("400 - 1000ppm");
            humidityDetailsTextView.setText("40-60%");

            if(measurement.getTemperature()< 20 || measurement.getTemperature() > 22 ){
                tmpLevelTextView.setTextColor(Color.RED);
                tmpDetailsTextView.setTextColor(Color.RED);
            }
            if(measurement.getcO2Level() > 1000 ){
                co2LevelTextView.setTextColor(Color.RED);
                co2DetailsTextView.setTextColor(Color.RED);
            }
            if(measurement.getHumidity()> 60 || measurement.getHumidity() < 40 ){
                humidityLevelTextView.setTextColor(Color.RED);
                humidityDetailsTextView.setTextColor(Color.RED);
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



            /*String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            //String date = simpleDateFormat.format(temperature.getDate());
            tmpTextView.setText(String.valueOf(temperature.getTime()));
            System.out.println("tmppp:" + temperature.toString());

            System.out.println();*/
        });


        return root;
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