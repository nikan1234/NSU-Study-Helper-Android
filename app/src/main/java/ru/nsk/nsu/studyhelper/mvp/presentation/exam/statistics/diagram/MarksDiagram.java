package ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.diagram;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;

public class MarksDiagram extends HorizontalBarChart {

    private static final float AXIS_MAXIMUM = 100f;
    private static final float AXIS_MINIMUM = 0f;

    private static final float LABEL_OFFSET_X = 30f;
    private static final float LABEL_OFFSET_Y = 250f;

    private static final float BAR_BORDER_RADIUS = 20f;
    private static final float BAR_BORDER_WIDTH = 10f;
    private static final float BAR_VALUE_OFFSET = 160f;

    public MarksDiagram(Context context) {
        super(context);
    }

    public MarksDiagram(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarksDiagram(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void init() {
        super.init();

        /* Left axis */
        YAxis axisLeft = getAxisLeft();
        axisLeft.setAxisMaximum(AXIS_MAXIMUM);
        axisLeft.setAxisMinimum(AXIS_MINIMUM);
        axisLeft.setEnabled(false);

        /* Right axis */
        YAxis axisRight = getAxisRight();
        axisRight.setEnabled(false);

        /* X axis */
        XAxis xaxis = getXAxis();
        xaxis.setGridColor(Color.TRANSPARENT);
        xaxis.setAxisLineColor(Color.TRANSPARENT);
        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        xaxis.setGranularityEnabled(true);
        xaxis.setXOffset(LABEL_OFFSET_X);
        xaxis.setYOffset(LABEL_OFFSET_Y);
        xaxis.setEnabled(true);

        /* Diagram */
        getDescription().setEnabled(false);
        getLegend().setEnabled(false);

        setViewPortOffsets(0f, 0f, 0f, 0f);
        setBackgroundColor(Color.TRANSPARENT);
        setDrawBarShadow(true);
        setTouchEnabled(false);
        setRenderer();
    }

    private void setRenderer() {
        RoundedHorizontalBarChartRenderer roundedBarChartRenderer= new RoundedHorizontalBarChartRenderer(
                this, getAnimator(), getViewPortHandler());

        roundedBarChartRenderer.setRadius(BAR_BORDER_RADIUS);
        roundedBarChartRenderer.setValueOffset(BAR_VALUE_OFFSET);
        roundedBarChartRenderer.setBorderWidth(BAR_BORDER_WIDTH);

        setRenderer(roundedBarChartRenderer);
    }
}
