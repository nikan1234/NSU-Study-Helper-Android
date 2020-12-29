package ru.nsk.nsu.studyhelper.mvp.presentation.teachers.details;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherDetails;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherRating;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherRatingToPost;
import ru.nsk.nsu.studyhelper.mvp.presentation.Screens;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.noAuthWarning.NoAuthWarning;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.statistics.RatingSelectorPopup;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;
import java.util.function.Consumer;

public class TeacherDetailsFragment extends TeacherDetailsContract.View {

    @Inject
    Router router;

    @Inject
    TeacherDetailsContract.Presenter presenter;

    @BindView(R.id.teacher_statistics_name_title)
    TextView nameTextView;

    @BindView(R.id.teacher_statistics_birth_year)
    TextView birthYearTextView;

    @BindView(R.id.teacher_statistics_status)
    TextView statusTextView;

    @BindView(R.id.teacher_statistics_rating)
    RatingBar ratingBar;

    @BindView(R.id.teacher_statistics_rating_value)
    TextView ratingTextView;

    @BindView(R.id.teacher_statistics_user_mark_button)
    Button userRatingButton;

    @BindView(R.id.teacher_statistics_comments_button)
    View commentsButton;

    private static final String ARG_PARAM = "teacher_data";
    private Teacher teacher;

    private RatingSelectorPopup ratingSelectorPopup;

    public static TeacherDetailsFragment newInstance(final Teacher teacher) {
        TeacherDetailsFragment fragment = new TeacherDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM, teacher);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_teacher_details, container, false);
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

        nameTextView.setText(teacher.getFullName());
        ratingTextView.setPaintFlags(ratingTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        ratingSelectorPopup = new RatingSelectorPopup(getActivity(), onTeacherRationSelectedAction());
        presenter.loadTeacherDetails(teacher);
    }

    @OnClick(R.id.teacher_comments_layout)
    void onTeacherCommentsButtonClicked() {
        router.navigateTo(new Screens.TeacherCommentsScreen(teacher));
    }

    @OnClick(R.id.teacher_user_mark_layout)
    void onTeacherUserMarkButtonClicked() {
        if (!presenter.isAuthorized()) {
            NoAuthWarning.showWarning(getActivity());
            return;
        }
        ratingSelectorPopup.show();
    }

    @Override
    public void showTeacherDetails(TeacherDetails teacherDetails) {
        birthYearTextView.setText(teacherDetails.getBirthYear());
        statusTextView.setText(teacherDetails.getStatus());
        ratingBar.setRating(teacherDetails.getRating());
        ratingTextView.setText(String.valueOf(teacherDetails.getRating()));

        TeacherRating userRating = teacherDetails.getCurrentUserRating();
        if (userRating != null) {
            if (userRating.getRating() != null) {
                userRatingButton.setText(Integer.toString(userRating.getRating()));
            }
        }
        else {
            userRatingButton.setText("?");
        }
    }

    @Override
    public void onTeacherRationSent() {
        presenter.loadTeacherDetails(teacher);
    }

    private Consumer<TeacherRating> onTeacherRationSelectedAction() {
        return teacherRating -> presenter.sendTeacherRating(
                new TeacherRatingToPost(teacherRating, teacher));
    }
}