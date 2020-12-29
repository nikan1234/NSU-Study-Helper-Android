package ru.nsk.nsu.studyhelper.mvp.model.statistics.comments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;

@AllArgsConstructor
public class TeacherCommentToPost {
    @Setter
    @Getter
    private Teacher teacher;

    @Setter
    @Getter
    private CommentWithoutUser comment;
}
