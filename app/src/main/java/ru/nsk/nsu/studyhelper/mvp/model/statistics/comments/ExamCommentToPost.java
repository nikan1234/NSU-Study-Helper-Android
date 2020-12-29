package ru.nsk.nsu.studyhelper.mvp.model.statistics.comments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;

@AllArgsConstructor
public class ExamCommentToPost {
    @Setter
    @Getter
    private Exam exam;

    @Setter
    @Getter
    private CommentWithoutUser comment;
}

