package ru.nsk.nsu.studyhelper.mvp.data.teachers.remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentWithoutUser;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherDetails;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherRating;

public interface RemoteTeacherDetailsAPI {

    @GET("api/v1/teacher/{teacher-id}/details")
    Call<TeacherDetails> getTeacherDetails(@Path(value = "teacher-id", encoded = true) int teacherId);

    @GET("api/v1/teacher/{teacher-id}/comments")
    Call<CommentStatistics> getTeacherComments(@Path(value = "teacher-id", encoded = true) int teacherId);

    @POST("api/v1/teacher/{teacher-id}/comment")
    Call<Void> sendUserComment(@Path(value = "teacher-id", encoded = true) int teacherId,
                               @Body CommentWithoutUser comment);

    @POST("api/v1/teacher/{teacher-id}/rating")
    Call<Void> sendTeacherRating(@Path(value = "teacher-id", encoded = true) int teacherId,
                                 @Body TeacherRating rating);
}
