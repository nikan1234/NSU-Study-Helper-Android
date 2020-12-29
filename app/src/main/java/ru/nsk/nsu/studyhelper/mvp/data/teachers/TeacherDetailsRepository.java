package ru.nsk.nsu.studyhelper.mvp.data.teachers;

import android.util.Log;
import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.data.common.BaseRepository;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.ServiceGenerator;
import ru.nsk.nsu.studyhelper.mvp.data.exams.ExamDetailsRepository;
import ru.nsk.nsu.studyhelper.mvp.data.exams.IExamDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.data.teachers.remote.RemoteTeacherDetailsAPI;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.TeacherCommentToPost;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherDetails;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherRating;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherRatingToPost;

public class TeacherDetailsRepository extends BaseRepository implements ITeacherDetailsDataSource {

    private static volatile TeacherDetailsRepository instance;

    private final RemoteTeacherDetailsAPI api;

    private TeacherDetailsRepository() {
        api = ServiceGenerator.createService(RemoteTeacherDetailsAPI.class);
    }

    public static TeacherDetailsRepository getInstance() {
        TeacherDetailsRepository localInstance = instance;
        if (localInstance == null) {
            synchronized (ExamDetailsRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new TeacherDetailsRepository();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void loadTeacherDetails(final @NonNull ITeacherDetailsDataSource.ILoadCallback<TeacherDetails> callback,
                                   final @NonNull Teacher teacher) {
        loadData(api.getTeacherDetails(teacher.getId()), callback);
    }

    @Override
    public void loadTeacherComments(final @NonNull ITeacherDetailsDataSource.ILoadCallback<CommentStatistics> callback,
                                    final @NonNull Teacher teacher) {
        loadData(api.getTeacherComments(teacher.getId()), callback);
    }

    @Override
    public void sendUserComment(final @NonNull IExamDetailsDataSource.ILoadCallback<Void> callback,
                                final @NonNull TeacherCommentToPost comment) {
        loadData(api.sendUserComment(comment.getTeacher().getId(), comment.getComment()), callback);
    }

    @Override
    public void sendTeacherRating(final @NonNull IExamDetailsDataSource.ILoadCallback<Void> callback,
                                  final @NonNull TeacherRatingToPost ratingToPost) {
        TeacherRating rating = ratingToPost.getRating();
        if (rating == null) {
            rating = new TeacherRating(null);
        }
        loadData(api.sendTeacherRating(ratingToPost.getTeacher().getId(), rating), callback);
    }
}
