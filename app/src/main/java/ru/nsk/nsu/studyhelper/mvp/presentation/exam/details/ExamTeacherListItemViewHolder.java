package ru.nsk.nsu.studyhelper.mvp.presentation.exam.details;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.StudyHelperApplication;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.presentation.Screens;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;

public class ExamTeacherListItemViewHolder extends RecyclerView.ViewHolder {

    @Inject
    Router router;

    @BindView(R.id.item_teacher_first_name)
    TextView teacherFirstName;

    @BindView(R.id.item_teacher_middle_name)
    TextView teacherMiddleName;

    @BindView(R.id.item_teacher_last_name)
    TextView teacherLastName;

    private Teacher item;

    public ExamTeacherListItemViewHolder(final @NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        StudyHelperApplication.INSTANCE
                .androidInjector()
                .inject(this);

        itemView.setOnClickListener(onItemClickListener());
    }

    void onBind(final Teacher item) {
        this.item = item;

        teacherFirstName.setText(item.getFirstName());
        teacherMiddleName.setText(item.getMiddleName());
        teacherLastName.setText(item.getLastName());
    }

    private View.OnClickListener onItemClickListener() {
        return view -> {
            if (null == item) {
                return;
            }
            router.navigateTo(new Screens.TeacherDetailsScreen(item));
        };
    }
}
