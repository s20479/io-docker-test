package com.example.io_backend.auth.constants;

public class KeycloakApiConstants {
    public static final String USERS = "/admin/realms/{REALM}/users";
    public static final String ROLE_MAPPING = "/admin/realms/{REALM}/users/{USER_ID}/role-mappings/realm";
    public static final String DELETE_USER = USERS + "/{USER_ID}";
    public static final String RESET_PASSWORD = USERS + "/{USER_ID}/" + "reset-password";

    public static final String TOKEN = "/realms/{REALM}/protocol/openid-connect/token";
    public static final String ROLES = "/admin/realms/dev/roles";

    public static String createURL(String base, String template, String replacement) {
        return base.replace(template, replacement);
    }
}
