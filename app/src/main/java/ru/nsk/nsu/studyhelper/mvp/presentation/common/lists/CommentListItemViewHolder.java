package ru.nsk.nsu.studyhelper.mvp.presentation.common.lists;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.StudyHelperApplication;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.Comment;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.User;

public class CommentListItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.comment_title)
    TextView commentTitleTextView;

    @BindView(R.id.comment_body)
    TextView commentBodyTextView;

    public CommentListItemViewHolder(@NonNull final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        StudyHelperApplication.INSTANCE
                .androidInjector()
                .inject(this);
    }

    void onBind(final Comment comment) {
        final User user = comment.getUser();
        commentTitleTextView.setText(String.format("%s (%s)", user.getName(), user.getEmail()));
        commentBodyTextView.setText(comment.getCommentText());
    }
}
