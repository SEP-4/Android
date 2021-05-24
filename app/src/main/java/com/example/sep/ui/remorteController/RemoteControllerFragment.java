package com.example.sep.ui.remorteController;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.sep.R;
import com.example.sep.model.AC;
import com.example.sep.viewmodel.RemoteControllerViewModel;

public class RemoteControllerFragment extends Fragment {

    private RemoteControllerViewModel mViewModel;
    private Switch ACSwitch, WindowsSwitch, HumidifierSwitch;

    public static RemoteControllerFragment newInstance() {
        return new RemoteControllerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         View root = inflater.inflate(R.layout.remote_controller_fragment, container, false);

         ACSwitch = root.findViewById(R.id.acSwitch);
         WindowsSwitch = root.findViewById(R.id.windowsSwitch);
         HumidifierSwitch = root.findViewById(R.id.humidifierSwitch);

         mViewModel = new ViewModelProvider(this).get(RemoteControllerViewModel.class);

         //--------AC--------
         mViewModel.retrieveLastState();
         mViewModel.getACState().observe(this.getViewLifecycleOwner(), ac -> {
             System.out.println("```````````" +ac.getState());

             if (ac.getState() == 1){
                 ACSwitch.setChecked(true);

             }
             else {
                 ACSwitch.setChecked(false);
             }
         });

         ACSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked){
                     mViewModel.turnOnAC();
                     Toast.makeText(getContext(), "AC is turned on!", Toast.LENGTH_SHORT).show();
                 }
                 else {
                     mViewModel.turnOffAC();
                     Toast.makeText(getContext(), "AC is turned off!", Toast.LENGTH_SHORT).show();
                 }
             }
         });

        //--------Window--------
        mViewModel.retrieveLastStateWindow();
        mViewModel.getWindowState().observe(this.getViewLifecycleOwner(), window -> {


            if (window.getState() == 1){
                WindowsSwitch.setChecked(true);

            }
            else {
                WindowsSwitch.setChecked(false);
            }
        });

        WindowsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mViewModel.openWindow();
                    Toast.makeText(getContext(), "Window is opened!", Toast.LENGTH_SHORT).show();
                }
                else {
                    mViewModel.closeWindow();
                    Toast.makeText(getContext(), "Window is closed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //--------Humidifier--------
        mViewModel.retrieveLastStateHumidifier();
        mViewModel.getHumidifierState().observe(this.getViewLifecycleOwner(), humidifier -> {

            if (humidifier.getState() == 1){
                HumidifierSwitch.setChecked(true);

            }
            else {
                HumidifierSwitch.setChecked(false);
            }
        });

        HumidifierSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mViewModel.turnOnHumidifier();
                    Toast.makeText(getContext(), "Humidifier is turned on!", Toast.LENGTH_SHORT).show();
                }
                else {
                    mViewModel.turnOffHumidifier();
                    Toast.makeText(getContext(), "Humidifier is turned off!", Toast.LENGTH_SHORT).show();
                }
            }
        });

         return root;

    }



}