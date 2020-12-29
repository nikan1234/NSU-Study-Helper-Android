package ru.nsk.nsu.studyhelper.mvp.data.exams;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.data.common.BaseRepository;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.ServiceGenerator;
import ru.nsk.nsu.studyhelper.mvp.data.exams.remote.RemoteExamDetailsAPI;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.exam.ExamDetails;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.ExamCommentToPost;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.Mark;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.MarkToPost;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;

import java.util.List;

public class ExamDetailsRepository extends BaseRepository implements IExamDetailsDataSource {

    private static volatile ExamDetailsRepository instance;

    private final RemoteExamDetailsAPI api;

    private ExamDetailsRepository() {
        api = ServiceGenerator.createService(RemoteExamDetailsAPI.class);
    }

    public static ExamDetailsRepository getInstance() {
        ExamDetailsRepository localInstance = instance;
        if (localInstance == null) {
            synchronized (ExamDetailsRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ExamDetailsRepository();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void loadExamStatistics(final @NonNull ILoadCallback<ExamDetails> callback,
                                   final @NonNull Exam exam) {
        loadData(api.getExamStatistics(exam.getId()), callback);
    }

    @Override
    public void loadExamComments(final @NonNull ILoadCallback<CommentStatistics> callback,
                                 final @NonNull Exam exam) {
        loadData(api.getExamComments(exam.getId()), callback);
    }

    @Override
    public void loadExamTeacherList(@NonNull final ILoadCallback<List<Teacher>> callback,
                                    @NonNull final Exam exam) {
        loadData(api.getExamTeacherList(exam.getId()), callback);
    }

    @Override
    public void sendUserMark(final @NonNull IExamDetailsDataSource.ILoadCallback<Void> callback,
                             final @NonNull MarkToPost markToPost) {
        Mark mark = markToPost.getMark();
        if (mark == null) {
            mark = new Mark(null);
        }
        loadData(api.sendUserMark(markToPost.getExam().getId(), mark), callback);
    }

    @Override
    public void sendUserComment(final @NonNull IExamDetailsDataSource.ILoadCallback<Void> callback,
                             final @NonNull ExamCommentToPost comment) {
        loadData(api.sendUserComment(comment.getExam().getId(), comment.getComment()), callback);
    }
}
