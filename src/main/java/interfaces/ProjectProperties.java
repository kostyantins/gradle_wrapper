package interfaces;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Mutable;

@Config.Sources({
        "classpath:config.properties"
})
public interface ProjectProperties extends Mutable {

    @Key("ui.domain.url")
    String uiDomainUrl();

    @Key("api.domain.url")
    String apiDomainUrl();

    @Key("suite")
    String suite();

    @Key("env")
    String env();
}

