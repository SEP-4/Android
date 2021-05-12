package com.example.sep.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sep.R;
import com.example.sep.viewmodel.CO2ViewModel;

public class CO2Fragment extends Fragment {

    private com.example.sep.viewmodel.CO2ViewModel CO2ViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CO2ViewModel =
                new ViewModelProvider(this).get(CO2ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_co2, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        CO2ViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}