package ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.marks;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.constants.statistics.ExamStatisticsConstants;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.Mark;

import java.util.HashMap;
import java.util.function.Consumer;

public class MarkListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_mark_value)
    TextView markValueTextView;

    @BindView(R.id.item_mark_description)
    TextView markDescriptionTextView;

    private final HashMap<Integer, String> markToDescription;
    private final HashMap<Integer, Integer> markToColor;

    private Mark mark;

    public MarkListViewHolder(final @NonNull View itemView,
                              final @NonNull Consumer<Mark> consumer) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        final Context context = itemView.getContext();
        final Resources resources = context.getResources();
        markToDescription =  new HashMap<>();
        markToDescription.put(ExamStatisticsConstants.NO_MARK,
                resources.getString(R.string.no_mark_description));
        markToDescription.put(ExamStatisticsConstants.MARK_BAD,
                resources.getString(R.string.mark_bad_description));
        markToDescription.put(ExamStatisticsConstants.MARK_SATISFACTORY,
                resources.getString(R.string.mark_satisfactory_description));
        markToDescription.put(ExamStatisticsConstants.MARK_GOOD,
                resources.getString(R.string.mark_good_description));
        markToDescription.put(ExamStatisticsConstants.MARK_EXCELLENT,
                resources.getString(R.string.mark_excellent_description));

        markToColor = ExamStatisticsConstants.getMarkToColorConverter(context);

        itemView.setOnClickListener(v -> consumer.accept(mark));
    }

    void onBind(@Nullable final Mark mark) {
        this.mark = mark;


        if (mark == null) {
            markValueTextView.setText("?");

            Integer color = markToColor.get(ExamStatisticsConstants.NO_MARK);
            if (color != null) {
                markValueTextView.setTextColor(color);
            }
            markDescriptionTextView.setText(markToDescription
                    .getOrDefault(ExamStatisticsConstants.NO_MARK, ""));
            return;
        }
        markValueTextView.setText(mark.toString());
        Integer color = markToColor.get(mark.getMark());
        if (color != null) {
            markValueTextView.setTextColor(color);
        }
        markDescriptionTextView.setText(markToDescription
                .getOrDefault(mark.getMark(), ""));
    }
}
