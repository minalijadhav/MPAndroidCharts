package com.example.admin.mpandroidcharts;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private BarChart barChart;
    private HorizontalBarChart horizontalBarChart;
    private PieChart pieChart;
    private LineChart lineChart;
    private ScatterChart scatterChart;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        // Finding IDs of all the Views
        barChart = (BarChart) findViewById(R.id.bar_chart);
        horizontalBarChart = (HorizontalBarChart) findViewById(R.id.horizontal_bar_chart);
        pieChart = (PieChart) findViewById(R.id.pie_chart);
        lineChart = (LineChart) findViewById(R.id.line_chart);
        scatterChart = (ScatterChart) findViewById(R.id.scatter_chart);

        // Setting data
        setBarChartData();

        setPieChartData();

        setHorizontalBarChartData();

        setLineChartData();

        setScatterChartData();
    }

    private void setBarChartData()
    {
        // Creating labels for Bar Chart
        ArrayList<String> barChartLabels = new ArrayList<String>();
        barChartLabels.add("1961-1970");
        barChartLabels.add("1971-1980");
        barChartLabels.add("1981-1990");
        barChartLabels.add("1991-2000");
        barChartLabels.add("2001-2010");

        // Creating Bar Entry for Group 1
        ArrayList<BarEntry> group1 = new ArrayList<>();
        group1.add(new BarEntry(5f, 0));
        group1.add(new BarEntry(4f, 1));
        group1.add(new BarEntry(3f, 2));
        group1.add(new BarEntry(2f, 3));
        group1.add(new BarEntry(1f, 4));

        // Creating Bar Entry for Group 2
        ArrayList<BarEntry> group2 = new ArrayList<>();
        group2.add(new BarEntry(1f, 0));
        group2.add(new BarEntry(2f, 1));
        group2.add(new BarEntry(3f, 2));
        group2.add(new BarEntry(4f, 3));
        group2.add(new BarEntry(5f, 4));

        // Creating Data Set for Group 1
        BarDataSet dataSet1 = new BarDataSet(group1, "Men");
        dataSet1.setColor(ContextCompat.getColor(context, R.color.red));

        // Creating Data Set for Group 2
        BarDataSet dataSet2 = new BarDataSet(group2, "Women");
        dataSet2.setColor(ContextCompat.getColor(context, R.color.black));

        // Combining all the Data Sets into a single Array List
        ArrayList<BarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet1);
        dataSets.add(dataSet2);

        // Initializing Bar Data with arguments viz., labels and data Sets
        BarData barData = new BarData(barChartLabels, dataSets);
        barData.setDrawValues(false);
        barData.setValueFormatter(new MyValueFormatter());

        // Setting data into Bar Chart
        barChart.setData(barData);
        barChart.animateY(3000);
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.setTouchEnabled(false);
        barChart.setDescription("");
    }

    private void setHorizontalBarChartData()
    {
        // Creating labels for Horizontal Bar Chart
        ArrayList<String> horizontalBarChartLabels = new ArrayList<String>();
        horizontalBarChartLabels.add("January");
        horizontalBarChartLabels.add("February");
        horizontalBarChartLabels.add("March");
        horizontalBarChartLabels.add("April");
        horizontalBarChartLabels.add("May");
        horizontalBarChartLabels.add("June");

        // Creating Bar Entry for Group
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(6f, 0));
        entries.add(new BarEntry(5f, 1));
        entries.add(new BarEntry(4f, 2));
        entries.add(new BarEntry(3f, 3));
        entries.add(new BarEntry(2f, 4));
        entries.add(new BarEntry(1f, 5));

        // Creating Data Set for Group
        BarDataSet dataSet = new BarDataSet(entries, "No. of calls");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        // Initializing Bar Data with arguments viz., labels and dataSets
        BarData barData = new BarData(horizontalBarChartLabels, dataSet);
        barData.setDrawValues(false);
        barData.setValueFormatter(new MyValueFormatter());

        // Setting data into Horizontal Bar Chart
        horizontalBarChart.setData(barData);
        horizontalBarChart.animateY(3000);
        horizontalBarChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        horizontalBarChart.setTouchEnabled(false);
        horizontalBarChart.setDescription("");
    }

    private void setPieChartData()
    {
        // Creating labels for Pie Chart
        ArrayList<String> pieChartLabels = new ArrayList<String>();
        pieChartLabels.add("Mathematics");
        pieChartLabels.add("Physics");
        pieChartLabels.add("Chemistry");
        pieChartLabels.add("Zoology");
        pieChartLabels.add("Botany");
        pieChartLabels.add("Marathi");
        pieChartLabels.add("English");

        // Creating entries for Pie Chart
        ArrayList<Entry> pieChartEntries = new ArrayList<>();
        pieChartEntries.add(new Entry(2f, 0));
        pieChartEntries.add(new Entry(3f, 1));
        pieChartEntries.add(new Entry(5f, 2));
        pieChartEntries.add(new Entry(4f, 3));
        pieChartEntries.add(new Entry(1f, 4));
        pieChartEntries.add(new Entry(7f, 5));
        pieChartEntries.add(new Entry(4f, 6));

        // Creating dataSet for entries
        PieDataSet dataSet = new PieDataSet(pieChartEntries, "");
        // dataSet.setSliceSpace(3f);

        // Adding colors
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(ContextCompat.getColor(context, R.color.salmon));
        colors.add(ContextCompat.getColor(context, R.color.steel_blue));
        colors.add(ContextCompat.getColor(context, R.color.sepia));
        colors.add(ContextCompat.getColor(context, R.color.deep_sky_blue));
        colors.add(ContextCompat.getColor(context, R.color.magenta));
        colors.add(ContextCompat.getColor(context, R.color.medium_orchid));
        colors.add(ContextCompat.getColor(context, R.color.light_orange));

        dataSet.setColors(colors);

        // Initializing Pie Chart with arguments viz, labels and dataSet
        PieData pieData = new PieData(pieChartLabels, dataSet);
        pieData.setValueFormatter(new MyValueFormatter());
        pieData.setDrawValues(false);

        // Customizing Legends
        Legend legend = pieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART_CENTER);
        legend.setXEntrySpace(7);
        legend.setYEntrySpace(5);

        // Setting data into Pie Chart
        pieChart.setData(pieData);
        pieChart.spin(3000, 360, 0, Easing.EasingOption.EaseInCubic);
        pieChart.setCenterText("Subjects");
        pieChart.setTransparentCircleRadius(0);
        pieChart.setDrawSliceText(false);
        pieChart.setDescription("");
        pieChart.setTouchEnabled(false);
        pieChart.highlightValues(null);
        pieChart.invalidate();

        // Adding Listener on Pie Chart in order to display respective values
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h)
            {
                // Toast.makeText(getActivity(), labels.get(e.getXIndex()) + " : " + String.format("%.0f", e.getVal()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected()
            {

            }
        });
    }

    private void setLineChartData()
    {
        // Creating Labels for Line Chart
        final ArrayList<String> line_chart_labels = new ArrayList<String>();
        line_chart_labels.add("Jan");
        line_chart_labels.add("Feb");
        line_chart_labels.add("Mar");
        line_chart_labels.add("Apr");
        line_chart_labels.add("May");
        line_chart_labels.add("Jun");
        line_chart_labels.add("Jul");
        line_chart_labels.add("Aug");
        line_chart_labels.add("Sep");
        line_chart_labels.add("Oct");
        line_chart_labels.add("Nov");
        line_chart_labels.add("Dec");

        // Adding Entries for Line Chart
        ArrayList<Entry> line_chart_entries = new ArrayList<>();
        line_chart_entries.add(new Entry(5f, 0));
        line_chart_entries.add(new Entry(3f, 1));
        line_chart_entries.add(new Entry(4f, 2));
        line_chart_entries.add(new Entry(1f, 3));
        line_chart_entries.add(new Entry(8f, 4));
        line_chart_entries.add(new Entry(3f, 5));
        line_chart_entries.add(new Entry(0f, 6));
        line_chart_entries.add(new Entry(9f, 7));
        line_chart_entries.add(new Entry(4f, 8));
        line_chart_entries.add(new Entry(2f, 9));
        line_chart_entries.add(new Entry(5f, 10));
        line_chart_entries.add(new Entry(3f, 11));

        // Creating Data Set
        LineDataSet lineDataSet = new LineDataSet(line_chart_entries, "No. of calls");
        lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        //lineDataSet.setDrawCubic(true);

        // Initializing Line Data with arguments viz., labels and dataSet
        LineData lineData = new LineData(line_chart_labels, lineDataSet);
        lineChart.setData(lineData);
        lineChart.animateX(3000);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.setDescription("");
    }

    private void setScatterChartData()
    {
        // Creating Labels for Scatter Chart
        final ArrayList<String> scatterChartLabels = new ArrayList<String>();
        scatterChartLabels.add("2011");
        scatterChartLabels.add("2012");
        scatterChartLabels.add("2013");
        scatterChartLabels.add("2014");
        scatterChartLabels.add("2015");
        scatterChartLabels.add("2016");
        scatterChartLabels.add("2017");

        // Adding Entries for Scatter Chart
        ArrayList<Entry> scatterChartEntries1 = new ArrayList<>();
        scatterChartEntries1.add(new Entry(10f, 0));
        scatterChartEntries1.add(new Entry(5f, 1));
        scatterChartEntries1.add(new Entry(7f, 2));
        scatterChartEntries1.add(new Entry(3f, 3));
        scatterChartEntries1.add(new Entry(8f, 4));
        scatterChartEntries1.add(new Entry(2f, 5));
        scatterChartEntries1.add(new Entry(6f, 6));

        ArrayList<Entry> scatterChartEntries2 = new ArrayList<>();
        scatterChartEntries2.add(new Entry(5f, 0));
        scatterChartEntries2.add(new Entry(6f, 1));
        scatterChartEntries2.add(new Entry(8f, 2));
        scatterChartEntries2.add(new Entry(4f, 3));
        scatterChartEntries2.add(new Entry(10f, 4));
        scatterChartEntries2.add(new Entry(8f, 5));
        scatterChartEntries2.add(new Entry(2f, 6));

        ArrayList<Entry> scatterChartEntries3 = new ArrayList<>();
        scatterChartEntries3.add(new Entry(4f, 0));
        scatterChartEntries3.add(new Entry(2f, 1));
        scatterChartEntries3.add(new Entry(1f, 2));
        scatterChartEntries3.add(new Entry(9f, 3));
        scatterChartEntries3.add(new Entry(7f, 4));
        scatterChartEntries3.add(new Entry(5f, 5));
        scatterChartEntries3.add(new Entry(4f, 6));

        // Creating Data Set
        ScatterDataSet scatterDataSet1 = new ScatterDataSet(scatterChartEntries1, "Samsung");
        scatterDataSet1.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
        scatterDataSet1.setColor(ContextCompat.getColor(context, R.color.red));

        ScatterDataSet scatterDataSet2 = new ScatterDataSet(scatterChartEntries2, "Red Mi");
        scatterDataSet2.setScatterShape(ScatterChart.ScatterShape.SQUARE);
        scatterDataSet2.setColor(ContextCompat.getColor(context, R.color.deep_sky_blue));

        ScatterDataSet scatterDataSet3 = new ScatterDataSet(scatterChartEntries3, "Oppo");
        scatterDataSet3.setScatterShape(ScatterChart.ScatterShape.TRIANGLE);
        scatterDataSet3.setColor(ContextCompat.getColor(context, R.color.black));

        // Combining all the data Sets into a Single Array List
        ArrayList<ScatterDataSet> scatterDataSet = new ArrayList<>();
        scatterDataSet.add(scatterDataSet1);
        scatterDataSet.add(scatterDataSet2);
        scatterDataSet.add(scatterDataSet3);

        // Initializing Scatter Data with arguments viz., labels and dataSet
        ScatterData scatterData = new ScatterData(scatterChartLabels, scatterDataSet);
        scatterChart.setData(scatterData);
        scatterChart.animateX(3000);
        scatterChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        scatterChart.setDescription("");
    }

    // Defining class for formatting Float values
    public class MyValueFormatter implements ValueFormatter
    {

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return Math.round(value) + "";
        }
    }
}
