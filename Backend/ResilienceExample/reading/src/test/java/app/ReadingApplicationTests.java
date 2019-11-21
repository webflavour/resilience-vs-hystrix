package app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Before;
import org.junit.After;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.collection.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static io.github.resilience4j.circuitbreaker.CircuitBreaker.State;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.http.MediaType;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ResilienceApplication.class)
public class ReadingApplicationTests {

    //private static final String BACKEND_R = "backendR";
    private MockRestServiceServer server;

    @Autowired
    private CircuitBreakerRegistry registry;

    @Autowired
    private TestRestTemplate restTemplate;

//    @Before
//    public void setup() {
//        this.server = MockRestServiceServer;
//    }

    @After
    public void teardown() {
        this.server = null;
    }

    @Test
    public void contextLoads() {
    }

//    @Test
//    public void toReadTest() {
//        this.server.expect(requestTo("http://localhost:8080/recommended"))
//                .andExpect(method(HttpMethod.GET)).
//                andRespond(withSuccess("lists", MediaType.TEXT_PLAIN));
//        String lists = restTemplate.getForObject("/to-read", String.class);
//        assertThat(lists).isEqualTo("lists");
//    }
//
//    @Test
//    public void toReadFailureTest() {
//        this.server.expect(requestTo("http://localhost:8080/recommended")).
//                andExpect(method(HttpMethod.GET)).andRespond(withServerError());
//        String lists = restTemplate.getForObject("/to-read", String.class);
//        assertThat(lists).isEqualTo("Birne");
//    }

    private void checkHealthStatus(String circuitBreakerName, State state) {
        CircuitBreaker circuitBreaker = registry.circuitBreaker(circuitBreakerName);
        assertThat(circuitBreaker.getState()).isEqualTo(state);
    }

    private void produceFailure(String backend) {
        ResponseEntity<String> response = restTemplate.getForEntity("/" + backend + "/failure", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void produceSuccess(String backend) {
        ResponseEntity<String> response = restTemplate.getForEntity("/" + backend + "/success", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}



