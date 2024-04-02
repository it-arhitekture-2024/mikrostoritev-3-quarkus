package si.um.feri.demo.rest;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class GradeResourceTest {

    @BeforeEach
    public void setup() {
        RestAssured.port = 8080;
    }

    @Test
    public void testGetAllGradesEndpoint() {
        // Using RestAssured for testing
        given()
                .when().get("/grades")
                .then()
                .statusCode(200);
    }

}
