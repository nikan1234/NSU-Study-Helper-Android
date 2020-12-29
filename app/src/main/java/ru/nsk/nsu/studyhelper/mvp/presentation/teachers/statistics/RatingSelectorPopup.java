package ru.nsk.nsu.studyhelper.mvp.presentation.teachers.statistics;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherRating;

import java.util.function.Consumer;

public class RatingSelectorPopup {

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 400;

    private final PopupWindow ratingSelectWindow;
    private final View popupView;

    @BindView(R.id.teacher_rating_bar)
    RatingBar ratingBar;

    private final Consumer<TeacherRating> consumer;

    public RatingSelectorPopup(final Context context,
                               final @NonNull Consumer<TeacherRating> consumer) {
        this.consumer = consumer;
        this.popupView = LayoutInflater.from(context).inflate(R.layout.rating_selector_popup, null);
        ButterKnife.bind(this, popupView);

        this.ratingSelectWindow = new PopupWindow(popupView, WINDOW_WIDTH, WINDOW_HEIGHT, true);
    }

    @OnClick(R.id.rating_accept_button)
    void onAcceptButtonClicked() {
        int value = (int)ratingBar.getRating();
        if (value > 0) {
            consumer.accept(new TeacherRating(value));
        } else {
            consumer.accept(new TeacherRating(null));
        }
        ratingSelectWindow.dismiss();
    }


    @OnClick(R.id.rating_cancel_button)
    void onCancelButtonClicked() {
        ratingSelectWindow.dismiss();
    }

    public void show() {
        ratingSelectWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
    }

    public void close() {
        ratingSelectWindow.dismiss();
    }
}
