package com.example.sep.ui.fragment;


import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;


import androidx.annotation.NonNull;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sep.R;
import com.example.sep.model.AverageData;
import com.example.sep.viewmodel.AverageDataViewModel;

import com.github.mikephil.charting.charts.LineChart;

import com.github.mikephil.charting.components.XAxis;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TemperatureFragment extends Fragment {


    private AverageDataViewModel AverageDataViewModel;
    private Button btn;
    private TextView dateTextView;
    private DatePickerDialog datePicker;
    private Calendar calendar;
    private LineChart chart;
    ArrayList<Entry> data = new ArrayList<>();
    LineDataSet barDataSet;
    LineData barData;
    ArrayList<String> values = new ArrayList<>();
    ArrayList<Integer> valuesX = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AverageDataViewModel = new ViewModelProvider(this).get(AverageDataViewModel.class);
        View root = inflater.inflate(R.layout.fragment_temperature, container, false);

        btn = root.findViewById(R.id.datePickerTemperature);
        dateTextView = root.findViewById(R.id.dateTextViewTemperature);
        chart = (LineChart) root.findViewById(R.id.temperatureChart);

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                datePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDayOfMonth) {

                        values.clear();
                        valuesX.clear();
                        data.clear();
                        dateTextView.setText(mYear+ "-" +(mMonth+1) + "-"+mDayOfMonth);
                        AverageDataViewModel.retrieveAverageData(dateTextView.getText().toString());

                    }
                }, year, month, day);
                datePicker.show();

            }
        });

        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        dateTextView.setText(year+"-"+(month+1)+"-"+day);
        AverageDataViewModel.retrieveAverageData(year+"-"+(month+1)+"-"+day);


        AverageDataViewModel.getAverageData().observe(getViewLifecycleOwner(), new Observer<List<AverageData>>() {
            @Override
            public void onChanged(List<AverageData> averageData) {
                for (int i=0; i<=averageData.size()-1; i++){
                    values.add(averageData.get(i).getAverageTemperature());
                    valuesX.add(averageData.get(i).getHour());
                }
                chart(values);
            }
        });
        return root;
    }

    public void chart(ArrayList<String> arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals("NaN")){
                data.add(new Entry(valuesX.get(i), 0));
            }
            else {
                data.add(new Entry(valuesX.get(i), Float.parseFloat(arrayList.get(i))));
            }
        }


        barDataSet = new LineDataSet (data, "Chart");

        barDataSet.setColors(R.color.green_700);
        barDataSet.setDrawValues(false);
        barDataSet.setLineWidth(6f);
        barDataSet.setCircleColors(R.color.black);
        barDataSet.setCircleRadius(5f);

        barData = new LineData(barDataSet);


        chart.setData(barData);
        chart.getDescription().setText("Hour");
        chart.animateY(2000);


        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisRight().setEnabled(false);



    }

}

