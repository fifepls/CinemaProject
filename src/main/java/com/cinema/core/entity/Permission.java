package com.cinema.core.entity;

public enum Permission {
    ADMIN_ADD_HALL("admin:addHall"),
    ADMIN_REM_HALL("admin:remHall"),
    ADMIN_ADD_FILM("admin:addFilm"),
    ADMIN_REM_FILM("admin:remFilm"),
    ADMIN_UPDATE_FILM("admin:updateFilm"),
    ADMIN_GET_ALL_FILMS("admin:getAllFilms"),
    ADMIN_ADD_SESSION("admin:addSession"),
    ADMIN_REM_SESSION("admin:remSession"),
    ADMIN_GET_ALL_SESSIONS("admin:getAllSessions");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
