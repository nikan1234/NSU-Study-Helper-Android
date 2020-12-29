package ru.nsk.nsu.studyhelper.mvp.data.teachers;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.data.common.IDataLoadCallback;
import ru.nsk.nsu.studyhelper.mvp.data.exams.IExamDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.TeacherCommentToPost;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherDetails;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherRatingToPost;

public interface ITeacherDetailsDataSource {

    interface ILoadCallback<DataType> extends IDataLoadCallback<DataType> {}

    void loadTeacherDetails(final @NonNull ILoadCallback<TeacherDetails> callback,
                            final @NonNull Teacher teacher);
    void loadTeacherComments(final @NonNull ILoadCallback<CommentStatistics> callback,
                             final @NonNull Teacher teacher);
    void sendUserComment(final @NonNull IExamDetailsDataSource.ILoadCallback<Void> callback,
                         final @NonNull TeacherCommentToPost comment);
    void sendTeacherRating(final @NonNull IExamDetailsDataSource.ILoadCallback<Void> callback,
                           final @NonNull TeacherRatingToPost rating);
}
