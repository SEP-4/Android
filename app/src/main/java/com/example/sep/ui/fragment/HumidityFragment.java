package com.example.sep.ui.fragment;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sep.R;
import com.example.sep.viewmodel.HumidityViewModel;
import com.example.sep.viewmodel.TemperatureViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HumidityFragment extends Fragment {
    private HumidityViewModel viewModel;
    private Button btn;
    private TextView dateTextView;
    private DatePickerDialog datePicker;
    private Calendar calendar;
    private LineChart chart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        viewModel =
                new ViewModelProvider(this).get(HumidityViewModel.class);
        View root = inflater.inflate(R.layout.fragment_humidity, container, false);

        btn = root.findViewById(R.id.datePickerHumidity);
        dateTextView = root.findViewById(R.id.dateTextViewHumidity);
        chart = (LineChart) root.findViewById(R.id.humidityChart);


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
        chart.getDescription().setText("Hour");
        chart.animateY(2000);
    }
}
