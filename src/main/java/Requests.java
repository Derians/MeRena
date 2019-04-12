import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Ivan Chaykin
 * Date: 08.04.2019
 * Time: 12:06
 */
public class Requests {

    private String url = "https://api.themoviedb.org/3/";

    public SearchResult request(String type, Map<String, Object> parameters) {

        RequestBuilder requestBuilder = RequestBuilder.get(url + type + "?");
        ObjectMapper mapper = new ObjectMapper();

        if (!parameters.isEmpty()) {
            parameters.put("api_key", InitProperties.getConfig().getProperty("api_key"));
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                requestBuilder.addParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpResponse response = httpClient.execute(requestBuilder.build());

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

            return mapper.readValue(sb.toString(), SearchResult.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
