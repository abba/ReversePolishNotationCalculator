import org.json.JSONObject;
/**
 * Created by zsuleiman on 18/10/2017.
 */
public class ResponseParser extends Calculator {



    public static String getResponseObjectValueAsString(String response, String objectName){

        return new JSONObject(response).get(objectName).toString();
    }

    public static Integer getResponseObjectValueAsInt(String response, String objectName){

        return Integer.parseInt(new JSONObject(response).get(objectName).toString());

    }
}
