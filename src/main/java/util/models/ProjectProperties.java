package util.models;

import lombok.*;

public class ProjectProperties {

    private String uiUrl;
    private String apiUrl;
    private String suite;
    private String env;

    public ProjectProperties() {
    }

    public ProjectProperties(String uiUrl, String apiUrl, String suite, String env) {
        this.uiUrl = uiUrl;
        this.apiUrl = apiUrl;
        this.suite = suite;
        this.env = env;
    }

    public String getUiUrl() {
        return uiUrl;
    }

    public void setUiUrl(String uiUrl) {
        this.uiUrl = uiUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
