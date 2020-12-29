package ru.nsk.nsu.studyhelper.mvp.model.statistics.common;

import androidx.annotation.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@AllArgsConstructor
public class Mark implements Serializable {
    @Setter
    @Getter
    private Integer mark;

    @NonNull
    @NotNull
    @Override
    public String toString() {
        return Integer.toString(mark);
    }
}
