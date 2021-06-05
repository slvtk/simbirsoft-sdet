package config;

import java.util.Properties;

public class Configurations {
    public static String LOGIN_PAGE_URL;
    public static String HUB_URL;
    public static String BROWSER;
    public static String EMAIL;
    public static String PASSWORD;
    public static String SEARCH_QUERY;
    public static String SUBJECT;

    public static void init(Properties properties) {
        LOGIN_PAGE_URL = properties.getProperty("navigation.url.login");
        HUB_URL = properties.getProperty("grid.url.hub");
        BROWSER = properties.getProperty("grid.hub.browser");
        EMAIL = properties.getProperty("gmail.login");
        PASSWORD = properties.getProperty("gmail.password");
        SEARCH_QUERY = properties.getProperty("inbox.searchQuery");
        SUBJECT = properties.getProperty("email.subject");
    }
}
