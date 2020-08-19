import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PunkApiGetJSON {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.punkapi.com/v2/beers/1");

            JSONTokener tokener = new JSONTokener(url.openStream());
            JSONArray beers = new JSONArray(tokener);

            JSONObject beer = beers.getJSONObject(0);

            String beerName = beer.getString("name");
            System.out.println("Beer name = " + beerName);

            JSONObject ingredientsObject = beer.getJSONObject("ingredients");

            String hopsFirstName = ingredientsObject.getJSONArray("hops").getJSONObject(0).getString("name");
            System.out.println("Hops name = "+hopsFirstName);

            String maltFirstName = ingredientsObject.getJSONArray("malt").getJSONObject(0).getString("name");
            System.out.println("Malt name = "+maltFirstName);

            String yeastName = ingredientsObject.getString("yeast");
            System.out.println("Yeast name = "+yeastName);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
