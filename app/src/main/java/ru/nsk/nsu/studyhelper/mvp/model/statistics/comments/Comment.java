package ru.nsk.nsu.studyhelper.mvp.model.statistics.comments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.User;

@AllArgsConstructor
public class Comment {
    @Setter
    @Getter
    private User user;

    @Setter
    @Getter
    private String commentText;
}
