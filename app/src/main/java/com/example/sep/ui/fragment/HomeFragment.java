package com.example.sep.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sep.R;
import com.example.sep.viewmodel.HomeViewModel;
public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView tmpLevelTextView, co2LevelTextView, humidityLevelTextView;
    private TextView tmpDetailsTextView, co2DetailsTextView, humidityDetailsTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        tmpLevelTextView = root.findViewById(R.id.temperatureLevel_textView);
        co2LevelTextView = root.findViewById(R.id.co2Level_textView);
        humidityLevelTextView = root.findViewById(R.id.humidityLevel_textView);
        tmpDetailsTextView = root.findViewById(R.id.tmpDetailsDescriptionTextView);
        co2DetailsTextView = root.findViewById(R.id.co2DetailsDescriptionTextView);
        humidityDetailsTextView = root.findViewById(R.id.humidityDetailsDescriptionTextView);


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
            if(measurement.getTemperature()> 60 || measurement.getTemperature() < 40 ){
                humidityLevelTextView.setTextColor(Color.RED);
                humidityDetailsTextView.setTextColor(Color.RED);
            }

            /*String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            //String date = simpleDateFormat.format(temperature.getDate());
            tmpTextView.setText(String.valueOf(temperature.getTime()));
            System.out.println("tmppp:" + temperature.toString());

            System.out.println();*/
        });


        return root;
    }


}