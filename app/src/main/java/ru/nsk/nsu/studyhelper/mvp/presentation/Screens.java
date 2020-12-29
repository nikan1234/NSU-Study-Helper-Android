package ru.nsk.nsu.studyhelper.mvp.presentation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.details.ExamDetailsFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.NewPasswordFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.RequestPasswordResetFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.searcher.SearcherFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_in.SignInFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_up.SignUpFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.ExamStatisticsFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.comments.ExamCommentsFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.details.TeacherDetailsFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.comments.TeacherCommentsFragment;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {
    public static final class SearcherScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new SearcherFragment();
        }
    }

    public static final class SignInScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new SignInFragment();
        }
    }

    public static final class SignUpScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new SignUpFragment();
        }
    }

    public static final class RequestPasswordResetScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new RequestPasswordResetFragment();
        }
    }

    public static final class NewPasswordScreen extends SupportAppScreen {
        private final String token;

        public NewPasswordScreen(final @NonNull  String token) {
            this.token = token;
        }

        @Override
        public Fragment getFragment() {
            return NewPasswordFragment.newInstance(token);
        }
    }

    public static final class ExamDetailsScreen extends SupportAppScreen {
        private final Exam exam;

        public ExamDetailsScreen(@NonNull final Exam exam) {
            this.exam = exam;
        }

        @Override
        public Fragment getFragment() {
            return ExamDetailsFragment.newInstance(exam);
        }
    }

    public static final class TeacherDetailsScreen extends SupportAppScreen {
        private final Teacher teacher;

        public TeacherDetailsScreen(@NonNull final Teacher teacher) {
            this.teacher = teacher;
        }

        @Override
        public Fragment getFragment() {
            return TeacherDetailsFragment.newInstance(teacher);
        }
    }

    public static final class ExamStatisticsScreen extends SupportAppScreen {
        private final Exam exam;

        public ExamStatisticsScreen(@NonNull final Exam exam) {
            this.exam = exam;
        }

        @Override
        public Fragment getFragment() {
            return ExamStatisticsFragment.newInstance(exam);
        }
    }

    public static final class ExamCommentsScreen extends SupportAppScreen {
        private final Exam exam;

        public ExamCommentsScreen(@NonNull final Exam exam) {
            this.exam = exam;
        }

        @Override
        public Fragment getFragment() {
            return ExamCommentsFragment.newInstance(exam);
        }
    }

    public static final class TeacherCommentsScreen extends SupportAppScreen {
        private final Teacher teacher;

        public TeacherCommentsScreen(@NonNull final Teacher teacher) {
            this.teacher = teacher;
        }

        @Override
        public Fragment getFragment() {
            return TeacherCommentsFragment.newInstance(teacher);
        }
    }
}
