package ru.nsk.nsu.studyhelper.mvp.presentation.exam.details;

import android.os.Bundle;
import android.widget.Button;
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
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.presentation.Screens;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class ExamDetailsFragment extends ExamDetailsContract.View {

    @Inject
    Router router;

    @Inject
    ExamDetailsContract.Presenter presenter;

    @BindView(R.id.info_examination_name_title)
    TextView examinationNameTextView;

    @BindView(R.id.info_examination_semester_title)
    TextView examinationSemesterTextView;

    @BindView(R.id.info_show_statistics_button)
    Button showStatisticsButton;

    @BindView(R.id.info_teacher_list_view)
    RecyclerView teacherListView;

    private ExamTeacherListAdapter examTeacherListAdapter;

    private static final String ARG_PARAM = "examination_data";
    private Exam exam;

    public static ExamDetailsFragment newInstance(final Exam exam) {
        ExamDetailsFragment fragment = new ExamDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM, exam);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_exam_details, container, false);
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

        examinationNameTextView.setText(exam.getSubject().getName());
        examinationSemesterTextView.setText(exam.getSemester().toString());
        showStatisticsButton.setText(exam.getExaminationType().getDescription());

        examTeacherListAdapter = new ExamTeacherListAdapter(new ArrayList<>());
        teacherListView.setLayoutManager(new LinearLayoutManager(getContext()));
        teacherListView.setAdapter(examTeacherListAdapter);

        presenter.loadExamTeacherList(exam);
    }

    @Override
    public void onDestroy() {
        presenter.unlinkView();
        super.onDestroy();
    }

    @OnClick(R.id.info_show_statistics_button)
    void onShowStatisticsButtonClicked() {
        router.navigateTo(new Screens.ExamStatisticsScreen(exam));
    }

    @Override
    public void showExamTeacherList(List<Teacher> teachers) {
        examTeacherListAdapter.replaceData(teachers);
    }
}