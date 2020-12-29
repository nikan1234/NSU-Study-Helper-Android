package ru.nsk.nsu.studyhelper.mvp.presentation.exam.details;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;

import java.util.List;

public class ExamTeacherListAdapter extends RecyclerView.Adapter<ExamTeacherListItemViewHolder> {

    private List<Teacher> items;

    public ExamTeacherListAdapter(final List<Teacher> items) {
        this.items = items;
    }

    void replaceData(final List<Teacher> items) {
        if (null != items) {
            this.items = items;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExamTeacherListItemViewHolder onCreateViewHolder(final @NonNull ViewGroup parent, int viewType) {
        final Context context = parent.getContext();

        final View view = LayoutInflater
                .from(context)
                .inflate(R.layout.item_list_teacher, parent, false);

        return new ExamTeacherListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final @NonNull ExamTeacherListItemViewHolder holder, int position) {
        final Teacher item = items.get(position);
        holder.onBind(item);
    }

    @Override
    public int getItemCount() {
        return (null != items) ? items.size() : 0;
    }
}
