package ru.nsk.nsu.studyhelper.mvp.data.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class DataLayerError {
    @Getter
    @Setter
    private int status;

    @Getter
    @Setter
    private String errorMessage;
}
