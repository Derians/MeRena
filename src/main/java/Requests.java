import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

/**
 * Created by Ivan Chaykin
 * Date: 08.04.2019
 * Time: 12:06
 */
public class Requests {

    public String get(String title, String year){

        try {
            String api_key = "";
            String url = "https://api.themoviedb.org/3/search/movie?";
            String release_year = "";
            if (year != null) {
                release_year = "&primary_release_year="+year;
            }

            String request = "api_key=" + api_key
                    + "&language=ru-RU"
                    + "&page=1"
                    + "&include_adult=true"
                    + "&query=" + URLEncoder.encode(title, "UTF-8")
                    + release_year;

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(url + request);
            getRequest.addHeader("accept", "application/json");

            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            StringBuilder sb = new StringBuilder();

            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            httpClient.close();

            return sb.toString();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }
}
