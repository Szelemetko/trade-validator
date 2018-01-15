package pl.szelemetko.tradeValidator;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class DemoApplicationTests {


		private static final String JSON_FOLDER = "src/test/resources/json/";
		private static final String FORWARD_CORRECT_JSON = "forward-correct.json";
		
	    @LocalServerPort
	    private Integer port;
	    
	    @Test
	    public void correctTradeGeneratesNoErrors() throws Exception {
	    	
	        given()
	        	.port(port)
	        	.log().all()
	        	.header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
	        	.body(new File(JSON_FOLDER + FORWARD_CORRECT_JSON))
	        .when()
	        	.post("/validate/")
	        .then()
	            .assertThat()
	            	.statusCode(OK.value())
	            	.body("valid", is(true));
	    }
}
