package ru.nsk.nsu.studyhelper.mvp.data.exams.remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.exam.ExamDetails;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentWithoutUser;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.Mark;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;

import java.util.List;

public interface RemoteExamDetailsAPI {

    @GET("api/v1/exam/{exam-id}/details")
    Call<ExamDetails> getExamStatistics(@Path(value = "exam-id", encoded = true) int examId);

    @GET("api/v1/exam/{exam-id}/comments")
    Call<CommentStatistics> getExamComments(@Path(value = "exam-id", encoded = true) int examId);

    @GET("api/v1/exam/{exam-id}/teachers")
    Call<List<Teacher>> getExamTeacherList(@Path(value = "exam-id", encoded = true) int examId);

    @POST("api/v1/exam/{exam-id}/mark")
    Call<Void> sendUserMark(@Path(value = "exam-id", encoded = true) int examId,
                            @Body Mark mark);

    @POST("api/v1/exam/{exam-id}/comment")
    Call<Void> sendUserComment(@Path(value = "exam-id", encoded = true) int examId,
                            @Body CommentWithoutUser comment);
}
