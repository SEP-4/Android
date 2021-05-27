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
import com.example.sep.viewmodel.CO2ViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CO2Fragment extends Fragment {

    private com.example.sep.viewmodel.CO2ViewModel CO2ViewModel;
    private Button btn;
    private TextView dateTextView;
    private DatePickerDialog datePicker;
    private Calendar calendar;
    private LineChart chart;
    String averageCO2 = null;
    ArrayList<Entry> data = new ArrayList<>();
    ArrayList<Integer> data2 = new ArrayList<>();
    LineDataSet barDataSet;
    LineData barData;
    float x = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CO2ViewModel = new ViewModelProvider(this).get(CO2ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_co2, container, false);

        btn = root.findViewById(R.id.datePickerCO2);
        dateTextView = root.findViewById(R.id.dateTextViewCO2);
        chart = (LineChart) root.findViewById(R.id.co2Chart);


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

                        dateTextView.setText(mDayOfMonth+ "/" + (mMonth+1) + "/" + mYear);
                        chart();

                    }
                }, year, month, day);
                datePicker.show();

            }
        });

        return root;
    }

    public void chart(){

      //getList();

        ArrayList<AverageData> arrayList = new ArrayList<>();
        CO2ViewModel.retrieveAverageData();
        CO2ViewModel.getAverageData().observe(this, new Observer<List<AverageData>>() {
            @Override
            public void onChanged(List<AverageData> averageData) {

                averageCO2 = averageData.get(15).getAverageCO2Level();
                System.out.println("CO222:" + averageCO2);
                getCO2(averageCO2);
            }
        });



        data.add(new Entry(10, x ));
        data.add(new Entry(19, 23));
        data.add(new Entry(20, 21));
        data.add(new Entry(21, 21));
        data.add(new Entry(22, 20));


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

    public void getCO2(String co2){
        x = Float.parseFloat(co2);
        System.out.println("XXXXXX: " + x);
    }

    public ArrayList<AverageData> getList(){
        ArrayList<AverageData> arrayList = new ArrayList<>();
        CO2ViewModel.retrieveAverageData();
        CO2ViewModel.getAverageData().observe(this, new Observer<List<AverageData>>() {
            @Override
            public void onChanged(List<AverageData> averageData) {

                for (AverageData mAveragedata: averageData) {
                    arrayList.add(mAveragedata);
                }
                //averageCO2 = averageData.get(15).getAverageCO2Level();
                System.out.println("AverageCO2Level: " + averageData.get(15).getAverageCO2Level());


                averageData.size();
                System.out.println("AverageData List:" + averageData);
            }
        });

        System.out.println("ArrayList: " + arrayList.size());
        return arrayList;
    }
}