package ru.nsk.nsu.studyhelper.mvp.data.searcher.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.EntryYear;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.Semester;

import java.util.List;

public interface RemoteSearcherAPI {

    @GET("api/v1/navigation/entry-year/all")
    Call<List<EntryYear>> loadEntryYearList();

    @GET("api/v1/navigation/semester/all")
    Call<List<Semester>> loadSemesterList();

    @GET("api/v1/navigation/exam/all/{entryYear}/{semester}")
    Call<List<Exam>> loadExaminationList(@Path(value = "entryYear", encoded = true) int entryYear,
                                         @Path(value = "semester", encoded = true) int semester);
}
