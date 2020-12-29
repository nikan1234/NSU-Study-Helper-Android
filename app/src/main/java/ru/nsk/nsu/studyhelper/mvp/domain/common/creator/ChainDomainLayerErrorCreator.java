package ru.nsk.nsu.studyhelper.mvp.domain.common.creator;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.errors.InvalidArgsError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.errors.NetworkError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.errors.ServerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.errors.UnknownError;

import java.util.ArrayList;

public class ChainDomainLayerErrorCreator implements IDomainLayerErrorCreator {
    private static class ServerErrorCreator implements IDomainLayerErrorCreator {
        private static final int INTERNAL_SERVER_ERROR_CODE = 500;
        @Override
        public DomainLayerError process(@NonNull DataLayerError dataLayerError) {
            if (dataLayerError.getStatus() == INTERNAL_SERVER_ERROR_CODE) {
                return new ServerError();
            }
            return null;
        }
    }

    private static class NetworkErrorCreator implements IDomainLayerErrorCreator {
        private static final int RETROFIT_ERROR_CODE = -1;
        @Override
        public DomainLayerError process(@NonNull DataLayerError dataLayerError) {
            if (dataLayerError.getStatus() == RETROFIT_ERROR_CODE) {
                return new NetworkError();
            }
            return null;
        }
    }

    private static class BadRequestErrorCreator implements IDomainLayerErrorCreator {
        private static final int BAD_REQUEST_ERROR_CODE = 400;
        @Override
        public DomainLayerError process(@NonNull DataLayerError dataLayerError) {
            if (dataLayerError.getStatus() == BAD_REQUEST_ERROR_CODE) {
                return new InvalidArgsError(dataLayerError.getErrorMessage());
            }
            return null;
        }
    }

    private static class UnknownErrorCreator implements IDomainLayerErrorCreator {
        @Override
        public DomainLayerError process(@NonNull DataLayerError dataLayerError) {
            return new UnknownError();
        }
    }

    private final ArrayList<IDomainLayerErrorCreator> domainLayerErrorCreators;

    public void addDomainLayerErrorCreator(IDomainLayerErrorCreator domainLayerErrorCreator) {
        domainLayerErrorCreators.add(0, domainLayerErrorCreator);
    }

    public ChainDomainLayerErrorCreator() {
        domainLayerErrorCreators = new ArrayList<>();
        addDomainLayerErrorCreator(new UnknownErrorCreator());
        addDomainLayerErrorCreator(new ServerErrorCreator());
        addDomainLayerErrorCreator(new NetworkErrorCreator());
        addDomainLayerErrorCreator(new BadRequestErrorCreator());
    }

    @Override
    public DomainLayerError process(@NonNull DataLayerError dataLayerError) {
        for (IDomainLayerErrorCreator domainLayerErrorCreator: domainLayerErrorCreators) {
            DomainLayerError domainLayerError = domainLayerErrorCreator.process(dataLayerError);
            if (domainLayerError != null) {
                return domainLayerError;
            }
        }
        return null;
    }
}

