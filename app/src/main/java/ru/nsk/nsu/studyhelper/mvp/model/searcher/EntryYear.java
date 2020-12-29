package ru.nsk.nsu.studyhelper.mvp.model.searcher;

import androidx.annotation.NonNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class EntryYear implements Serializable {
    @Setter
    @Getter
    private int entryYear;

    @Override
    public @NonNull
    String toString() {
        return Integer.toString(entryYear);
    }


}
