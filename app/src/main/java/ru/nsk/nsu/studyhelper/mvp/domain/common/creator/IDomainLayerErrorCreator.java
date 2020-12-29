package ru.nsk.nsu.studyhelper.mvp.domain.common.creator;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;

public interface IDomainLayerErrorCreator {
    DomainLayerError process(@NonNull final DataLayerError dataLayerError);
}
