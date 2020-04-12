package util;

import interfaces.ProjectProperties;
import lombok.Synchronized;
import org.aeonbits.owner.ConfigFactory;

import java.util.Objects;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public class ProjectPropertiesFactory {

    @Synchronized
    public static util.models.ProjectProperties getMyProperty() {
        ProjectProperties properties = ConfigFactory.create(ProjectProperties.class);

        String environment = null;

        if (System.getProperty("systemProp.env") == null) {
            environment = PropertiesReader.getProperty("env");
        }

        switch (requireNonNull(environment, "Environment properties shouldn't be null !!")) {
            case "dev":
                return new util.models.ProjectProperties(properties.uiDomainUrl(), properties.apiDomainUrl(), properties.suite(), properties.env());
            case "qa":
                properties.setProperty("ui.domain.url", "https://www.google.com");
                properties.setProperty("api.domain.url", "https://swapi.com");
                properties.setProperty("env", "qa");
                properties.setProperty("suite", "smoke");
                return new util.models.ProjectProperties(
                        properties.uiDomainUrl(),
                        properties.apiDomainUrl(),
                        properties.suite(),
                        properties.env());
            default:
                throw new IllegalArgumentException(format("Inappropriate environment was set: %s !!", environment));
        }
    }
}
