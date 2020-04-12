import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static util.ProjectPropertiesFactory.getMyProperty;


@Epic("Wiki examples")
@Feature("Some feature")
public class WikiTest {

    @Test
    @Issue("Wiki-666")
    @TmsLink("TX-1")
    @Description("Test verifies if we have visible Wiki logo")
    public void testWiki() {
        String url = getMyProperty().getUiUrl();

        browser = "chrome";
        open(url);
        $(By.xpath("//*[@class='central-textlogo__image sprite svg-Wikipedia_wordmark']"))
                .shouldHave(text("Wikipedia"));
    }
}
