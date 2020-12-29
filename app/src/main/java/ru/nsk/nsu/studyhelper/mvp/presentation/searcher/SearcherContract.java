package ru.nsk.nsu.studyhelper.mvp.presentation.searcher;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.EntryYear;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.Semester;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.*;

import java.util.List;

public class SearcherContract {
    abstract public static class  Presenter extends BasePresenter<View> {
        public abstract void loadEntryYearList();
        public abstract void loadSemesterList();
        public abstract void loadExaminationList(@NonNull final EntryYear year,
                                                 @NonNull final Semester semester);
    }

    abstract public static class  View extends BaseView {
        public abstract void showEntryYearList(@NonNull final List<EntryYear> entryYears);
        public abstract void showSemesterList(@NonNull final List<Semester> semesters);
        public abstract void showExaminationList(@NonNull final List<Exam> exams);
    }
}
