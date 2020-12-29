package ru.nsk.nsu.studyhelper.mvp.presentation.teachers.comments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentWithoutUser;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.TeacherCommentToPost;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.lists.CommentListAdapter;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.noAuthWarning.NoAuthWarning;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;
import java.util.ArrayList;

public class TeacherCommentsFragment extends TeacherCommentsContract.View {

    @Inject
    Router router;

    @Inject
    TeacherCommentsContract.Presenter presenter;

    @BindView(R.id.comments_description_title)
    TextView commentsDescriptionTextEdit;

    @BindView(R.id.comments_recycler_view)
    RecyclerView commentsRecyclerView;

    @BindView(R.id.user_comment_edit_text)
    EditText userCommentEditText;

    private CommentListAdapter commentListAdapter;

    private static final String ARG_PARAM = "teacher_data";
    private Teacher teacher;

    public static TeacherCommentsFragment newInstance(final Teacher teacher) {
        TeacherCommentsFragment fragment = new TeacherCommentsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM, teacher);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_comments, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) {
            return;
        }
        teacher = (Teacher) getArguments().getSerializable(ARG_PARAM);
    }

    @Override
    public void onViewCreated(@NonNull final View view,
                              @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        commentsDescriptionTextEdit.setText(teacher.getFullName());

        commentListAdapter = new CommentListAdapter(new ArrayList<>());
        commentsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        commentsRecyclerView.setAdapter(commentListAdapter);

        presenter.loadTeacherComments(teacher);
    }

    @Override
    public void onDestroy() {
        presenter.unlinkView();
        super.onDestroy();
    }

    @OnClick(R.id.send_comment_button)
    void onSendCommentButtonClicked() {
        if (!presenter.isAuthorized()) {
            NoAuthWarning.showWarning(getActivity());
            return;
        }
        presenter.sendUserComment(new TeacherCommentToPost(teacher,
                new CommentWithoutUser(userCommentEditText.getText().toString())));
    }

    @Override
    public void showTeacherComments(CommentStatistics comments) {
        commentListAdapter.replaceData(comments.getComments());

        if (comments.getCurrentUserComment() != null) {
            userCommentEditText.setText(comments.getCurrentUserComment().getCommentText());
        }
    }

    @Override
    public void onUserCommentSent() {
        presenter.loadTeacherComments(teacher);
    }
}
