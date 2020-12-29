package ru.nsk.nsu.studyhelper.mvp.model.statistics.comments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class CommentWithoutUser {
    @Setter
    @Getter
    private String commentText;
}
