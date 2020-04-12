import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static util.ProjectPropertiesFactory.getMyProperty;

@Epic("Stack examples")
@Feature("Some feature")
public class StackTest {

    @Test
    @Issue("Stack-999")
    @TmsLink("TX-2")
    @Description("Test verifies if we have call open api")
    public void testStack() {
        String url = getMyProperty().getApiUrl();

        given()
                .filter(new AllureRestAssured())
                .log().all()
                .baseUri(url)
                .basePath("/2.2/answers?page=1&order=desc&sort=activity&site=stackoverflow")
                .queryParam("page", "1")
                .queryParam("order", "desc")
                .queryParam("sort", "activity")
                .queryParam("site", "stackoverflow")
                .get()
                .then().log().all()
                .assertThat().statusCode(SC_OK);
    }
}
