package ru.nsk.nsu.studyhelper.dagger.module.presentation;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.exams.details.ExamDetailsModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.exams.details.ExamDetailsViewModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.reset_password.NewPasswordModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.reset_password.NewPasswordViewModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.reset_password.RequestPasswordResetModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.reset_password.RequestPasswordResetViewModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.searcher.SearcherModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.searcher.SearcherViewModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.sign_in.SignInModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.sign_in.SignInViewModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.sign_up.SignUpModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.sign_up.SignUpViewModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.exams.statistics.ExamStatisticsModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.exams.statistics.ExamStatisticsViewModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.exams.comments.ExamCommentsModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.exams.comments.ExamCommentsViewModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.teachers.comments.TeacherCommentsModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.teachers.comments.TeacherCommentsViewModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.teachers.details.TeacherDetailsModule;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.teachers.details.TeacherDetailsViewModule;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.details.ExamDetailsFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.details.ExamTeacherListItemViewHolder;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.NewPasswordFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.RequestPasswordResetFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.searcher.SearcherFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_in.SignInFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_up.SignUpFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.start.StartActivity;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.lists.CommentListItemViewHolder;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.ExamStatisticsFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.comments.ExamCommentsFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.details.TeacherDetailsFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.comments.TeacherCommentsFragment;

@Module
public abstract class ViewBindersModule {

    @ContributesAndroidInjector
    abstract StartActivity bindStartActivity();

    @ContributesAndroidInjector
    abstract ExamTeacherListItemViewHolder bindTeacherListItemViewHolder();

    @ContributesAndroidInjector
    abstract CommentListItemViewHolder bindCommentListItemViewHolder();

    @ContributesAndroidInjector(modules = {SearcherViewModule.class, SearcherModule.class})
    abstract SearcherFragment bindSearcherFragment();

    @ContributesAndroidInjector(modules = {SignInViewModule.class, SignInModule.class})
    abstract SignInFragment bindSignInFragment();

    @ContributesAndroidInjector(modules = {SignUpViewModule.class, SignUpModule.class})
    abstract SignUpFragment bindSignUpFragment();

    @ContributesAndroidInjector(modules = {RequestPasswordResetViewModule.class, RequestPasswordResetModule.class})
    abstract RequestPasswordResetFragment bindRequestPasswordResetFragment();

    @ContributesAndroidInjector(modules = {NewPasswordViewModule.class, NewPasswordModule.class})
    abstract NewPasswordFragment bindNewPasswordFragment();

    @ContributesAndroidInjector(modules = {ExamDetailsViewModule.class, ExamDetailsModule.class})
    abstract ExamDetailsFragment bindInformationFragment();

    @ContributesAndroidInjector(modules = {ExamStatisticsViewModule.class, ExamStatisticsModule.class})
    abstract ExamStatisticsFragment bindSubjectStatisticsFragment();

    @ContributesAndroidInjector(modules = {ExamCommentsViewModule.class, ExamCommentsModule.class})
    abstract ExamCommentsFragment bindSubjectCommentsFragment();

    @ContributesAndroidInjector(modules = {TeacherDetailsViewModule.class, TeacherDetailsModule.class})
    abstract TeacherDetailsFragment bindTeacherDetailsFragment();

    @ContributesAndroidInjector(modules = {TeacherCommentsViewModule.class, TeacherCommentsModule.class})
    abstract TeacherCommentsFragment bindTeacherCommentsFragment();
}