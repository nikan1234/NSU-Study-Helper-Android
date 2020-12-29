package ru.nsk.nsu.studyhelper.mvp.presentation.common;

import android.view.Gravity;
import android.widget.Toast;
import dagger.android.support.DaggerFragment;

public abstract class BaseView extends DaggerFragment implements IBaseView {

    public void showError(final PresentationLayerError error) {
        final Toast toast = Toast.makeText(
                getActivity(),
                error.toString(),
                Toast.LENGTH_LONG);
        toast.show();
    }
}
