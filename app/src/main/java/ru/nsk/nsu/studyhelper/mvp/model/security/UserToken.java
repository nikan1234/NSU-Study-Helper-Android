package ru.nsk.nsu.studyhelper.mvp.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class UserToken {
    @Getter
    @Setter
    private String token;
}
