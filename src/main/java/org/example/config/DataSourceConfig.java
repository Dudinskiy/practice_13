package org.example.config;

public class DataSourceConfig {
    private String url = "jdbc:postgresql://localhost:5432/practice_13";
    private String userName = "postgres";
    private String password = "admin";
    private String driver = "org.postgresql.Driver";

    public DataSourceConfig() {
        super();
    }

    public DataSourceConfig(String url, String userName, String password, String driver) {
        this.url = url;
        this.userName = userName;
        this.password = password;
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "DataSourceConfig{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
