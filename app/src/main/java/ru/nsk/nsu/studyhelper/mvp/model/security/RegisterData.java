package ru.nsk.nsu.studyhelper.mvp.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RegisterData {
    @Getter
    private String name;

    @Getter
    private String email;

    @Getter
    private String password;
}
