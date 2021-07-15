package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class steps {
    private Response response;
    @When("I check the details of student {int}")
    public void iCheckTheDetailsOfStudent(int arg0) {
        RestAssured.baseURI = "https://it-foundations.app.ap.assurity.cloud/";
        RestAssured.defaultParser = Parser.JSON;
        response = RestAssured.get("people/" + arg0);


    }

    @Then("I can see that their name is {string}")
    public void iCanSeeThatTheirNameIsJaneJones(String arg0) {

        String temp = response.path("firstName") +" "+response.path("lastName");

        assertEquals(temp,arg0 );
    }

    @And("they have a {string} from {string}")
    public void theyHaveABScComputerScienceFromSydneyTechSchool(String arg0, String arg2) {
        assertEquals(response.path("degree"),arg0 );
        assertEquals(response.path("university"),arg2 );
    }
}
