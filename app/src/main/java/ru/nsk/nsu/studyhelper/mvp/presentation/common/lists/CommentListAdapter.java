package ru.nsk.nsu.studyhelper.mvp.presentation.common.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.Comment;

import java.util.List;

public class CommentListAdapter extends RecyclerView.Adapter<CommentListItemViewHolder> {

    private List<Comment> items;

    public CommentListAdapter(final List<Comment> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CommentListItemViewHolder onCreateViewHolder(final @NonNull ViewGroup parent, int viewType) {
        final Context context = parent.getContext();

        final View view = LayoutInflater
                .from(context)
                .inflate(R.layout.item_list_comment, parent, false);

        return new CommentListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final @NonNull CommentListItemViewHolder holder, int position) {
        final Comment item = items.get(position);
        holder.onBind(item);
    }

    @Override
    public int getItemCount() {
        return (null != items) ? items.size() : 0;
    }

    public void replaceData(final List<Comment> items) {
        if (null != items) {
            this.items = items;
        }
        notifyDataSetChanged();
    }
}
