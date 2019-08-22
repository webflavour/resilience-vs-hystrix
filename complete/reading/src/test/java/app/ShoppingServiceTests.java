package app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


@RunWith(SpringRunner.class)
@RestClientTest(ShoppingService.class)
public class ShoppingServiceTests {

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void readingListTest() {
        this.server.expect(requestTo("http://localhost:8090/recommended"))
                .andRespond(withSuccess("lists", MediaType.TEXT_PLAIN));
        assertThat(shoppingService.readingList()).isEqualTo("lists");
    }

    @Test
    public void reliable() {
        assertThat(shoppingService.reliable()).isEqualTo("Birne");
    }
}
