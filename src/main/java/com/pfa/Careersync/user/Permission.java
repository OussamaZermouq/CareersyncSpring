package com.pfa.Careersync.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    CANDIDAT_READ("candidat:read"),
    CANDIDAT_UPDATE("candidat:update"),
    CANDIDAT_CREATE("candidat:create"),
    CANDIDAT_DELETE("candidat:delete");
    @Getter
    private final String permission;
}
