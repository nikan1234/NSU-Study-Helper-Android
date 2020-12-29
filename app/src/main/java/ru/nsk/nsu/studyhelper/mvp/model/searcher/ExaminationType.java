package ru.nsk.nsu.studyhelper.mvp.model.searcher;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class ExaminationType implements Serializable {
    @Setter
    @Getter
    private int id;

    @Setter
    @Getter
    private String description;


}
