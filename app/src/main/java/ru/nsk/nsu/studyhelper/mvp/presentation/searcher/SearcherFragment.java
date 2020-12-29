package ru.nsk.nsu.studyhelper.mvp.presentation.searcher;

import android.os.Bundle;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.EntryYear;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.Semester;
import ru.nsk.nsu.studyhelper.mvp.presentation.Screens;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;
import java.util.List;

public class SearcherFragment extends SearcherContract.View {

    @Inject
    Router router;

    @Inject
    SearcherContract.Presenter presenter;

    @BindView(R.id.select_year_spinner)
    Spinner selectEntryYear;

    @BindView(R.id.select_semester_spinner)
    Spinner selectSemester;

    @BindView(R.id.select_examination_spinner)
    Spinner selectExamination;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.fragment_searcher, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view,
                              @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupComponents();

        presenter.loadEntryYearList();
        presenter.loadSemesterList();
    }

    private void setupComponents() {
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                EntryYear entryYear = (EntryYear) selectEntryYear.getSelectedItem();
                Semester semester = (Semester) selectSemester.getSelectedItem();
                if (entryYear == null || semester == null) {
                    return;
                }
                presenter.loadExaminationList(entryYear, semester);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        };
        selectEntryYear.setOnItemSelectedListener(listener);
        selectSemester.setOnItemSelectedListener(listener);
    }

    @OnClick(R.id.select_examination_button)
    public void onExaminationSelectedButtonClicked() {
        Exam exam = (Exam) selectExamination.getSelectedItem();
        if (exam != null) {
            router.navigateTo(new Screens.ExamDetailsScreen(exam));
        }
    }

    @Override
    public void showEntryYearList(@NonNull final List<EntryYear> entryYears) {
        selectEntryYear.setAdapter(createSpinnerAdapter(entryYears));
    }

    @Override
    public void showSemesterList(@NonNull final List<Semester> semesters) {
        selectSemester.setAdapter(createSpinnerAdapter(semesters));

    }

    @Override
    public void showExaminationList(@NonNull final List<Exam> exams) {
        selectExamination.setAdapter(createSpinnerAdapter(exams));
    }

    @Override
    public void onDestroy() {
        presenter.unlinkView();
        super.onDestroy();
    }

    private <DataType> ArrayAdapter<DataType> createSpinnerAdapter(@NonNull final List<DataType> data) {
        ArrayAdapter<DataType> arrayAdapter = new ArrayAdapter<>(
                getContext(),
                R.layout.spinner_item,
                data);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        return arrayAdapter;
    }
}