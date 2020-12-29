package ru.nsk.nsu.studyhelper.mvp.model.statistics.comments;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CommentStatistics {
    @Setter
    @Getter
    private CommentWithoutUser currentUserComment;

    @Setter
    @Getter
    private List<Comment> comments;
}
