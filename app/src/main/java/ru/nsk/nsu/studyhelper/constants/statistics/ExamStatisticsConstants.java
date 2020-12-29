package ru.nsk.nsu.studyhelper.constants.statistics;

import android.content.Context;
import androidx.core.content.ContextCompat;
import ru.nsk.nsu.studyhelper.R;

import java.util.HashMap;

public class ExamStatisticsConstants {
    public static final int MAX_MARK = 5;
    public static final int MIN_MARK = 2;

    public static final int NO_MARK = -1;
    public static final int MARK_BAD = 2;
    public static final int MARK_SATISFACTORY = 3;
    public static final int MARK_GOOD = 4;
    public static final int MARK_EXCELLENT = 5;

    public static HashMap<Integer, Integer> getMarkToColorConverter(final Context context) {
        HashMap<Integer, Integer> markColorHashMap = new HashMap<>();
        markColorHashMap.put(ExamStatisticsConstants.NO_MARK,
                ContextCompat.getColor(context, R.color.colorPrimaryDark));
        markColorHashMap.put(ExamStatisticsConstants.MARK_BAD,
                ContextCompat.getColor(context, R.color.diagramColor_4));
        markColorHashMap.put(ExamStatisticsConstants.MARK_SATISFACTORY,
                ContextCompat.getColor(context, R.color.diagramColor_3));
        markColorHashMap.put(ExamStatisticsConstants.MARK_GOOD,
                ContextCompat.getColor(context, R.color.diagramColor_2));
        markColorHashMap.put(ExamStatisticsConstants.MARK_EXCELLENT,
                ContextCompat.getColor(context, R.color.diagramColor_1));
        return markColorHashMap;
    }
}
