package utils;

import lombok.Getter;

@Getter
public enum APIResources {
    AddResource("/api/users"),
    GetorPutorDeleteResource("/api/users/{path}"),
    GetList("/api/users");
    private String resource;

    APIResources(String resource) {
        this.resource= resource;
    }
}
