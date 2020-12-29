package ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.constants.statistics.ExamStatisticsConstants;
import ru.nsk.nsu.studyhelper.mvp.model.exam.ExamDetails;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.diagram.MarksDiagram;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.diagram.PercentValueFormatter;

import java.util.*;

public class DiagramAdapter {

    private static final String LOG_TAG = DiagramAdapter.class.getSimpleName();

    public static final int DIAGRAM_ANIMATE_MILLIS = 500;
    public static final float DIAGRAM_VALUE_TEXT_SIZE = 18f;
    public static final float DIAGRAM_TEXT_SIZE = 20f;
    public static final float DIAGRAM_BAR_WIDTH = 0.8f;

    private static final float PERCENTS = 100.0f;

    private MarksDiagram diagram;

    public void setDiagram(@NonNull final MarksDiagram diagram) {
        this.diagram = diagram;

        diagram.animateY(DIAGRAM_ANIMATE_MILLIS);
        diagram.getXAxis().setTextSize(DIAGRAM_TEXT_SIZE);
        diagram.setDrawBarShadow(true);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for (int mark = ExamStatisticsConstants.MIN_MARK;
             mark <= ExamStatisticsConstants.MAX_MARK; ++mark) {
            barEntries.add(new BarEntry(mark, 0));
        }
        diagram.setData(createBarData(barEntries));
    }

    public void replaceData(List<ExamDetails.MarkStatistic> markStatistics) {
        if (diagram == null) {
            Log.e(LOG_TAG, "Diagram is null");
            return;
        }

        float count = 0;
        for (ExamDetails.MarkStatistic stat : markStatistics) {
            count += stat.getCount();
        }

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        Collections.sort(markStatistics, (o1, o2) -> {
            int m1 = o1.getMark().getMark();
            int m2 = o2.getMark().getMark();
            return Integer.compare(m2, m1);
        });
        for (ExamDetails.MarkStatistic stat : markStatistics) {
            barEntries.add(new BarEntry(
                    stat.getMark().getMark(),
                    (count > 0) ? PERCENTS * stat.getCount() / count : 0)
            );
        }
        diagram.setData(createBarData(barEntries));
        diagram.invalidate();
        diagram.animateY(DIAGRAM_ANIMATE_MILLIS);
    }

    private BarData createBarData(@NonNull final ArrayList<BarEntry> barEntries) {
        final Context context = diagram.getContext();

        BarDataSet barDataSet = new BarDataSet(barEntries, "");
        barDataSet.setColors(
                ContextCompat.getColor(context, R.color.diagramColor_1),
                ContextCompat.getColor(context, R.color.diagramColor_2),
                ContextCompat.getColor(context, R.color.diagramColor_3),
                ContextCompat.getColor(context, R.color.diagramColor_4));

        barDataSet.setValueTextColor(
                ContextCompat.getColor(context, R.color.diagramBarTextColor));
        barDataSet.setBarShadowColor(
                ContextCompat.getColor(context, R.color.diagramBarShadowColor));
        barDataSet.setValueTextSize(DIAGRAM_VALUE_TEXT_SIZE);
        barDataSet.setValueFormatter(new PercentValueFormatter());


        BarData data = new BarData(barDataSet);
        data.setBarWidth(DIAGRAM_BAR_WIDTH);
        return data;
    }
}
