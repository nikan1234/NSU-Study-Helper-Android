package ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.marks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.constants.statistics.ExamStatisticsConstants;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.Mark;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class MarkListAdapter extends RecyclerView.Adapter<MarkListViewHolder> {

    private static final List<Mark> marks;
    private final Consumer<Mark> consumer;

    static {
        marks = new LinkedList<>();
        for (int markValue = ExamStatisticsConstants.MIN_MARK;
             markValue <= ExamStatisticsConstants.MAX_MARK; ++markValue) {
            marks.add(new Mark(markValue));
        }
        /* No mark */
        marks.add(null);
    }

    public MarkListAdapter(@NonNull final Consumer<Mark> consumer) {
        this.consumer = consumer;
    }

    @NonNull
    @Override
    public MarkListViewHolder onCreateViewHolder(final @NonNull ViewGroup parent, int viewType) {
        final Context context = parent.getContext();

        final View view = LayoutInflater
                .from(context)
                .inflate(R.layout.item_list_mark, parent, false);
        return new MarkListViewHolder(view, consumer);
    }

    @Override
    public void onBindViewHolder(final @NonNull MarkListViewHolder holder, int position) {
        final Mark mark = marks.get(position);
        holder.onBind(mark);
    }

    @Override
    public int getItemCount() {
        return marks.size();
    }
}
