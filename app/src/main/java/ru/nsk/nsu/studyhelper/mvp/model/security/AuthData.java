package ru.nsk.nsu.studyhelper.mvp.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class AuthData {
    @Getter
    private String login;

    @Getter
    private String password;
}
