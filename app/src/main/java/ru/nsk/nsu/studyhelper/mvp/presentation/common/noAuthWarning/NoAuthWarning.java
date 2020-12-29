package ru.nsk.nsu.studyhelper.mvp.presentation.common.noAuthWarning;

import android.content.Context;
import android.widget.Toast;
import ru.nsk.nsu.studyhelper.R;

public class NoAuthWarning {

    public static void showWarning(final Context context) {
        Toast.makeText(
                context,
                context.getString(R.string.auth_warning_title),
                Toast.LENGTH_LONG)
                .show();
    }
}
