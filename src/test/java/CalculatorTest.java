import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by zsuleiman on 18/10/2017.
 */
public class CalculatorTest extends ResponseParser{


    private String reqResponse;
    private String randomIntOne;
    private String randomIntTwo;
    private String randomNegativeIntOne;
    private String randomNegativeIntTwo;
    private String randomFloatOne;
    private String randomFloatTwo;



    @Before
    public void setUp(){

        RestAssured.baseURI = "http://home-assignment.herokuapp.com/api/calculate/";
        RestAssured.authentication = basic("home", "test");
        randomIntOne = randomInt();
        randomIntTwo = randomInt();
        randomNegativeIntOne = randomNegativeInt();
        randomNegativeIntTwo = randomNegativeInt();
        randomFloatOne = randomFloat();
        randomFloatTwo = randomFloat();
    }

    @Test
    public void validInputAddingPositiveNumbers(){

        reqResponse = get(calculatorEndPoint("+",randomIntOne,randomIntTwo)).getBody().asString();

        assertThat(getResponseObjectValueAsInt(reqResponse,"result"),
                is(sumNumbers(randomIntOne,randomIntTwo)));
    }

    @Test
    public void simpleUserInput(){

        reqResponse = get(randomIntOne).getBody().asString();

        assertThat(getResponseObjectValueAsString(reqResponse,"result"),
                is((randomIntOne )));


    }

    @Test
    public void calculatorDigitsLimit(){

        reqResponse = get("11115").getBody().asString();

        assertThat(getResponseObjectValueAsString(reqResponse,"result"),
                is(("11115" )));

    }

    @Test
    public void calculatorDigitsOverLimit(){

        reqResponse = get("111151").getBody().asString();

        assertThat(getResponseObjectValueAsString(reqResponse,"exception"),
                is(("java.util.NoSuchElementException" )));

    }



    @Test
    public void invalidInput(){

        reqResponse = get(calculatorEndPoint("+","A","B")).getBody().asString();
        assertThat(getResponseObjectValueAsString(reqResponse,"exception"),
                is("java.util.NoSuchElementException"));
    }


    @Test
    public void addingNegativeNumbersTest(){

        reqResponse = get(calculatorEndPoint("+",randomNegativeIntOne,randomNegativeIntTwo)).getBody().asString();

        assertThat(getResponseObjectValueAsInt(reqResponse,"result"),
                is(sumNumbers(randomNegativeIntOne,randomNegativeIntTwo)));

    }

    @Test
    public void numberSubtraction(){

        reqResponse = get(calculatorEndPoint("-",randomIntOne,randomIntTwo)).getBody().asString();

        assertThat(getResponseObjectValueAsInt(reqResponse,"result"),
                is(subtractNumbers(randomIntOne,randomIntTwo)));

    }

    @Test(expected = AssertionError.class)
    public void numberDivision(){

        reqResponse = get(calculatorEndPoint("\"",randomIntOne,randomIntTwo)).getBody().asString();


        assertThat(getResponseObjectValueAsInt(reqResponse,"result"),
                is(divideNumbers(randomIntOne,randomIntTwo)));


    }

    @Test
    public void numberMultiplication(){

        reqResponse = get(calculatorEndPoint("*",randomIntOne,randomIntTwo)).getBody().asString();

        assertThat(getResponseObjectValueAsInt(reqResponse,"result"),
                is(multiplyNumbers(randomIntOne,randomIntTwo)));


    }

    @Test
    public void decimalNumberAddition(){

        reqResponse = get(calculatorEndPoint("+",randomFloatOne,randomFloatTwo)).getBody().asString();
        assertThat(getResponseObjectValueAsString(reqResponse,"exception"),
                is("java.util.NoSuchElementException"));

    }



}
