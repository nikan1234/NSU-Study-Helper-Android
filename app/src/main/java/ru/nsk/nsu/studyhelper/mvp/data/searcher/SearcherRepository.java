package ru.nsk.nsu.studyhelper.mvp.data.searcher;

import android.util.Log;
import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.nsk.nsu.studyhelper.mvp.data.common.BaseRepository;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.ServiceGenerator;
import ru.nsk.nsu.studyhelper.mvp.data.searcher.remote.RemoteSearcherAPI;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.EntryYear;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.Semester;

import java.util.List;


public class SearcherRepository extends BaseRepository implements ISearcherDataSource {

    private static volatile SearcherRepository INSTANCE;

    private final RemoteSearcherAPI api;

    private SearcherRepository() {
        api = ServiceGenerator.createService(RemoteSearcherAPI.class);
    }

    public static SearcherRepository getInstance() {
        SearcherRepository localInstance = INSTANCE;
        if (localInstance == null) {
            synchronized (SearcherRepository.class) {
                localInstance = INSTANCE;
                if (localInstance == null) {
                    INSTANCE = localInstance = new SearcherRepository();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void loadEntryYearList(@NonNull final ISearcherDataSource.ILoadCallback<EntryYear> callback) {
        loadData(api.loadEntryYearList(), callback);
    }

    @Override
    public void loadSemesterList(@NonNull final ISearcherDataSource.ILoadCallback<Semester> callback) {
        loadData(api.loadSemesterList(), callback);
    }

    @Override
    public void loadExaminationList(@NonNull final ISearcherDataSource.ILoadCallback<Exam> callback,
                                    @NonNull final EntryYear entryYear,
                                    @NonNull final Semester semester) {

        /* TODO: ADD DEPENDENCY FROM entryYear AND semester */
        loadData(api.loadExaminationList(entryYear.getEntryYear(), semester.getSemesterNumber()), callback);
    }
}
