package ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.constants.statistics.ExamStatisticsConstants;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.Mark;
import ru.nsk.nsu.studyhelper.mvp.model.exam.ExamDetails;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.MarkToPost;
import ru.nsk.nsu.studyhelper.mvp.presentation.Screens;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.noAuthWarning.NoAuthWarning;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.diagram.MarksDiagram;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.marks.MarkSelectorPopup;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Consumer;

public class ExamStatisticsFragment extends ExamStatisticsContract.View {

    @Inject
    Router router;

    @Inject
    ExamStatisticsContract.Presenter presenter;

    @BindView(R.id.statistics_examination_name_title)
    TextView examinationNameTextView;

    @BindView(R.id.statistics_examination_semester_title)
    TextView examinationSemesterTextView;

    @BindView(R.id.statistics_subject_marks_diagram)
    MarksDiagram marksDiagram;

    @BindView(R.id.subject_user_mark_button)
    Button markButton;

    @BindView(R.id.subject_comments_button)
    View commentsButton;

    private final DiagramAdapter diagramAdapter = new DiagramAdapter();

    private static final String ARG_PARAM = "examination_data";
    private Exam exam;

    private HashMap<Integer, Integer> markColorHashMap;

    private MarkSelectorPopup markSelectorPopup;


    public static ExamStatisticsFragment newInstance(final Exam exam) {
        ExamStatisticsFragment fragment = new ExamStatisticsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM, exam);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_exam_statistics, container, false);
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
        markColorHashMap = ExamStatisticsConstants.getMarkToColorConverter(getActivity());

        examinationNameTextView.setText(exam.getSubject().getName());
        examinationSemesterTextView.setText(exam.getSemester().toString());
        diagramAdapter.setDiagram(marksDiagram);

        markSelectorPopup = new MarkSelectorPopup(getActivity(), onMarkSelectedAction());
        presenter.loadExaminationStatistics(exam);
    }

    @Override
    public void showExaminationStatistics(ExamDetails examDetails) {
        diagramAdapter.replaceData(examDetails.getMarkStatistics());
        Mark mark = examDetails.getCurrentUserMark();

        Integer color;
        if (mark == null) {
            markButton.setText("?");
            color = ContextCompat.getColor(Objects
                    .requireNonNull(getContext()), R.color.colorPrimary);
        } else {
            int value = mark.getMark();
            markButton.setText(Integer.toString(value));
            color = markColorHashMap.get(value);
        }
        if (color != null) {
            markButton.getBackground().setColorFilter(BlendModeColorFilterCompat
                    .createBlendModeColorFilterCompat(color, BlendModeCompat.SRC_ATOP));
        }
    }

    @Override
    public void onUserMarkSent() {
        presenter.loadExaminationStatistics(exam);
    }

    @Override
    public void onDestroy() {
        presenter.unlinkView();
        super.onDestroy();
    }

    @OnClick(R.id.subject_user_mark_layout)
    void onUserMarkButtonClicked() {
        if (!presenter.isAuthorized()) {
            NoAuthWarning.showWarning(getActivity());
            return;
        }
        markSelectorPopup.show();
    }

    @OnClick(R.id.subject_comments_layout)
    void onCommentsButtonClicked() {
        router.navigateTo(new Screens.ExamCommentsScreen(exam));
    }

    private Consumer<Mark> onMarkSelectedAction() {
        return mark -> {
            markSelectorPopup.close();
            presenter.sendUserMark(new MarkToPost(exam, mark));
        };
    }
}
