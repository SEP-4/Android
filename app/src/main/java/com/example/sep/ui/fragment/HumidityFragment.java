package com.example.sep.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sep.R;
import com.example.sep.viewmodel.TemperatureViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class HumidityFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_temperature, container, false);

        LineChart chart = (LineChart) root.findViewById(R.id.humidityChart);

        ArrayList<Entry> data = new ArrayList<>();
        data.add(new Entry(10, 17));
        data.add(new Entry(11, 18));
        data.add(new Entry(12, 19));
        data.add(new Entry(13, 21));
        data.add(new Entry(14, 21));
        data.add(new Entry(15, 21));
        data.add(new Entry(16, 22));
        data.add(new Entry(17, 22));
        data.add(new Entry(18, 22));
        data.add(new Entry(19, 23));
        data.add(new Entry(20, 21));
        data.add(new Entry(21, 21));
        data.add(new Entry(22, 20));

        LineDataSet barDataSet = new LineDataSet(data, "Temperature data");
        barDataSet.setColors(R.color.green_700);
        barDataSet.setDrawValues(false);
        barDataSet.setLineWidth(6f);
        barDataSet.setCircleColors(R.color.black);
        barDataSet.setCircleRadius(5f);

        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisRight().setEnabled(false);


        LineData barData = new LineData(barDataSet);

        chart.setData(barData);
        chart.getDescription().setText("Bar chart temp");
        chart.animateY(2000);


        return root;
    }
}
