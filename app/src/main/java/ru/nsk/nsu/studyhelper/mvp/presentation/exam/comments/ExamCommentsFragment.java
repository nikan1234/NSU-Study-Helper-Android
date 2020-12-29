package ru.nsk.nsu.studyhelper.mvp.presentation.exam.comments;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentWithoutUser;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.ExamCommentToPost;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.lists.CommentListAdapter;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.noAuthWarning.NoAuthWarning;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;
import java.util.ArrayList;

public class ExamCommentsFragment extends ExamCommentsContract.View {

    @Inject
    Router router;

    @Inject
    ExamCommentsContract.Presenter presenter;

    @BindView(R.id.comments_description_title)
    TextView commentsDescriptionTextEdit;

    @BindView(R.id.comments_recycler_view)
    RecyclerView commentsRecyclerView;

    @BindView(R.id.user_comment_edit_text)
    EditText userCommentEditText;

    private CommentListAdapter commentListAdapter;

    private static final String ARG_PARAM = "examination_data";
    private Exam exam;

    public static ExamCommentsFragment newInstance(final Exam exam) {
        ExamCommentsFragment fragment = new ExamCommentsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM, exam);
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
        exam = (Exam) getArguments().getSerializable(ARG_PARAM);
    }

    @Override
    public void onViewCreated(@NonNull final View view,
                              @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        commentsDescriptionTextEdit.setText(exam.getSubject().getName());

        commentListAdapter = new CommentListAdapter(new ArrayList<>());
        commentsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        commentsRecyclerView.setAdapter(commentListAdapter);

        presenter.loadSubjectComments(exam);
    }

    @Override
    public void onDestroy() {
        presenter.unlinkView();
        super.onDestroy();
    }

    @Override
    public void showExaminationComments(final CommentStatistics comments) {
        commentListAdapter.replaceData(comments.getComments());

        if (comments.getCurrentUserComment() != null) {
            userCommentEditText.setText(comments.getCurrentUserComment().getCommentText());
        }
    }

    @OnClick(R.id.send_comment_button)
    void onSendCommentButtonClicked() {
        if (!presenter.isAuthorized()) {
            NoAuthWarning.showWarning(getActivity());
            return;
        }
        presenter.sendUserComment(new ExamCommentToPost(exam,
                new CommentWithoutUser(userCommentEditText.getText().toString())
        ));
    }

    @Override
    public void onUserCommentSent() {
        presenter.loadSubjectComments(exam);
    }
}