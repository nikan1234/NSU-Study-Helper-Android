package ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.diagram;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;

public class PercentValueFormatter extends ValueFormatter {
    public DecimalFormat decimal;
    public DecimalFormat number;

    private PieChart pieChart;

    public PercentValueFormatter() {
        number = new DecimalFormat("###,###,###");
    }

    // Can be used to remove percent signs if the chart isn't in percent mode
    public PercentValueFormatter(PieChart pieChart) {
        this();
        this.pieChart = pieChart;
    }

    @Override
    public String getFormattedValue(float value) {
        return number.format(value) + '%';
    }

    @Override
    public String getPieLabel(float value, PieEntry pieEntry) {
        if (pieChart != null && pieChart.isUsePercentValuesEnabled()) {
            // Converted to percent
            return getFormattedValue(value);
        } else {
            // raw value, skip percent sign
            return decimal.format(value);
        }
    }
}

