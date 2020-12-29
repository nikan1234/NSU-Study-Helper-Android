package ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.marks;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.Mark;

import java.util.function.Consumer;

public class MarkSelectorPopup {

    @BindView(R.id.mark_list_selector)
    RecyclerView markListSelector;

    private final PopupWindow markSelectWindow;
    private final View popupView;

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 800;

    public MarkSelectorPopup(final Context context,
                             final @NonNull Consumer<Mark> consumer) {
        popupView = LayoutInflater.from(context).inflate(R.layout.mark_selector_popup, null);
        ButterKnife.bind(this, popupView);

        markSelectWindow = new PopupWindow(popupView, WINDOW_WIDTH, WINDOW_HEIGHT, true);

        MarkListAdapter adapter = new MarkListAdapter(consumer);
        markListSelector.setLayoutManager(new LinearLayoutManager(context));
        markListSelector.setAdapter(adapter);
    }

    @OnClick(R.id.mark_cancel_button)
    void onCancelButtonClicked() {
        markSelectWindow.dismiss();
    }

    public void show() {
        markSelectWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
    }

    public void close() {
        markSelectWindow.dismiss();
    }
}
