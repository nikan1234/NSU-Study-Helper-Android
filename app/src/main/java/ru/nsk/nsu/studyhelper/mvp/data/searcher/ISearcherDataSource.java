package ru.nsk.nsu.studyhelper.mvp.data.searcher;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.data.common.IDataLoadCallback;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.EntryYear;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.Semester;

import java.util.List;

public interface ISearcherDataSource {

    interface ILoadCallback<DataType> extends IDataLoadCallback<List<DataType>> {}

    void loadEntryYearList(@NonNull final ILoadCallback<EntryYear> callback);

    void loadSemesterList(@NonNull final ILoadCallback<Semester> callback);

    void loadExaminationList(@NonNull final ILoadCallback<Exam> callback,
                             @NonNull final EntryYear entryYear,
                             @NonNull final Semester semester);
}
