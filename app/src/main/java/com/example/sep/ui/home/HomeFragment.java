package com.example.sep.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sep.R;
import com.example.sep.ui.gallery.GalleryViewModel;
import com.mvvm.viewmodel.MainViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView_info;
    private ArrayList<Info> infos;
    private HomeViewModel homeViewModel;
    private MainViewModel mainViewModel;
    HomeAdapter homeAdapter;
    private TextView tmpTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        tmpTextView = root.findViewById(R.id.tmp);
        //recyclerView_info = root.findViewById(R.id.recycleview_Info);
        //homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.retrieveLastTemperature();
        mainViewModel.getLastTemperature().observe(this.getViewLifecycleOwner(), temperature -> {
            tmpTextView.setText(temperature.toString());
            System.out.println("tmppp:" + temperature.toString());
        });

        //homeViewModel.getInfoLiveData().observe((LifecycleOwner) getContext(), infoListUpdateObserver);


        return root;
    }

    Observer<ArrayList<Info>> infoListUpdateObserver = new Observer<ArrayList<Info>>() {
        @Override
        public void onChanged(ArrayList<Info> infos) {
            homeAdapter = new HomeAdapter(infos);
            recyclerView_info.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView_info.setHasFixedSize(true);
            recyclerView_info.setAdapter(homeAdapter);

        }
    };

}