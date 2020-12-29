package ru.nsk.nsu.studyhelper.mvp.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class NewPasswordData {
    @Setter
    @Getter
    private String newPassword;

    @Setter
    @Getter
    private UserToken token;
}
