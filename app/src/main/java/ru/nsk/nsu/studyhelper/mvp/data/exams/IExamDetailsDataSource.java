package ru.nsk.nsu.studyhelper.mvp.data.exams;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.data.common.IDataLoadCallback;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.exam.ExamDetails;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.ExamCommentToPost;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.MarkToPost;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;

import java.util.List;

public interface IExamDetailsDataSource {

    interface ILoadCallback<DataType> extends IDataLoadCallback<DataType> {}

    void loadExamStatistics(final @NonNull ILoadCallback<ExamDetails> callback,
                            final @NonNull Exam exam);
    void loadExamComments(final @NonNull ILoadCallback<CommentStatistics> callback,
                          final @NonNull Exam exam);
    void loadExamTeacherList(final @NonNull ILoadCallback<List<Teacher>> callback,
                             final @NonNull Exam exam);
    void sendUserMark(final @NonNull ILoadCallback<Void> callback,
                      final @NonNull MarkToPost mark);
    void sendUserComment(final @NonNull ILoadCallback<Void> callback,
                      final @NonNull ExamCommentToPost comment);
}
