import org.apache.commons.lang.math.RandomUtils;

/**
 * Created by zsuleiman on 18/10/2017.
 */
public class Calculator {

    public static String randomInt(){

        Integer random = RandomUtils.nextInt(10);

        return random.toString();

    }

    public static String randomNegativeInt(){

        Integer random = RandomUtils.nextInt(10) -10;

        return random.toString();
    }

    public static String randomFloat(){

        Float random =RandomUtils.nextFloat();

        return random.toString();

    }

    public static String calculatorEndPoint(String operator, String operandA, String operandB ){

        StringBuilder calculate = new StringBuilder();

        return calculate.append(operator+ " "+ operandA+" " + operandB+" ").toString();
    }

    public static Integer sumNumbers(String a, String b){

        return Integer.parseInt(a)+Integer.parseInt(b);
    }

    public static Integer subtractNumbers(String a, String b){

        return Integer.parseInt(a)-Integer.parseInt(b);
    }

    public static Integer divideNumbers(String a, String b){

        return Integer.parseInt(a)/Integer.parseInt(b);
    }

    public static Integer multiplyNumbers(String a, String b){

        return Integer.parseInt(a)*Integer.parseInt(b);
    }

}
